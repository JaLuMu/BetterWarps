package de.jalumu.neowarps.gui;

import de.jalumu.neowarps.util.Transmission;
import eu.vironlab.simpleitemlib.SimpleItemBuilder;
import eu.vironlab.simpleitemlib.SimpleItemStack;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class ItemUtil {

    @Getter
    private static ItemUtil instance;
    @Getter
    private SimpleItemStack placeholder;
    @Getter
    private SimpleItemStack privateWarps;
    @Getter
    private SimpleItemStack publicWarps;
    @Getter
    private SimpleItemStack serverWarps;

    public ItemUtil() {
        instance = this;

        this.placeholder = new SimpleItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE)
                .setDisplayName(new Transmission()
                        .color(GRAY)
                        .appendText(" ")
                        .getTransmissionContent())
                .setClickHandler(inventoryClickEvent -> {
                    Player player = (Player) inventoryClickEvent.getWhoClicked();
                    player.playSound(player.getLocation(), Sound.ENTITY_CAT_STRAY_AMBIENT,1,1);
                })
                .build();

        this.privateWarps = new SimpleItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE)
                .setDisplayName(new Transmission()
                        .color(LIGHT_PURPLE)
                        .appendText("Private Warps")
                        .getTransmissionContent())
                .setClickHandler(inventoryClickEvent -> WarpGui.openPrivateGui((Player) inventoryClickEvent.getWhoClicked()))
                .build();

        this.publicWarps = new SimpleItemBuilder(Material.YELLOW_STAINED_GLASS_PANE)
                .setDisplayName(new Transmission()
                        .color(YELLOW)
                        .appendText("Public Warps")
                        .getTransmissionContent())
                .setClickHandler(inventoryClickEvent -> WarpGui.openPublicGui((Player) inventoryClickEvent.getWhoClicked()))
                .build();

        this.serverWarps = new SimpleItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE)
                .setDisplayName(new Transmission()
                        .color(BLUE)
                        .appendText("Server Warps")
                        .getTransmissionContent())
                .setClickHandler(inventoryClickEvent -> WarpGui.openPublicGui((Player) inventoryClickEvent.getWhoClicked()))
                .build();

    }
}
