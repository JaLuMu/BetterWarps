package de.jalumu.neowarps.gui

import de.jalumu.neowarps.NeoWarps
import de.jalumu.neowarps.manager.WarpManager
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

    fun generateHybridGUI(level: HybridLevel, player: Player, page: Int = 1, sortFilter: SortType = SortType.NOTHING): Inventory {

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
                player.openInventory(generateHybridGUI(level, player, page-1, sortFilter))
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
                player.openInventory(generateHybridGUI(level, player, page+1, sortFilter))
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

                    val lore = arrayListOf(" ", " ")

                    SortType.values().forEach { type ->

                        val accentColor = if (type == sortFilter)
                            ChatColor.GREEN
                        else
                            ChatColor.GRAY

                        lore.add(lore.size-2, "$accentColor> ${type.displayName}")

                    }

                    it.itemMeta = meta
                    it
                }
        ).let {
            it.setClickHandler {
                player.openInventory(generateHybridGUI(
                    level = level,
                    player = player,
                    page = page,
                    sortFilter = SortType.values().elementAtOrNull(SortType.values().indexOf(sortFilter)+1) ?: SortType.values().first()
                ))
            }
        }

        for (x in 0 until inventory.size) {
            inventory.setItem(x, ItemUtil(this@GUIManager).placeholder.item)
        }

        for ((index, control) in listOf(buttonNext, buttonSort, buttonPrev).withIndex()) {
            inventory.setItem(inventory.size-1-(index*3), control.item)
        }

        for (x in 9..inventory.size-10) {
            val containerSize = inventory.size-10-9
            val storePos = x+((page-1)*containerSize)

            if ((containerSize*page) < inventory.size) {
                inventory.setItem(x, NeoWarps.getInstance().warpManager.getWarps(player.uniqueId).canAccess.values.toList()[storePos].let {
                    val representation = it.representation
                    val item = ItemStack(representation.representationMaterial)
                    val meta = item.itemMeta

                    meta.setDisplayName(representation.displayName)
                    meta.lore = representation.representationLore

                    item.itemMeta = meta
                    item
                })
            }

        }

        return inventory
    }

    enum class HybridLevel {
        PUBLIC, SHARED, PRIVATE;

        val displayName: String
            get() = when (this) {
                PUBLIC -> "Public"
                SHARED -> "Shared"
                PRIVATE -> "Private"
            }

    }

    enum class SortType {
        NOTHING, LEVEL, NAME, OWNER;

        val displayName: String
            get() = when (this) {
                NOTHING -> "Nothing"
                LEVEL -> "Access"
                NAME -> "Name"
                OWNER -> "Owner"
            }

    }

}