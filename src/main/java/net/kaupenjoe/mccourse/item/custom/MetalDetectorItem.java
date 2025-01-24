package net.kaupenjoe.mccourse.item.custom;

import net.kaupenjoe.mccourse.item.ModItems;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.kaupenjoe.mccourse.util.InventoryUtil;
import net.kaupenjoe.mccourse.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(!context.getLevel().isClientSide()) {
            BlockPos positionClicked = context.getClickedPos();
            Player player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = context.getLevel().getBlockState(positionClicked.below(i));
                Block block = blockState.getBlock();

                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.below(i), player, block);
                    foundBlock = true;

                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET)) {
                        addNbtDataToDataTablet(player, positionClicked.below(i), block);
                    }

                    spawnFoundParticles(context, positionClicked, blockState);

                    context.getLevel().playSound(null, positionClicked, ModSounds.METAL_DETECTOR_FOUND_ORE,
                            SoundSource.BLOCKS, 1f, 1f);

                    break;
                }
            }

            if(!foundBlock) {
                player.sendSystemMessage(Component.translatable("item.mccourse.metal_detector.no_valuables"));
            }
        }

        context.getItemInHand().hurtAndBreak(1, context.getPlayer(),
                playerEntity -> playerEntity.broadcastBreakEvent(playerEntity.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void spawnFoundParticles(UseOnContext context, BlockPos positionClicked, BlockState blockState) {
        for(int i = 0; i < 20; i++) {
            ServerLevel world = ((ServerLevel) context.getLevel());

            world.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockState),
                    positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d, 2,
                    Math.cos(i * 18) * 0.25d, 0.15d, Math.sin(i * 18) * 0.25d, 5f);
        }
    }

    private void addNbtDataToDataTablet(Player player, BlockPos position, Block block) {
        ItemStack dataTabletStack = player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET));

        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("mccourse.last_valuable_found", "Valuable Found: " + block.getName().getString() + " at " +
                "(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")");

        dataTabletStack.setTag(nbtData);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.mccourse.metal_detector.tooltip.shift"));
        } else {
            tooltip.add(Component.translatable("tooltip.mccourse.metal_detector.tooltip"));
        }
    }

    private void outputValuableCoordinates(BlockPos position, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Valuable Found: " + block.getName().getString() + " at " +
                "(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
    }
}
