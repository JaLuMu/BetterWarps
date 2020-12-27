package de.jalumu.neowarps.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.permission.Permission;
import org.bukkit.plugin.java.annotation.permission.Permissions;

import static de.jalumu.neowarps.util.CommandHelper.checkArgs;
import static de.jalumu.neowarps.util.CommandHelper.checkPlayer;

@Commands(@org.bukkit.plugin.java.annotation.command.Command(name = "createWarp", desc = "Creates a new Private Warp", aliases = {"cwarp"}, permission = "neowarps.private.create"))
@Permissions(@Permission(name = "neowarps.private.create", desc = "Allows to create new private Warps", defaultValue = PermissionDefault.TRUE))
public class CreateWarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (checkPlayer(sender) && checkArgs(args, 1)) {

        }

        return false;
    }
}
