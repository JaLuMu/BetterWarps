package de.jalumu.neowarps.util;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelper {

    public static boolean isPlayer(CommandSender sender){
        return sender instanceof Player;
    }

}
