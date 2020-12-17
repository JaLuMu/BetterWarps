package de.jalumu.neowarps.gui;


import de.jalumu.neowarps.util.TextUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemHelper {

    protected static ItemStack getItemStack(Material material, String name, int amount, List<String> loore){
        ItemStack stack = new ItemStack(material,amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(TextUtil.parse(name));
        meta.setLore(TextUtil.parse(loore));
        stack.setItemMeta(meta);
        return stack;
    }


    protected static ItemStack getItemStack(Material material, String name){
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(TextUtil.parse(name));
        stack.setItemMeta(meta);
        return stack;
    }


    protected static ItemStack setName(ItemStack itemStack,String name){
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(TextUtil.parse(name));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    protected static ItemStack setLore(ItemStack itemStack,List<String> lore){
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(TextUtil.parse(lore));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack getPlaceholder(){
        return getItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE,"   ");
    }

}