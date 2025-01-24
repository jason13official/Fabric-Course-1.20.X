package net.kaupenjoe.mccourse.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.custom.*;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.kaupenjoe.mccourse.util.ModWoodTypes;
import net.kaupenjoe.mccourse.world.tree.DriftwoodSaplingGenerator;
import net.minecraft.world.level.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperFullBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new DropExperienceBlock(FabricBlockSettings.copyOf(Blocks.STONE), UniformInt.of(3, 6)));
    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock("deepslate_pink_garnet_ore",
            new DropExperienceBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE), UniformInt.of(3, 6)));
    public static final Block END_STONE_PINK_GARNET_ORE = registerBlock("end_stone_pink_garnet_ore",
            new DropExperienceBlock(FabricBlockSettings.copyOf(Blocks.END_STONE), UniformInt.of(3, 6)));
    public static final Block NETHER_PINK_GARNET_ORE = registerBlock("nether_pink_garnet_ore",
            new DropExperienceBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK), UniformInt.of(3, 6)));

    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            new StairBlock(ModBlocks.PINK_GARNET_BLOCK.defaultBlockState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON), BlockSetType.IRON, 10, true));
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE), BlockSetType.IRON));

    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.ACACIA));
    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR), BlockSetType.IRON));
    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapDoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR), BlockSetType.IRON));


    public static final Block PINK_GARNET_LAMP_BLOCK = registerBlock("pink_garnet_lamp_block",
            new PinkGarnetLampBlock(FabricBlockSettings.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(4f).requiresCorrectToolForDrops().lightLevel(state -> state.getValue(PinkGarnetLampBlock.CLICKED) ? 15 : 0)
                    .sound(ModSounds.PINK_GARNET_LAMP_SOUNDS)));


    public static final Block CAULIFLOWER_CROP = registerBlockWithoutBlockItem("cauliflower_crop",
            new CauliflowerCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block PETUNIA = registerBlock("petunia",
            new FlowerBlock(MobEffects.BAD_OMEN, 4, FabricBlockSettings.copyOf(Blocks.ALLIUM)));
    public static final Block POTTED_PETUNIA = registerBlockWithoutBlockItem("potted_petunia",
            new FlowerPotBlock(PETUNIA, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));

    public static final Block GEM_EMPOWERING_STATION = registerBlock("gem_empowering_station",
            new GemEmpoweringStationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).noOcclusion()));

    public static final Block DRIFTWOOD_LOG = registerBlock("driftwood_log",
            new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block DRIFTWOOD_WOOD = registerBlock("driftwood_wood",
            new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_DRIFTWOOD_LOG = registerBlock("stripped_driftwood_log",
            new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_DRIFTWOOD_WOOD = registerBlock("stripped_driftwood_wood",
            new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block DRIFTWOOD_PLANKS = registerBlock("driftwood_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block DRIFTWOOD_LEAVES = registerBlock("driftwood_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(1f)));

    public static final Block DRIFTWOOD_SAPLING = registerBlock("driftwood_sapling",
            new ModSaplingBlock(new DriftwoodSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1f)));

    public static final Block DRIFTWOOD_SIGN = registerBlockWithoutBlockItem("driftwood_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_SIGN), ModWoodTypes.DRIFTWOOD));
    public static final Block DRIFTWOOD_WALL_SIGN = registerBlockWithoutBlockItem("driftwood_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_WALL_SIGN), ModWoodTypes.DRIFTWOOD));
    public static final Block DRIFTWOOD_HANGING_SIGN = registerBlockWithoutBlockItem("driftwood_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_HANGING_SIGN), ModWoodTypes.DRIFTWOOD));
    public static final Block DRIFTWOOD_HANGING_WALL_SIGN = registerBlockWithoutBlockItem("driftwood_hanging_wall_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_WALL_HANGING_SIGN), ModWoodTypes.DRIFTWOOD));

    public static final Block DICE_BLOCK = registerBlockWithoutBlockItem("dice_block",
            new DiceBlock(FabricBlockSettings.copyOf(Blocks.STONE)));


    public static final Block CATTAIL_CROP = registerBlockWithoutBlockItem("cattail_crop",
            new CattailCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block COLORED_LEAVES = registerBlock("colored_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block RUBY_BLOCK_1 = registerBlock("ruby_block_1",
            new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block RUBY_BLOCK_2 = registerBlock("ruby_block_2",
            new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block RUBY_BLOCK_3 = registerBlock("ruby_block_3",
            new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block WAXED_RUBY_BLOCK = registerBlock("waxed_ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block WAXED_RUBY_BLOCK_1 = registerBlock("waxed_ruby_block_1",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block WAXED_RUBY_BLOCK_2 = registerBlock("waxed_ruby_block_2",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block WAXED_RUBY_BLOCK_3 = registerBlock("waxed_ruby_block_3",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block KAUPEN_FURNACE = registerBlock("kaupen_furnace",
            new KaupenFurnaceBlock(FabricBlockSettings.copyOf(Blocks.STONE)));


    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MCCourseMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MCCourseMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MCCourseMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        MCCourseMod.LOGGER.info("Registering ModBlocks for " + MCCourseMod.MOD_ID);
    }
}
