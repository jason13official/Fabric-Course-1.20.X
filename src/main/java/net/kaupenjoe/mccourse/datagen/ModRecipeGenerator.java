package net.kaupenjoe.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.datagen.recipe.GemEmpoweringRecipeBuilder;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .define('S', Items.STONE)
                .define('P', ModItems.PINK_GARNET)
                .unlockedBy(getHasName(Items.STONE), has(Items.STONE))
                .unlockedBy(getHasName(ModItems.PINK_GARNET), has(ModItems.PINK_GARNET))
                .save(exporter, new ResourceLocation(getSimpleRecipeName(ModItems.RAW_PINK_GARNET) + "_"));

        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, ModItems.PINK_GARNET, RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK);

        oreSmelting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE), RecipeCategory.MISC, ModItems.PINK_GARNET,
                0.25f, 200, "pink_garnet");
        oreBlasting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE), RecipeCategory.MISC, ModItems.PINK_GARNET,
                0.25f, 200, "pink_garnet");

        new GemEmpoweringRecipeBuilder(ModItems.RAW_PINK_GARNET, ModItems.PINK_GARNET, 3, 60, 15)
                .unlockedBy(getHasName(ModItems.RAW_PINK_GARNET), has(ModItems.RAW_PINK_GARNET))
                .save(exporter);

        new GemEmpoweringRecipeBuilder(Items.STICK, Items.END_ROD, 1, 10, 50)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(exporter);

        new GemEmpoweringRecipeBuilder(Items.COAL, Items.DIAMOND, 7, 600, 20)
                .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                .save(exporter);

        new GemEmpoweringRecipeBuilder(Blocks.PRISMARINE, Items.COOKED_CHICKEN, 12, 20, 50)
                .unlockedBy(getHasName(Blocks.PRISMARINE), has(Blocks.PRISMARINE))
                .save(exporter);
    }
}
