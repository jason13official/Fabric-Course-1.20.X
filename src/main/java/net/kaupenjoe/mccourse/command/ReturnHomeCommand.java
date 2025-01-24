package net.kaupenjoe.mccourse.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.kaupenjoe.mccourse.util.IEntityDataSaver;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class ReturnHomeCommand {
    public static void register(CommandDispatcher<CommandSourceStack> serverCommandSourceCommandDispatcher,
                                CommandBuildContext commandRegistryAccess,
                                Commands.CommandSelection registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(Commands.literal("home")
                .then(Commands.literal("return").executes(ReturnHomeCommand::run)));
    }

    private static int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();

        int[] homepos = player.getPersistentData().getIntArray("homepos");

        if(homepos.length != 0) {
            context.getSource().getPlayer().teleportTo(homepos[0], homepos[1], homepos[2]);
            context.getSource().sendSuccess(() -> Component.literal("Player returned Home!"), false);
            return 1;
        } else {
            context.getSource().sendSuccess(() -> Component.literal("No Home Position has been Set!"), false);
            return -1;
        }
    }
}
