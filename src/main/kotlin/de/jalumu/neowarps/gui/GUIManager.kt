package de.jalumu.neowarps.gui

import de.jalumu.neowarps.NeoWarps
import de.jalumu.neowarps.util.Transmission
import eu.vironlab.simpleitemlib.SimpleItemStack
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

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

    fun generateHybridGUI(level: HybridLevel, player: Player, page: Int = 1): Inventory {

        val inventory = Bukkit.createInventory(
                player,
                9*6,
                Transmission()
                        .appendPluginPrefix()
                        .appendSpace()
                        .color(ChatColor.GRAY)
                        .appendText("|")
                        .appendSpace()
                        .color(ChatColor.AQUA)
                        .color(ChatColor.BOLD)
                        .appendText("${level.displayName}-Warps")
                        .transmissionContent
        )

        val buttonPrev = SimpleItemStack(
                ItemStack(Material.PLAYER_HEAD).let {
                    val meta = it.itemMeta as SkullMeta

                    meta.owningPlayer = Bukkit.getOfflinePlayer("MHF_ArrowLeft")
                    meta.setDisplayName(Transmission()
                            .appendMessagePrefix()
                            .color(ChatColor.GREEN)
                            .appendText("Previous Page")
                            .transmissionContent
                    )
                    meta.lore = listOf(
                            " ",
                            "§a§lCLICK§7 to go to the §lprevious page§7!",
                            " "
                    )

                    it.itemMeta = meta
                    return@let it
                }
        ).let {
            it.setClickHandler {
                player.openInventory(generateHybridGUI(level, player, page-1))
            }
        }

        val buttonNext = SimpleItemStack(
                ItemStack(Material.PLAYER_HEAD).let {
                    val meta = it.itemMeta as SkullMeta

                    meta.owningPlayer = Bukkit.getOfflinePlayer("MHF_ArrowRight")
                    meta.setDisplayName(Transmission()
                            .appendMessagePrefix()
                            .color(ChatColor.GREEN)
                            .appendText("Next Page")
                            .transmissionContent
                    )
                    meta.lore = listOf(
                            " ",
                            "§a§lCLICK§7 to go to the §lnext page§7!",
                            " "
                    )

                    it.itemMeta = meta
                    return@let it
                }
        ).let {
            it.setClickHandler {
                player.openInventory(generateHybridGUI(level, player, page+1))
            }
        }

        val buttonSort = SimpleItemStack(
                ItemStack(Material.HOPPER).let {
                    val meta = it.itemMeta

                    meta.setDisplayName(Transmission()
                            .appendMessagePrefix()
                            .color(ChatColor.LIGHT_PURPLE)
                            .appendText("SortBy")
                            .transmissionContent
                    )

                    meta.lore = listOf(
                            " ",
                            ""
                    )


                }
        )

        for (x in 0 until inventory.size) {

            inventory.setItem(x, ItemUtil(this@GUIManager).placeholder.item)

        }



        return inventory
    }

    enum class HybridLevel {
        PUBLIC, SHARED, PRIVATE;

        val displayName: String
            get() = when (this) {
                PUBLIC -> {
                    "Public"
                }
                SHARED -> {
                    "Shared"
                }
                PRIVATE -> {
                    "Private"
                }
            }

    }

}