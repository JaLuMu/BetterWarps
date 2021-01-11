package de.jalumu.neowarps.commands;


import de.jalumu.neowarps.NeoWarps;
import de.jalumu.neowarps.util.Transmission;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.permission.Permission;
import org.bukkit.plugin.java.annotation.permission.Permissions;

import java.util.Arrays;

import static de.jalumu.neowarps.util.CommandHelper.checkArgs;
import static de.jalumu.neowarps.util.CommandHelper.checkPlayer;
import static org.bukkit.ChatColor.AQUA;
import static org.bukkit.ChatColor.GRAY;

@Commands(@org.bukkit.plugin.java.annotation.command.Command(name = "createPublicWarp", desc = "Creates a new Public Warp", aliases = {"cpwarp"}, permission = "neowarps.public.create"))
@Permissions(@Permission(name = "neowarps.public.create", desc = "Allows to create new public Warps", defaultValue = PermissionDefault.OP))
public class CreatePublicWarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (checkPlayer(sender) && checkArgs(args, 2)) {
            Player player = (Player) sender;
            Location location = player.getLocation();


            return true;
        }
        return false;
    }
}
