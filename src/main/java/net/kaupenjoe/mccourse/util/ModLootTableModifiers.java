package net.kaupenjoe.mccourse.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {
    private static final ResourceLocation GRASS_BLOCK_ID
            = new ResourceLocation("minecraft", "blocks/grass");
    private static final ResourceLocation IGLOO_STRUCTURE_CHEST_ID
            = new ResourceLocation("minecraft", "chests/igloo_chest");
    private static final ResourceLocation CREEPER_ID
            = new ResourceLocation("minecraft", "entities/creeper");

    private static final ResourceLocation SUSPICIOUS_SAND_ID
            = new ResourceLocation("minecraft", "archaeology/desert_pyramid");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(GRASS_BLOCK_ID.equals(id)) {
                // Adds Cauliflower Seeds to the grass loot table.
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.35f)) // Drops 35% of the time
                        .add(LootItem.lootTableItem(ModItems.CAULIFLOWER_SEEDS))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(IGLOO_STRUCTURE_CHEST_ID.equals(id)) {
                // Adds Metal Detector to the Igloo loot table.
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1f)) // Drops 100% of the time
                        .add(LootItem.lootTableItem(ModItems.METAL_DETECTOR))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(CREEPER_ID.equals(id)) {
                // Adds Peat Brick to the Creeper Loot table.
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.85f)) // Drops 85% of the time
                        .add(LootItem.lootTableItem(ModItems.PEAT_BRICK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });

        // LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
        //     if(SUSPICIOUS_SAND_ID.equals(id)) {
        //         List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
        //         entries.add(ItemEntry.builder(ModItems.METAL_DETECTOR).build());
        //         LootPool.Builder pool = LootPool.builder().with(entries);
        //         return LootTable.builder().pool(pool).build();
        //     }
//
        //     return null;
        // });
    }
}
