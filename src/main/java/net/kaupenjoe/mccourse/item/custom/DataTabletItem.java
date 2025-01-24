package net.kaupenjoe.mccourse.item.custom;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class DataTabletItem extends Item {
    public DataTabletItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);
        if(stack.hasTag()) {
            stack.setTag(new CompoundTag());
        }

        return super.use(world, user, hand);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return stack.hasTag();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        if(stack.hasTag()) {
            String currentFoundValuable = stack.getTag().getString("mccourse.last_valuable_found");
            tooltip.add(Component.literal(currentFoundValuable));
        }
    }
}
