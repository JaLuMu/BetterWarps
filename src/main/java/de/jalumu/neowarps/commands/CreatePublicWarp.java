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

@Commands(@org.bukkit.plugin.java.annotation.command.Command(name="createPublicWarp",desc = "Creates a new Public Warp", aliases = {"cpwarp"},permission = "neowarps.public.create"))
@Permissions(@Permission(name = "neowarps.public.create",desc = "Allows to create new public Warps",defaultValue = PermissionDefault.OP))
public class CreatePublicWarp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (checkPlayer(sender) && checkArgs(args,1)){

        }

        return false;
    }
}
