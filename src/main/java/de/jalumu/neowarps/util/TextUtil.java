package de.jalumu.neowarps.util;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TextUtil {

    public static String parse(String text) {
        if (text != null) {
            return ChatColor.translateAlternateColorCodes('&', text);
        } else {
            return null;
        }
    }


    public static List<String> parse(List<String> list) {
        List<String> parsed = new ArrayList<>();
        for (String s : list) {
            parsed.add(parse(s));
        }
        return parsed;
    }

    public static ItemStack parse(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            if (meta.getDisplayName() != null) {
                meta.setDisplayName(parse(meta.getDisplayName()));
            }
            if (meta.getLore() != null) {
                meta.setLore(parse(meta.getLore()));
            }
            itemStack.setItemMeta(meta);
        }
        return itemStack;
    }

}
