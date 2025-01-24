package net.kaupenjoe.mccourse.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public InteractionResult interact(Player player, Level world, InteractionHand hand, Entity entity,
                                 @Nullable EntityHitResult hitResult) {
        if(entity instanceof Sheep && !world.isClientSide() && !player.isSpectator()) {
            if(player.getItemInHand(hand).getItem() == ModItems.PINK_GARNET_SWORD) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " just hurt a sheep with our custom Sword!"));
            } else {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " just hurt a sheep!"));
            }
        }

        return InteractionResult.PASS;
    }
}
