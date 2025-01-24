package net.kaupenjoe.mccourse.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;

public class ModVillagers {
    public static final ResourceKey<PoiType> SOUND_POI_KEY = registerPoiKey("soundpoi");
    public static final PoiType SOUND_POI = registerPoi("soundpoi", ModBlocks.SOUND_BLOCK);

    public static final VillagerProfession SOUND_MASTER = registerProfession("soundmaster", SOUND_POI_KEY);


    private static VillagerProfession registerProfession(String name, ResourceKey<PoiType> type) {
        return Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, new ResourceLocation(MCCourseMod.MOD_ID, name),
                new VillagerProfession(name, entry -> true, entry -> entry.is(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_MASON));
    }

    private static PoiType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new ResourceLocation(MCCourseMod.MOD_ID, name),
                1,1, block);
    }

    private static ResourceKey<PoiType> registerPoiKey(String name) {
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MCCourseMod.MOD_ID, name));
    }

    public static void registerVillagers() {
        MCCourseMod.LOGGER.info("Registering Villagers for " + MCCourseMod.MOD_ID);
    }
}
