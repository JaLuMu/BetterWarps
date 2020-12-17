package de.jalumu.neowarps.manager;

import de.jalumu.neowarps.NeoWarps;
import org.bukkit.entity.Player;

public class WarpManager {

    public static void warpPlayer(Player player, String warpName){
        if (warpName.contains(":")){

        }else {
            NeoWarps.getInstance().getConfig().contains("warps.private." + player.getUniqueId())
        }
    }

}
