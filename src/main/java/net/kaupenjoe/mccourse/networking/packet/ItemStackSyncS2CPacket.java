package net.kaupenjoe.mccourse.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.kaupenjoe.mccourse.block.entity.GemEmpoweringStationBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;

public class ItemStackSyncS2CPacket {
    public static void receive(Minecraft client, ClientPacketListener handler,
                               FriendlyByteBuf buf, PacketSender responseSender) {
        int size = buf.readInt();
        NonNullList<ItemStack> list = NonNullList.withSize(size, ItemStack.EMPTY);
        for(int i = 0; i < size; i++) {
            list.set(i, buf.readItem());
        }
        BlockPos position = buf.readBlockPos();

        if(client.level.getBlockEntity(position) instanceof GemEmpoweringStationBlockEntity blockEntity) {
            blockEntity.setInventory(list);
        }
    }
}
