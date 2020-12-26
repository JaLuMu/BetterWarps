package de.jalumu.neowarps.commands;

import de.jalumu.neowarps.gui.WarpGui;
import de.jalumu.neowarps.util.CommandHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.permission.Permission;
import org.bukkit.plugin.java.annotation.permission.Permissions;

@Commands(@org.bukkit.plugin.java.annotation.command.Command(name="warps",desc = "Shows the Warp Menu",permission = "neowarps.warps"))
@Permissions(@Permission(name = "neowarps.warps",desc = "Provides access to the Warp Menu"))
public class WarpsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (CommandHelper.isPlayer(sender)){
            WarpGui.openWarpGui(((Player) sender));
        }
        return true;
    }
}
