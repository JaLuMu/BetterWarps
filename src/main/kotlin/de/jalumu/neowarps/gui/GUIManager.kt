package de.jalumu.neowarps.gui

import de.jalumu.neowarps.util.Transmission
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class GUIManager {
    fun openWarpGui(player: Player) {
        openMainGui(player)
    }

    fun openMainGui(player: Player) {
        val inventory = Bukkit.createInventory(
            player, 9,
            Transmission()
                .appendPluginPrefix().appendSpace()
                .color(ChatColor.GRAY).appendText("|").appendSpace()
                .color(ChatColor.RED).appendText("Warp Menu")
                .transmissionContent
        )
        for (i in 0..8) {
            inventory.setItem(i, ItemUtil.instance.placeholder.item)
        }
        inventory.setItem(2, ItemUtil.instance.publicWarps.item)
        inventory.setItem(4, ItemUtil.instance.sharedWarps.item)
        inventory.setItem(6, ItemUtil.instance.privateWarps.item)
        player.openInventory(inventory)
    }

    internal fun openPrivateGui(player: Player) {
        val inventory = Bukkit.createInventory(
            player, 27,
            Transmission()
                .appendPluginPrefix().appendSpace()
                .color(ChatColor.GRAY).appendText("|").appendSpace()
                .color(ChatColor.RED).appendText("Private Warps")
                .transmissionContent
        )
        for (i in 0..43) {
            inventory.setItem(i, ItemUtil.instance.placeholder.item)
        }
        player.openInventory(inventory)
    }

    internal fun openPublicGui(player: Player) {
        val inventory = Bukkit.createInventory(
            player, 27,
            Transmission()
                .appendPluginPrefix().appendSpace()
                .color(ChatColor.GRAY).appendText("|").appendSpace()
                .color(ChatColor.RED).appendText("Public Warps")
                .transmissionContent
        )
        for (i in 0..43) {
            inventory.setItem(i, ItemUtil.instance.placeholder.item)
        }
        player.openInventory(inventory)
    }

    internal fun openServerGui(player: Player) {
        val inventory = Bukkit.createInventory(
            player, 27,
            Transmission()
                .appendPluginPrefix().appendSpace()
                .color(ChatColor.GRAY).appendText("|").appendSpace()
                .color(ChatColor.RED).appendText("Server Warps")
                .transmissionContent
        )
        for (i in 0..43) {
            inventory.setItem(i, ItemUtil.instance.placeholder.item)
        }
        player.openInventory(inventory)
    }
}