package net.kaupenjoe.mccourse.sound;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public class ModSounds {
    public static final SoundEvent METAL_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");

    public static final SoundEvent PINK_GARNET_LAMP_BREAK = registerSoundEvent("pink_garnet_lamp_break");
    public static final SoundEvent PINK_GARNET_LAMP_STEP = registerSoundEvent("pink_garnet_lamp_step");
    public static final SoundEvent PINK_GARNET_LAMP_PLACE = registerSoundEvent("pink_garnet_lamp_place");
    public static final SoundEvent PINK_GARNET_LAMP_HIT = registerSoundEvent("pink_garnet_lamp_hit");
    public static final SoundEvent PINK_GARNET_LAMP_FALL = registerSoundEvent("pink_garnet_lamp_fall");

    public static final SoundEvent BAR_BRAWL = registerSoundEvent("bar_brawl");


    public static final SoundType PINK_GARNET_LAMP_SOUNDS = new SoundType(1f, 1f,
            PINK_GARNET_LAMP_BREAK, PINK_GARNET_LAMP_STEP, PINK_GARNET_LAMP_PLACE, PINK_GARNET_LAMP_HIT, PINK_GARNET_LAMP_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        ResourceLocation identifier = new ResourceLocation(MCCourseMod.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }

    public static void registerSounds() {
        MCCourseMod.LOGGER.info("Registering Mod Sounds for " + MCCourseMod.MOD_ID);
    }
}
