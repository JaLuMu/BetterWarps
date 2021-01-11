package de.jalumu.neowarps;

import de.jalumu.neowarps.commands.*;
import de.jalumu.neowarps.gui.GUIManager;
import de.jalumu.neowarps.gui.ItemUtil;
import de.jalumu.neowarps.manager.WarpManager;
import de.jalumu.neowarps.metrics.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.dependency.Dependency;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name = "NeoWarps", version = "1.0-SNAPSHOT")
@Description(value = "A Better Minecraft 1.16 Warp Plugin")
@Author(value = "JanLuca")
@Author(value = "Infinity_dev")
@Website(value = "https://github.com/JaLuMu/NeoWarps")
@Dependency(value = "SimpleItemLib")
@ApiVersion(ApiVersion.Target.v1_15)
public final class NeoWarps extends JavaPlugin {

    private static NeoWarps instance;
    private Metrics metrics;
    private WarpManager warpManager;
    private ItemUtil itemUtil;
    private GUIManager guiManager;

    public static NeoWarps getInstance() {
        return NeoWarps.instance;
    }


    @Override
    public void onEnable() {
        instance = this;
        metrics = new Metrics(this, 9638);
        this.guiManager = new GUIManager(this);
        this.itemUtil = new ItemUtil(this.guiManager);
        this.warpManager = new WarpManager(this);

        getCommand("neowarps").setExecutor(new NeoWarpsCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("warps").setExecutor(new WarpsCommand());
        getCommand("createWarp").setExecutor(new CreateWarpCommand());
        getCommand("createPublicWarp").setExecutor(new CreatePublicWarpCommand());

        Bukkit.getConsoleSender().sendMessage("§a     __               __    __                          \n" +
                "§a  /\\ \\ \\  ___   ___  / / /\\ \\ \\  __ _  _ __  _ __   ___ \n" +
                "§a /  \\/ / / _ \\ / _ \\ \\ \\/  \\/ / / _` || '__|| '_ \\ / __|\n" +
                "§a/ /\\  / |  __/| (_) | \\  /\\  / | (_| || |   | |_) |\\__ \\\n" +
                "§a\\_\\ \\/   \\___| \\___/   \\/  \\/   \\__,_||_|   | .__/ |___/\n" +
                "§a                                            |_|         §r");
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Metrics getMetrics() {
        return this.metrics;
    }

    public WarpManager getWarpManager() {
        return this.warpManager;
    }

    public ItemUtil getItemUtil() {
        return this.itemUtil;
    }

    public GUIManager getGuiManager() {
        return this.guiManager;
    }
}
