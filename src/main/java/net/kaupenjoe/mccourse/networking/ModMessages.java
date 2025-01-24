package net.kaupenjoe.mccourse.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.networking.packet.ItemStackSyncS2CPacket;
import net.minecraft.resources.ResourceLocation;

public class ModMessages {
    public static final ResourceLocation ITEM_SYNC = new ResourceLocation(MCCourseMod.MOD_ID, "item_sync");


    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC, ItemStackSyncS2CPacket::receive);
    }
}
