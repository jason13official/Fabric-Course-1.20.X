package net.kaupenjoe.mccourse.block.entity;

import net.kaupenjoe.mccourse.item.ModItems;
import net.kaupenjoe.mccourse.recipe.KaupenFurnaceRecipe;
import net.kaupenjoe.mccourse.screen.KaupenFurnaceScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Map;

public class KaupenFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    private Map<Item, Integer> BURN_DURATION_MAP = Map.of(
            ModItems.PEAT_BRICK, 100,
            ModItems.DICE, 200,
            Items.BLAZE_POWDER, 600);

    public KaupenFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.KAUPEN_FURNACE_BE, pos, state, KaupenFurnaceRecipe.Type.INSTANCE);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.mccourse.kaupen_furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return new KaupenFurnaceScreenHandler(syncId, playerInventory, this, this.dataAccess);
    }

    @Override
    protected int getBurnDuration(ItemStack fuel) {
        return BURN_DURATION_MAP.getOrDefault(fuel.getItem(), 0);
    }
}
