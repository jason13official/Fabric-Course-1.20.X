package net.kaupenjoe.mccourse;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.kaupenjoe.mccourse.datagen.*;
import net.kaupenjoe.mccourse.world.ModConfiguredFeatures;
import net.kaupenjoe.mccourse.world.ModPlacedFeatures;
import net.kaupenjoe.mccourse.world.biome.ModBiomes;
import net.kaupenjoe.mccourse.world.dimension.ModDimensions;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class MCCourseModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBlockLootTableGenerator::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModPaintingVariantTagProvider::new);
		pack.addProvider(ModAdvancementProvider::new);
		pack.addProvider(ModPOITagProvider::new);
		pack.addProvider(ModFluidTagProvider::new);
		pack.addProvider(ModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
		registryBuilder.add(Registries.BIOME, ModBiomes::bootstrap);
		registryBuilder.add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType);
	}
}
