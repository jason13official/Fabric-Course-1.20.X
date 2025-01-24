package net.kaupenjoe.mccourse.entity.custom;

import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.block.custom.DiceBlock;
import net.kaupenjoe.mccourse.entity.ModEntities;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class DiceProjectileEntity extends ThrowableItemProjectile {
    public DiceProjectileEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public DiceProjectileEntity(LivingEntity livingEntity, Level world) {
        super(ModEntities.THROWN_DICE_PROJECTILE, livingEntity, world);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        if(!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.level().setBlock(this.blockPosition(), ((DiceBlock) ModBlocks.DICE_BLOCK).getRandomBlockState(), 3);
        }

        this.discard();
        super.onHitBlock(blockHitResult);
    }
}
