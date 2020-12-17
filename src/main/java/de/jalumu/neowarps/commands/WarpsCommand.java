package de.jalumu.neowarps.commands;

import de.jalumu.neowarps.gui.WarpGui;
import de.jalumu.neowarps.util.CommandHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (CommandHelper.isPlayer(sender)){
            WarpGui.openWarpGui(((Player) sender));
        }
        return true;
    }
}
