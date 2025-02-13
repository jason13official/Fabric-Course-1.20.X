package net.kaupenjoe.mccourse.block.custom;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SoundBlock extends Block {
    public SoundBlock(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos,
                              Player player, InteractionHand hand, BlockHitResult hit) {
        if(player.isShiftKeyDown()) {
            world.playSound(player, pos, SoundEvents.NOTE_BLOCK_BANJO.value(), SoundSource.BLOCKS, 1f, 1f);
            return InteractionResult.SUCCESS;
        } else {
            world.playSound(player, pos, SoundEvents.NOTE_BLOCK_COW_BELL.value(), SoundSource.BLOCKS, 1f, 1f);
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        world.playSound(entity, pos, SoundEvents.NOTE_BLOCK_BIT.value(), SoundSource.BLOCKS, 1f, 1f);
        super.stepOn(world, pos, state, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag options) {
        tooltip.add(Component.translatable("tooltip.mccourse.sound_block"));
    }
}
