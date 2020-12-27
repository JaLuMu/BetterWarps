package de.jalumu.neowarps.gui

import de.jalumu.neowarps.NeoWarps
import de.jalumu.neowarps.util.Transmission
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class GUIManager(val plugin: NeoWarps) {
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
            inventory.setItem(i, plugin.itemUtil.placeholder.item)
        }
        inventory.setItem(2, plugin.itemUtil.publicWarps.item)
        inventory.setItem(4, plugin.itemUtil.sharedWarps.item)
        inventory.setItem(6, plugin.itemUtil.privateWarps.item)
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
        player.openInventory(inventory)
    }

    internal fun openSharedGui(player: Player) {
        val inventory = Bukkit.createInventory(
                player, 27,
                Transmission()
                        .appendPluginPrefix().appendSpace()
                        .color(ChatColor.GRAY).appendText("|").appendSpace()
                        .color(ChatColor.RED).appendText("Shared Warps")
                        .transmissionContent
        )
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
        player.openInventory(inventory)
    }

}