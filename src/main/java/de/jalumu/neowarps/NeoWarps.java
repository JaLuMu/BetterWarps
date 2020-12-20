package de.jalumu.neowarps;

import de.jalumu.neowarps.commands.NeoWarpsCommand;
import de.jalumu.neowarps.commands.WarpCommand;
import de.jalumu.neowarps.commands.WarpsCommand;
import de.jalumu.neowarps.listener.InventoryListener;
import de.jalumu.neowarps.metrics.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NeoWarps extends JavaPlugin {

    private static Metrics metrics;

    private static NeoWarps instance;


    @Override
    public void onEnable() {
        instance = this;
        metrics = new Metrics(this,9638);

        this.getCommand("neowarps").setExecutor(new NeoWarpsCommand());
        this.getCommand("warp").setExecutor(new WarpCommand());
        this.getCommand("warps").setExecutor(new WarpsCommand());

        this.getServer().getPluginManager().registerEvents(new InventoryListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static NeoWarps getInstance() {
        return instance;
    }

}
