package de.jalumu.neowarps.util;

import eu.vironlab.simpleitemlib.SimpleItemStack;

public class ItemUtil {

    private static ItemUtil instance;
    private SimpleItemStack privateWarps;
    private SimpleItemStack publicWarps;

    public ItemUtil() {
        instance = this;
        //this.privateWarps =
    }



    public static ItemUtil getInstance() {
        return instance;
    }
}
