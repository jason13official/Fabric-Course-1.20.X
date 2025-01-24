package net.kaupenjoe.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kaupenjoe.mccourse.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.FluidTags;
import java.util.concurrent.CompletableFuture;

public class ModFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public ModFluidTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.tag(FluidTags.WATER)
                .add(ModFluids.FLOWING_SOAP_WATER)
                .add(ModFluids.STILL_SOAP_WATER);
    }
}
