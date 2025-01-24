package net.kaupenjoe.mccourse.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType DRIFTWOOD = WoodTypeRegistry.register(new ResourceLocation(MCCourseMod.MOD_ID, "driftwood"), BlockSetType.OAK);
}
