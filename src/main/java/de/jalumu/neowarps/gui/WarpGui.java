package de.jalumu.neowarps.gui;

import de.jalumu.neowarps.util.Transmission;
import org.bukkit.Bukkit;
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
            inventory.setItem(i,ItemUtil.getInstance().getPlaceholder().getItem());
        }

        inventory.setItem(2,ItemUtil.getInstance().getServerWarps().getItem());
        inventory.setItem(4,ItemUtil.getInstance().getPublicWarps().getItem());
        inventory.setItem(6,ItemUtil.getInstance().getPrivateWarps().getItem());

        player.openInventory(inventory);
    }

    protected static void openPrivateGui(Player player){
        Inventory inventory = Bukkit.createInventory(player, 27,
                new Transmission()
                        .appendPluginPrefix().appendSpace()
                        .color(GRAY).appendText("|").appendSpace()
                        .color(RED).appendText("Private Warps")
                        .getTransmissionContent()
        );

        for (int i = 0; i<=43; i++){
            inventory.setItem(i,ItemUtil.getInstance().getPlaceholder().getItem());
        }


        player.openInventory(inventory);
    }

    protected static void openPublicGui(Player player){
        Inventory inventory = Bukkit.createInventory(player, 27,
                new Transmission()
                        .appendPluginPrefix().appendSpace()
                        .color(GRAY).appendText("|").appendSpace()
                        .color(RED).appendText("Public Warps")
                        .getTransmissionContent()
        );

        for (int i = 0; i<=43; i++){
            inventory.setItem(i,ItemUtil.getInstance().getPlaceholder().getItem());
        }


        player.openInventory(inventory);
    }

    protected static void openServerGui(Player player){
        Inventory inventory = Bukkit.createInventory(player, 27,
                new Transmission()
                        .appendPluginPrefix().appendSpace()
                        .color(GRAY).appendText("|").appendSpace()
                        .color(RED).appendText("Server Warps")
                        .getTransmissionContent()
        );

        for (int i = 0; i<=43; i++){
            inventory.setItem(i,ItemUtil.getInstance().getPlaceholder().getItem());
        }


        player.openInventory(inventory);
    }


}
