package net.kaupenjoe.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.block.custom.CauliflowerCropBlock;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.PINK_GARNET_BLOCK);
        dropSelf(ModBlocks.RAW_PINK_GARNET_BLOCK);
        dropSelf(ModBlocks.SOUND_BLOCK);

        add(ModBlocks.PINK_GARNET_ORE, createOreDrop(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE, createOreDrop(ModBlocks.DEEPSLATE_PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        add(ModBlocks.END_STONE_PINK_GARNET_ORE, createOreDrop(ModBlocks.END_STONE_PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        add(ModBlocks.NETHER_PINK_GARNET_ORE, createOreDrop(ModBlocks.NETHER_PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));

        dropSelf(ModBlocks.PINK_GARNET_STAIRS);
        add(ModBlocks.PINK_GARNET_SLAB, createSlabItemTable(ModBlocks.PINK_GARNET_SLAB));
        dropSelf(ModBlocks.PINK_GARNET_BUTTON);
        dropSelf(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        dropSelf(ModBlocks.PINK_GARNET_FENCE);
        dropSelf(ModBlocks.PINK_GARNET_FENCE_GATE);
        dropSelf(ModBlocks.PINK_GARNET_WALL);
        dropSelf(ModBlocks.PINK_GARNET_TRAPDOOR);
        add(ModBlocks.PINK_GARNET_DOOR, createDoorTable(ModBlocks.PINK_GARNET_DOOR));

        LootItemBlockStatePropertyCondition.Builder builder2 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CAULIFLOWER_CROP)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CauliflowerCropBlock.AGE, 6));
        this.add(ModBlocks.CAULIFLOWER_CROP, this.createCropDrops(ModBlocks.CAULIFLOWER_CROP, ModItems.CAULIFLOWER, ModItems.CAULIFLOWER_SEEDS, builder2));

        // IF YOU ONLY WANT THE ITEM TO DROP FROM THE TOP BLOCK
        // BlockStatePropertyLootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder(ModBlocks.CATTAIL_CROP)
        //         .properties(StatePredicate.Builder.create().exactMatch(CauliflowerCropBlock.AGE, 8));
        // this.addDrop(ModBlocks.CATTAIL_CROP, this.cropDrops(ModBlocks.CATTAIL_CROP, ModItems.CATTAIL, ModItems.CATTAIL_SEEDS, builder3));

        AnyOfCondition.Builder builder =
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CATTAIL_CROP).setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(CauliflowerCropBlock.AGE, 7))
                        .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CATTAIL_CROP).setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(CauliflowerCropBlock.AGE, 8)));
        add(ModBlocks.CATTAIL_CROP, createCropDrops(ModBlocks.CATTAIL_CROP, ModItems.CATTAIL, ModItems.CATTAIL_SEEDS, builder));


    }
}
