package net.kaupenjoe.mccourse.screen;

import net.kaupenjoe.mccourse.block.entity.KaupenFurnaceBlockEntity;
import net.kaupenjoe.mccourse.recipe.KaupenFurnaceRecipe;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;

public class KaupenFurnaceScreenHandler extends AbstractFurnaceMenu {
    public KaupenFurnaceScreenHandler(int syncId, Inventory playerInventory) {
        super(ModScreenHandlers.KAUPEN_FURNACE_SCREEN_HANDLER, KaupenFurnaceRecipe.Type.INSTANCE, RecipeBookType.FURNACE, syncId, playerInventory);
    }

    public KaupenFurnaceScreenHandler(int syncId, Inventory playerInventory, KaupenFurnaceBlockEntity blockEntity, ContainerData propertyDelegate) {
        super(ModScreenHandlers.KAUPEN_FURNACE_SCREEN_HANDLER, KaupenFurnaceRecipe.Type.INSTANCE, RecipeBookType.FURNACE, syncId, playerInventory, blockEntity, propertyDelegate);
    }

    @Override
    protected boolean isFuel(ItemStack itemStack) {
        return true;
    }
}
