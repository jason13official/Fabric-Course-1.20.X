package net.kaupenjoe.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.fluid.ModFluids;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {
    public static final CreativeModeTab PINK_GARNET_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(MCCourseMod.MOD_ID, "pink_garnet_group"),
            FabricItemGroup.builder().title(Component.translatable("itemgroup.pink_garnet_group"))
                    .icon(() -> new ItemStack(ModItems.PINK_GARNET)).displayItems((displayContext, entries) -> {
                       entries.accept(ModItems.PINK_GARNET);
                       entries.accept(ModItems.RAW_PINK_GARNET);
                       entries.accept(ModItems.METAL_DETECTOR);
                       entries.accept(ModItems.CAULIFLOWER);
                       entries.accept(ModItems.PEAT_BRICK);

                       entries.accept(ModItems.PINK_GARNET_SWORD);
                       entries.accept(ModItems.PINK_GARNET_PICKAXE);
                       entries.accept(ModItems.PINK_GARNET_SHOVEL);
                       entries.accept(ModItems.PINK_GARNET_AXE);
                       entries.accept(ModItems.PINK_GARNET_HOE);
                       entries.accept(ModItems.PINK_GARNET_PAXEL);

                       entries.accept(ModItems.PINK_GARNET_HELMET);
                       entries.accept(ModItems.PINK_GARNET_CHESTPLATE);
                       entries.accept(ModItems.PINK_GARNET_LEGGINGS);
                       entries.accept(ModItems.PINK_GARNET_BOOTS);

                       entries.accept(ModItems.PINK_GARNET_HORSE_ARMOR);
                       entries.accept(ModItems.DATA_TABLET);
                       entries.accept(ModItems.CAULIFLOWER_SEEDS);
                       entries.accept(ModItems.BAR_BRAWL_MUSIC_DISC);
                       entries.accept(ModItems.RADIATION_STAFF);
                       entries.accept(ModItems.PINK_GARNET_BOW);
                       entries.accept(ModItems.PINK_GARNET_SHIELD);

                       entries.accept(ModItems.DRIFTWOOD_SIGN);
                       entries.accept(ModItems.DRIFTWOOD_HANGING_SIGN);
                       entries.accept(ModItems.PORCUPINE_SPAWN_EGG);

                       entries.accept(ModItems.DICE);
                       entries.accept(ModItems.CATTAIL_SEEDS);
                       entries.accept(ModItems.CATTAIL);

                       entries.accept(ModItems.DRIFTWOOD_BOAT);
                       entries.accept(ModItems.DRIFTWOOD_CHEST_BOAT);

                       entries.accept(ModFluids.SOAP_WATER_BUCKET);


                       entries.accept(ModBlocks.PINK_GARNET_BLOCK);
                       entries.accept(ModBlocks.RAW_PINK_GARNET_BLOCK);

                       entries.accept(ModBlocks.PINK_GARNET_ORE);
                       entries.accept(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
                       entries.accept(ModBlocks.END_STONE_PINK_GARNET_ORE);
                       entries.accept(ModBlocks.NETHER_PINK_GARNET_ORE);

                       entries.accept(ModBlocks.SOUND_BLOCK);

                       entries.accept(ModBlocks.PINK_GARNET_STAIRS);
                       entries.accept(ModBlocks.PINK_GARNET_SLAB);

                       entries.accept(ModBlocks.PINK_GARNET_BUTTON);
                       entries.accept(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
                       entries.accept(ModBlocks.PINK_GARNET_FENCE);
                       entries.accept(ModBlocks.PINK_GARNET_FENCE_GATE);
                       entries.accept(ModBlocks.PINK_GARNET_WALL);
                       entries.accept(ModBlocks.PINK_GARNET_DOOR);
                       entries.accept(ModBlocks.PINK_GARNET_TRAPDOOR);

                       entries.accept(ModBlocks.PINK_GARNET_LAMP_BLOCK);
                       entries.accept(ModBlocks.PETUNIA);
                       entries.accept(ModBlocks.GEM_EMPOWERING_STATION);

                       entries.accept(ModBlocks.DRIFTWOOD_LOG);
                       entries.accept(ModBlocks.DRIFTWOOD_WOOD);
                       entries.accept(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
                       entries.accept(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
                       entries.accept(ModBlocks.DRIFTWOOD_PLANKS);
                       entries.accept(ModBlocks.DRIFTWOOD_SAPLING);
                       entries.accept(ModBlocks.DRIFTWOOD_LEAVES);

                       entries.accept(ModBlocks.COLORED_LEAVES);

                       entries.accept(ModBlocks.RUBY_BLOCK);
                       entries.accept(ModBlocks.RUBY_BLOCK_1);
                       entries.accept(ModBlocks.RUBY_BLOCK_2);
                       entries.accept(ModBlocks.RUBY_BLOCK_3);

                       entries.accept(ModBlocks.WAXED_RUBY_BLOCK);
                       entries.accept(ModBlocks.WAXED_RUBY_BLOCK_1);
                       entries.accept(ModBlocks.WAXED_RUBY_BLOCK_2);
                       entries.accept(ModBlocks.WAXED_RUBY_BLOCK_3);

                       entries.accept(ModBlocks.KAUPEN_FURNACE);

                    }).build());

    public static void registerItemGroups() {

    }
}
