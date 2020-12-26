package de.jalumu.neowarps.gui;

import de.jalumu.neowarps.util.Transmission;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static org.bukkit.ChatColor.*;

public class WarpGui {

    public static void openWarpGui(Player player){
        openMainGui(player);
    }

    private static void openMainGui(Player player){
        Inventory inventory = Bukkit.createInventory(player, 9,
                new Transmission()
                        .appendPluginPrefix().appendSpace()
                        .color(GRAY).appendText("|").appendSpace()
                        .color(RED).appendText("Warp Menu")
                        .getTransmissionContent()
        );

        for (int i = 0; i<=8; i++){
            inventory.setItem(i,ItemHelper.getPlaceholder());
        }

        inventory.setItem(2,ItemHelper.getItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE,"Server Warps"));
        inventory.setItem(4,ItemHelper.getItemStack(Material.YELLOW_STAINED_GLASS_PANE,"Public Warps"));
        inventory.setItem(6,ItemHelper.getItemStack(Material.MAGENTA_STAINED_GLASS_PANE,"Private Warps"));

        player.openInventory(inventory);
    }

    private static void openPrivateGui(Player player){
        Inventory inventory = Bukkit.createInventory(player, 27,
                new Transmission()
                        .appendPluginPrefix().appendSpace()
                        .color(GRAY).appendText("|").appendSpace()
                        .color(RED).appendText("Private Warps")
                        .getTransmissionContent()
        );

        for (int i = 0; i<=43; i++){
            inventory.setItem(i,ItemHelper.getPlaceholder());
        }


        player.openInventory(inventory);
    }


}
