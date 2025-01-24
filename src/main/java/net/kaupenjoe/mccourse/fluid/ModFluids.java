package net.kaupenjoe.mccourse.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;

public class ModFluids {
    public static final FlowingFluid STILL_SOAP_WATER = Registry.register(BuiltInRegistries.FLUID,
            new ResourceLocation(MCCourseMod.MOD_ID, "soap_water"), new SoapWaterFluid.Still());
    public static final FlowingFluid FLOWING_SOAP_WATER = Registry.register(BuiltInRegistries.FLUID,
            new ResourceLocation(MCCourseMod.MOD_ID, "flowing_soap_water"), new SoapWaterFluid.Flowing());

    public static final Block SOAP_WATER_BLOCK = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MCCourseMod.MOD_ID,
            "soap_water_block"), new LiquidBlock(ModFluids.STILL_SOAP_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));
    public static final Item SOAP_WATER_BUCKET = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MCCourseMod.MOD_ID,
            "soap_water_bucket"), new BucketItem(ModFluids.STILL_SOAP_WATER,
            new FabricItemSettings().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void registerFluids() {
        MCCourseMod.LOGGER.info("Registering Fluid for " + MCCourseMod.MOD_ID);
    }
}
