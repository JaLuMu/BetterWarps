package de.jalumu.neowarps.commands;

import de.jalumu.neowarps.NeoWarps;
import de.jalumu.neowarps.config.ItemRepresentation;
import de.jalumu.neowarps.config.WarpConfiguration;
import de.jalumu.neowarps.config.WarpUserData;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.jalumu.neowarps.util.CommandHelper.checkArgs;
import static de.jalumu.neowarps.util.CommandHelper.checkPlayer;
import static org.bukkit.ChatColor.*;

@Commands(@org.bukkit.plugin.java.annotation.command.Command(name = "createWarp", desc = "Creates a new Private Warp", aliases = {"cwarp"}, permission = "neowarps.private.create"))
@Permissions(@Permission(name = "neowarps.private.create", desc = "Allows to create new private Warps", defaultValue = PermissionDefault.TRUE))
public class CreateWarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (checkPlayer(sender) && checkArgs(args, 2)) {
            Player player = (Player) sender;
            Location location = player.getLocation();
            WarpUserData userData = NeoWarps.getInstance().getWarpManager().getWarps(player.getUniqueId());
            String warpName = args[0];
            userData.getPrivateWarps().put(warpName,
                    new WarpConfiguration(warpName, player.getLocation(),
                            new ItemRepresentation(Material.valueOf(args[1]), warpName, Arrays.asList(
                                    new Transmission()
                                            .color(GRAY).appendText("World:").appendSpace().color(AQUA).appendText(location.getWorld().getName())
                                            .getTransmissionContent(),
                                    new Transmission()
                                            .color(GRAY).appendText("X:").appendSpace().color(AQUA).appendText(String.valueOf(location.getBlockX()))
                                            .getTransmissionContent(),
                                    new Transmission()
                                            .color(GRAY).appendText("Y:").appendSpace().color(AQUA).appendText(String.valueOf(location.getBlockY()))
                                            .getTransmissionContent(),
                                    new Transmission()
                                            .color(GRAY).appendText("Z:").appendSpace().color(AQUA).appendText(String.valueOf(location.getBlockZ()))
                                            .getTransmissionContent()
                            ))));
            return true;
        }

        return false;
    }
}
