package net.kaupenjoe.mccourse.screen;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class KaupenFurnaceScreen extends AbstractFurnaceScreen<KaupenFurnaceScreenHandler> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MCCourseMod.MOD_ID, "textures/gui/kaupen_furnace.png");
    private static final ResourceLocation LIT_PROGRESS_TEXTURE = new ResourceLocation("container/furnace/lit_progress");
    private static final ResourceLocation BURN_PROGRESS_TEXTURE = new ResourceLocation("container/furnace/burn_progress");

    public KaupenFurnaceScreen(KaupenFurnaceScreenHandler handler, Inventory inventory, Component title) {
        super(handler, new KaupenFurnaceRecipeBookComponent(), inventory, title, TEXTURE, LIT_PROGRESS_TEXTURE, BURN_PROGRESS_TEXTURE);
    }
}
