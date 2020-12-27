package de.jalumu.neowarps.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelper {

    public static boolean isPlayer(CommandSender sender) {
        return sender instanceof Player;
    }

    public static boolean checkPlayer(CommandSender sender) {
        if (!isPlayer(sender)) {
            new Transmission().color(ChatColor.RED).appendText("You must be a Player to execute this Command").send(sender);
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkArgs(String[] args, int expected) {
        return args.length == expected;
    }

}
