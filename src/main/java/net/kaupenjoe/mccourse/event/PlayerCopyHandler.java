package net.kaupenjoe.mccourse.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.kaupenjoe.mccourse.util.IEntityDataSaver;
import net.minecraft.server.level.ServerPlayer;

public class PlayerCopyHandler implements ServerPlayerEvents.CopyFrom {
    @Override
    public void copyFromPlayer(ServerPlayer oldPlayer, ServerPlayer newPlayer, boolean alive) {
        ((IEntityDataSaver) newPlayer).getPersistentData().putIntArray("homepos",
                ((IEntityDataSaver) oldPlayer).getPersistentData().getIntArray("homepos"));
    }
}
