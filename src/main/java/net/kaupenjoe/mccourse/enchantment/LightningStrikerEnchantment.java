package net.kaupenjoe.mccourse.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.entity.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LightningStrikerEnchantment extends Enchantment {
    protected LightningStrikerEnchantment(Rarity weight, EnchantmentCategory target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        if(!user.level().isClientSide()) {
            ServerLevel world = ((ServerLevel) user.level());
            BlockPos position = target.blockPosition();

            if(level == 1) {
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED);
            }

            if(level == 2) {
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED);
            }
        }

        super.doPostAttack(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
