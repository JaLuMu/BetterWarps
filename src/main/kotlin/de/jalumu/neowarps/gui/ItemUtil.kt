package de.jalumu.neowarps.gui

import de.jalumu.neowarps.util.Transmission
import eu.vironlab.simpleitemlib.SimpleItemBuilder
import eu.vironlab.simpleitemlib.SimpleItemStack
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent

class ItemUtil(val guiManager: GUIManager) {

    companion object {
        @JvmStatic
        lateinit var instance: ItemUtil
    }


    val placeholder: SimpleItemStack
    val privateWarps: SimpleItemStack
    val sharedWarps: SimpleItemStack
    val publicWarps: SimpleItemStack

    init {
        instance = this;
        placeholder = SimpleItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE)
            .setDisplayName(
                Transmission()
                    .color(ChatColor.GRAY)
                    .appendText(" ")
                    .transmissionContent
            )
            .setClickHandler { inventoryClickEvent: InventoryClickEvent ->
                val player = inventoryClickEvent.whoClicked as Player
                player.playSound(player.location, Sound.ENTITY_CAT_STRAY_AMBIENT, 1f, 1f)
            }
            .build()
        privateWarps = SimpleItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE)
            .setDisplayName(
                Transmission()
                    .color(ChatColor.LIGHT_PURPLE)
                    .appendText("Private Warps")
                    .transmissionContent
            )
            .setClickHandler { inventoryClickEvent: InventoryClickEvent -> guiManager.openPrivateGui(inventoryClickEvent.whoClicked as Player) }
            .build()
        sharedWarps = SimpleItemBuilder(Material.YELLOW_STAINED_GLASS_PANE)
            .setDisplayName(
                Transmission()
                    .color(ChatColor.YELLOW)
                    .appendText("Shared Warps")
                    .transmissionContent
            )
            .setClickHandler { inventoryClickEvent: InventoryClickEvent -> guiManager.openPublicGui(inventoryClickEvent.whoClicked as Player) }
            .build()
        publicWarps = SimpleItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE)
            .setDisplayName(
                Transmission()
                    .color(ChatColor.BLUE)
                    .appendText("Public Warps")
                    .transmissionContent
            )
            .setClickHandler { inventoryClickEvent: InventoryClickEvent -> guiManager.openPublicGui(inventoryClickEvent.whoClicked as Player) }
            .build()
    }
}