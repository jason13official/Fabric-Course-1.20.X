package net.kaupenjoe.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.block.custom.CattailCropBlock;
import net.kaupenjoe.mccourse.block.custom.CauliflowerCropBlock;
import net.kaupenjoe.mccourse.block.custom.ModStandingSignBlock;
import net.kaupenjoe.mccourse.block.custom.PinkGarnetLampBlock;
import net.kaupenjoe.mccourse.fluid.ModFluids;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        BlockModelGenerators.BlockFamilyProvider pinkGarnetTexturePool = blockStateModelGenerator.family(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.RAW_PINK_GARNET_BLOCK);

        blockStateModelGenerator.createTrivialCube(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.END_STONE_PINK_GARNET_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.NETHER_PINK_GARNET_ORE);

        blockStateModelGenerator.createTrivialCube(ModBlocks.SOUND_BLOCK);

        pinkGarnetTexturePool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetTexturePool.slab(ModBlocks.PINK_GARNET_SLAB);
        pinkGarnetTexturePool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetTexturePool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        pinkGarnetTexturePool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetTexturePool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetTexturePool.wall(ModBlocks.PINK_GARNET_WALL);

        blockStateModelGenerator.createDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.createTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        registerCustomLamp(blockStateModelGenerator);

        blockStateModelGenerator.createCropBlock(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.createPlant(ModBlocks.PETUNIA, ModBlocks.POTTED_PETUNIA, BlockModelGenerators.TintState.NOT_TINTED);

        blockStateModelGenerator.createNonTemplateHorizontalBlock(ModBlocks.GEM_EMPOWERING_STATION);

        blockStateModelGenerator.woodProvider(ModBlocks.DRIFTWOOD_LOG).logWithHorizontal(ModBlocks.DRIFTWOOD_LOG).wood(ModBlocks.DRIFTWOOD_WOOD);
        blockStateModelGenerator.woodProvider(ModBlocks.STRIPPED_DRIFTWOOD_LOG).logWithHorizontal(ModBlocks.STRIPPED_DRIFTWOOD_LOG).wood(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

        BlockModelGenerators.BlockFamilyProvider tPlnaks = blockStateModelGenerator.family(ModBlocks.DRIFTWOOD_PLANKS);
        tPlnaks.generateFor(BlockFamilies.familyBuilder(ModBlocks.DRIFTWOOD_PLANKS).sign(ModBlocks.DRIFTWOOD_SIGN, ModBlocks.DRIFTWOOD_WALL_SIGN).getFamily());

        blockStateModelGenerator.createHangingSign(ModBlocks.STRIPPED_DRIFTWOOD_LOG, ModBlocks.DRIFTWOOD_HANGING_SIGN, ModBlocks.DRIFTWOOD_HANGING_WALL_SIGN);

        blockStateModelGenerator.createTrivialCube(ModBlocks.DRIFTWOOD_LEAVES);
        blockStateModelGenerator.createCrossBlock(ModBlocks.DRIFTWOOD_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);
    }

    private void registerCustomLamp(BlockModelGenerators blockStateModelGenerator) {
        ResourceLocation identifier = TexturedModel.CUBE.create(ModBlocks.PINK_GARNET_LAMP_BLOCK, blockStateModelGenerator.modelOutput);
        ResourceLocation identifier2 = blockStateModelGenerator.createSuffixedVariant(ModBlocks.PINK_GARNET_LAMP_BLOCK, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(ModBlocks.PINK_GARNET_LAMP_BLOCK)
                .with(BlockModelGenerators.createBooleanModelDispatch(PinkGarnetLampBlock.CLICKED, identifier2, identifier)));

        blockStateModelGenerator.createCropBlock(ModBlocks.CATTAIL_CROP, CattailCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);

        blockStateModelGenerator.createTrivialBlock(ModBlocks.COLORED_LEAVES, TexturedModel.LEAVES);

        blockStateModelGenerator.createTrivialCube(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.RUBY_BLOCK_1);
        blockStateModelGenerator.createTrivialCube(ModBlocks.RUBY_BLOCK_2);
        blockStateModelGenerator.createTrivialCube(ModBlocks.RUBY_BLOCK_3);

        blockStateModelGenerator.createTrivialCube(ModBlocks.WAXED_RUBY_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.WAXED_RUBY_BLOCK_1);
        blockStateModelGenerator.createTrivialCube(ModBlocks.WAXED_RUBY_BLOCK_2);
        blockStateModelGenerator.createTrivialCube(ModBlocks.WAXED_RUBY_BLOCK_3);

        blockStateModelGenerator.createFurnace(ModBlocks.KAUPEN_FURNACE, TexturedModel.ORIENTABLE_ONLY_TOP);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RAW_PINK_GARNET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.CAULIFLOWER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PEAT_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.METAL_DETECTOR, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_PAXEL, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateArmorTrims(((ArmorItem) ModItems.PINK_GARNET_HELMET));
        itemModelGenerator.generateArmorTrims(((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE));
        itemModelGenerator.generateArmorTrims(((ArmorItem) ModItems.PINK_GARNET_LEGGINGS));
        itemModelGenerator.generateArmorTrims(((ArmorItem) ModItems.PINK_GARNET_BOOTS));

        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BAR_BRAWL_MUSIC_DISC, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModFluids.SOAP_WATER_BUCKET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.DICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DRIFTWOOD_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DRIFTWOOD_BOAT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.CATTAIL, ModelTemplates.FLAT_ITEM);


        itemModelGenerator.generateFlatItem(ModItems.PORCUPINE_SPAWN_EGG,
                new ModelTemplate(Optional.of(new ResourceLocation("item/template_spawn_egg")), Optional.empty()));

        // itemModelGenerator.register(ModItems.DATA_TABLET, Models.GENERATED);
    }
}
