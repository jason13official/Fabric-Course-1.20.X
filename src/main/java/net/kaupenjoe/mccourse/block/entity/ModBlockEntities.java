package net.kaupenjoe.mccourse.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import team.reborn.energy.api.EnergyStorage;

public class ModBlockEntities {
    public static final BlockEntityType<GemEmpoweringStationBlockEntity> GEM_EMPOWERING_STATION_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(MCCourseMod.MOD_ID, "gem_empowering_block_entity"),
                    FabricBlockEntityTypeBuilder.create(GemEmpoweringStationBlockEntity::new,
                            ModBlocks.GEM_EMPOWERING_STATION).build(null));

    public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
            new ResourceLocation(MCCourseMod.MOD_ID, "mod_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new,
                    ModBlocks.DRIFTWOOD_SIGN, ModBlocks.DRIFTWOOD_WALL_SIGN).build());

    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
            new ResourceLocation(MCCourseMod.MOD_ID, "mod_hanging_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new,
                    ModBlocks.DRIFTWOOD_HANGING_SIGN, ModBlocks.DRIFTWOOD_HANGING_WALL_SIGN).build(null));

    public static final BlockEntityType<KaupenFurnaceBlockEntity> KAUPEN_FURNACE_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(MCCourseMod.MOD_ID, "kaupen_furnace_be"),
                    FabricBlockEntityTypeBuilder.create(KaupenFurnaceBlockEntity::new,
                            ModBlocks.KAUPEN_FURNACE).build(null));

    public static void registerBlockEntities() {
        MCCourseMod.LOGGER.info("Registering Block Entities for " + MCCourseMod.MOD_ID);

        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, GEM_EMPOWERING_STATION_BE);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, GEM_EMPOWERING_STATION_BE);
    }
}
