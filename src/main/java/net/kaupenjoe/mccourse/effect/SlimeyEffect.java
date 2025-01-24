package net.kaupenjoe.mccourse.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

// Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
// MIT License!
public class SlimeyEffect extends MobEffect {
    protected SlimeyEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if(entity.horizontalCollision) {
            Vec3 intialVec = entity.getDeltaMovement();
            Vec3 climbVec = new Vec3(intialVec.x, 0.2D, intialVec.z);
            entity.setDeltaMovement(climbVec.x * 0.92D, climbVec.y * 0.98D, climbVec.z * 0.92D);
        }

        super.applyEffectTick(entity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
