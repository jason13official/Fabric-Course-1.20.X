package net.kaupenjoe.mccourse.effect;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ModEffects {
    public static final MobEffect SLIMEY = registerStatusEffect("slimey",
            new SlimeyEffect(MobEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            "7107DE5E-7CE8-4030-940E-514C1F160890", -0.25f,
                            AttributeModifier.Operation.MULTIPLY_TOTAL));


    private static MobEffect registerStatusEffect(String name, MobEffect statusEffect) {
        return Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(MCCourseMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        MCCourseMod.LOGGER.info("Registering Mod Effects for " + MCCourseMod.MOD_ID);
    }
}
