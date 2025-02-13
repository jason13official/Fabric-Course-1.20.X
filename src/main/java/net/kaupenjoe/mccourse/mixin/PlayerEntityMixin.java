package net.kaupenjoe.mccourse.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// With the help of Mekanism-Fabric
// under MIT License: https://github.com/Mekanism-Fabric/Mekanism/blob/main/LICENSE
@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Redirect(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
            ),
            method = "damageShield"
    )
    protected boolean damageShield(ItemStack itemStack, Item item) {
        if (itemStack.getItem() instanceof ShieldItem && item == Items.SHIELD) {
            return true;
        }

        return itemStack.is(item);
    }

    @Redirect(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/ItemCooldownManager;set(Lnet/minecraft/item/Item;I)V"
            ),
            method = "disableShield"
    )
    public void disableShield(ItemCooldowns itemCooldownManager, Item item, int duration) {
        Item activeItem = this.useItem.getItem();

        if (activeItem instanceof ShieldItem && item == Items.SHIELD) {
            itemCooldownManager.addCooldown(activeItem, duration);
        } else {
            itemCooldownManager.addCooldown(item, duration);
        }

    }
}