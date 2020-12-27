package de.jalumu.neowarps.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.permission.Permission;
import org.bukkit.plugin.java.annotation.permission.Permissions;

@Commands(@org.bukkit.plugin.java.annotation.command.Command(name="DeleteWarp",desc = "Removes a specific private Warp", aliases = {"dwarp","delwarp"},permission = "neowarps.private.delete"))
@Permissions(@Permission(name = "neowarps.private.delete",desc = "Allows to delete private warps",defaultValue = PermissionDefault.TRUE))
public class DeleteWarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
