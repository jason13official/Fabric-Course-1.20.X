package net.kaupenjoe.mccourse.potion;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.effect.ModEffects;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class ModPotions {
    public static final Potion SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new MobEffectInstance(ModEffects.SLIMEY, 200, 0)));

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(BuiltInRegistries.POTION, new ResourceLocation(MCCourseMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        MCCourseMod.LOGGER.info("Registering Potions for " + MCCourseMod.MOD_ID);
    }
}
