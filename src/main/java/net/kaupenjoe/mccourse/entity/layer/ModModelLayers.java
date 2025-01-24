package net.kaupenjoe.mccourse.entity.layer;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation PORCUPINE =
            new ModelLayerLocation(new ResourceLocation(MCCourseMod.MOD_ID, "porcupine"), "main");

    public static final ModelLayerLocation MAGIC_PROJECTILE =
            new ModelLayerLocation(new ResourceLocation(MCCourseMod.MOD_ID, "magic_projectile"), "main");
}
