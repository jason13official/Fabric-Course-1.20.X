package net.kaupenjoe.mccourse.screen;

import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import java.util.Set;

public class KaupenFurnaceRecipeBookComponent extends AbstractFurnaceRecipeBookComponent {
    @Override
    protected Set<Item> getFuelItems() {
        return Set.of(ModItems.PEAT_BRICK, ModItems.DICE, Items.BLAZE_POWDER);
    }
}
