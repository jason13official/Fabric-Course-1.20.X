package net.kaupenjoe.mccourse.item.custom;

import net.kaupenjoe.mccourse.entity.custom.MagicProjectileEntity;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RadiationStaffItem extends Item {
    public RadiationStaffItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack itemstack = user.getItemInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.METAL_DETECTOR_FOUND_ORE, SoundSource.NEUTRAL,1.5F, 1F);
        user.getCooldowns().addCooldown(this, 40);

        if (!world.isClientSide()) {
            MagicProjectileEntity magicProjectile = new MagicProjectileEntity(world, user);
            magicProjectile.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0F, 1.5F, 0.25F);
            world.addFreshEntity(magicProjectile);
        }

        user.awardStat(Stats.ITEM_USED.get(this));
        if (!user.getAbilities().instabuild) {
            itemstack.hurtAndBreak(1, user, p -> p.broadcastBreakEvent(hand));
        }

        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }
}
