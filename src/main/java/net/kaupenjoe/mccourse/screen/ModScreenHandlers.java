package net.kaupenjoe.mccourse.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ModScreenHandlers {
    public static final MenuType<GemEmpoweringScreenHandler> GEM_EMPOWERING_SCREEN_HANDLER =
            Registry.register(BuiltInRegistries.MENU, new ResourceLocation(MCCourseMod.MOD_ID, "gem_empowering_screen_handler"),
                    new ExtendedScreenHandlerType<>(GemEmpoweringScreenHandler::new));

    public static final MenuType<KaupenFurnaceScreenHandler> KAUPEN_FURNACE_SCREEN_HANDLER =
            Registry.register(BuiltInRegistries.MENU, new ResourceLocation(MCCourseMod.MOD_ID, "kaupen_furnace_screen_handler"),
                    new MenuType<>(KaupenFurnaceScreenHandler::new, FeatureFlags.VANILLA_SET));


    public static void registerScreenHandler() {
        MCCourseMod.LOGGER.info("Registering Screen Handlers for " + MCCourseMod.MOD_ID);
    }
}
