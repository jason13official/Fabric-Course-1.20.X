package net.kaupenjoe.mccourse.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.kaupenjoe.mccourse.util.IEntityDataSaver;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;

public class SetHomeCommand {
    public static void register(CommandDispatcher<CommandSourceStack> serverCommandSourceCommandDispatcher,
                                CommandBuildContext commandRegistryAccess,
                                Commands.CommandSelection registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(Commands.literal("home")
                .then(Commands.literal("set").executes(SetHomeCommand::run)));
    }

    public static int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        IEntityDataSaver player = ((IEntityDataSaver) context.getSource().getPlayer());
        BlockPos playerPos = context.getSource().getPlayer().blockPosition();
        String positionString = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";

        player.getPersistentData().putIntArray("homepos",
                new int[] { playerPos.getX(), playerPos.getY(), playerPos.getZ() });

        context.getSource().sendSuccess(() -> Component.literal("Set Home at " + positionString), true);
        return 1;
    }
}
