package de.jalumu.neowarps.commands;

import de.jalumu.neowarps.util.CommandHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.permission.Permission;
import org.bukkit.plugin.java.annotation.permission.Permissions;

@Commands(@org.bukkit.plugin.java.annotation.command.Command(name="warp",desc = "Warp to a location directly",permission = "neowarps.warp"))
@Permissions(@Permission(name = "neowarps.warp",desc = "Provides access to direct Warps",defaultValue = PermissionDefault.TRUE))
public class WarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (CommandHelper.isPlayer(sender)){

        }
        return false;
    }
}
