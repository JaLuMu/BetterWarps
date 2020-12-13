package de.jalumu.neowarps;

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

        this.getCommand("neowarps").setExecutor(new de.jalumu.neowarps.commands.NeoWarps());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static NeoWarps getInstance() {
        return instance;
    }

}
