package net.kaupenjoe.mccourse.datagen;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.painting.ModPaintings;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariant;
import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagProvider extends TagsProvider<PaintingVariant> {
    public ModPaintingVariantTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.PAINTING_VARIANT, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookup) {
        tag(PaintingVariantTags.PLACEABLE)
                .addOptional(new ResourceLocation(MCCourseMod.MOD_ID, "saw_them"))
                .addOptional(new ResourceLocation(MCCourseMod.MOD_ID, "shrimp"))
                .addOptional(new ResourceLocation(MCCourseMod.MOD_ID, "world"));
    }
}
