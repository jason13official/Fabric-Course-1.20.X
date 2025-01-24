package net.kaupenjoe.mccourse.world;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.world.tree.custom.DriftwoodFoliagePlacer;
import net.kaupenjoe.mccourse.world.tree.custom.DriftwoodTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRIFTWOOD_KEY = registerKey("driftwood");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_GARNET_ORE_KEY = registerKey("pink_garnet_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_PINK_GARNET_ORE_KEY = registerKey("nether_pink_garnet_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_PINK_GARNET_ORE_KEY = registerKey("end_pink_garnet_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PETUNIA_KEY = registerKey("petunia");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_GARNET_GEODE_KEY = registerKey("pink_garnet_geode");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);


        List<OreConfiguration.TargetBlockState> overworldPinkGarnetOres =
                List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.PINK_GARNET_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_PINK_GARNET_ORE.defaultBlockState()));

        List<OreConfiguration.TargetBlockState> netherPinkGarnetOres =
                List.of(OreConfiguration.target(netherReplaceables, ModBlocks.NETHER_PINK_GARNET_ORE.defaultBlockState()));

        List<OreConfiguration.TargetBlockState> endPinkGarnetOres =
                List.of(OreConfiguration.target(endReplaceables, ModBlocks.END_STONE_PINK_GARNET_ORE.defaultBlockState()));

        register(context, DRIFTWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.DRIFTWOOD_LOG),
                new DriftwoodTrunkPlacer(5, 6, 3),
                BlockStateProvider.simple(ModBlocks.DRIFTWOOD_LEAVES),
                new DriftwoodFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.END_STONE)).build());

        register(context, PINK_GARNET_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPinkGarnetOres, 12));
        register(context, NETHER_PINK_GARNET_ORE_KEY, Feature.ORE, new OreConfiguration(netherPinkGarnetOres, 9));
        register(context, END_PINK_GARNET_ORE_KEY, Feature.ORE, new OreConfiguration(endPinkGarnetOres, 8));

        register(context, PETUNIA_KEY, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PETUNIA)))));

        register(context, PINK_GARNET_GEODE_KEY, Feature.GEODE, new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                BlockStateProvider.simple(Blocks.DEEPSLATE),
                BlockStateProvider.simple(ModBlocks.PINK_GARNET_ORE),
                BlockStateProvider.simple(Blocks.DIRT),
                BlockStateProvider.simple(Blocks.EMERALD_BLOCK),
                List.of(ModBlocks.PINK_GARNET_BLOCK.defaultBlockState()),
                BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                new GeodeCrackSettings(0.25D, 1.5D, 1),
                0.5D, 0.1D,
                true, UniformInt.of(3, 8),
                UniformInt.of(2, 6), UniformInt.of(1, 2),
                -18, 18, 0.075D, 1));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MCCourseMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                   ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
