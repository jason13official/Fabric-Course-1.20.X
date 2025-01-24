package net.kaupenjoe.mccourse.painting;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class ModPaintings {
    public static final PaintingVariant SAW_THEM = registerPainting("saw_them", new PaintingVariant(16, 16));
    public static final PaintingVariant SHRIMP = registerPainting("shrimp", new PaintingVariant(32, 16));
    public static final PaintingVariant WORLD = registerPainting("world", new PaintingVariant(32, 32));


    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(BuiltInRegistries.PAINTING_VARIANT, new ResourceLocation(MCCourseMod.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
        MCCourseMod.LOGGER.info("Registering Paintings for " + MCCourseMod.MOD_ID);
    }
}
