package net.kaupenjoe.mccourse.entity.ai;

import net.kaupenjoe.mccourse.entity.custom.PorcupineEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class PorcupineAttackGoal extends MeleeAttackGoal {
    private final PorcupineEntity entity;
    private int attackDelay = 20;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public PorcupineAttackGoal(PathfinderMob mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((PorcupineEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUntilNextAttack = 20;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAggressive(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAggressive(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.mob.distanceToSqr(pEnemy) < 2f;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAggressive(false);
        super.stop();
    }
}
