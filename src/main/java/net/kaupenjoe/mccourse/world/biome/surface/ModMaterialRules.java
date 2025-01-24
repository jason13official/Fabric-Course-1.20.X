package net.kaupenjoe.mccourse.world.biome.surface;

import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.world.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModMaterialRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource PINK_GARNET = makeStateRule(ModBlocks.PINK_GARNET_BLOCK);
    private static final SurfaceRules.RuleSource RAW_PINK_GARNET = makeStateRule(ModBlocks.RAW_PINK_GARNET_BLOCK);

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TEST_BIOME),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, RAW_PINK_GARNET)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, PINK_GARNET)),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TEST_BIOME_2),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, RAW_PINK_GARNET)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, PINK_GARNET)),


                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
