package de.jalumu.neowarps.gui;

import de.jalumu.neowarps.util.Transmission;
import eu.vironlab.simpleitemlib.SimpleItemBuilder;
import eu.vironlab.simpleitemlib.SimpleItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class ItemUtil {

    private static ItemUtil instance;
    private SimpleItemStack privateWarps;
    private SimpleItemStack publicWarps;

    public ItemUtil() {
        instance = this;
        this.privateWarps = new SimpleItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE)
                .setDisplayName(new Transmission()
                        .color(LIGHT_PURPLE)
                        .appendText("Private Warps")
                        .getTransmissionContent())
                .setClickHandler(inventoryClickEvent -> WarpGui.openPrivateGui((Player) inventoryClickEvent.getWhoClicked()))
                .build();

    }

    public SimpleItemStack getPrivateWarps() {
        return privateWarps;
    }

    public static ItemUtil getInstance() {
        return instance;
    }
}
