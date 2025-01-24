package net.kaupenjoe.mccourse.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodComponents {
    public static final FoodProperties CAULIFLOWER = new FoodProperties.Builder().nutrition(4).saturationMod(0.5f)
            .effect(new MobEffectInstance(MobEffects.GLOWING), 0.25f).build();
}
