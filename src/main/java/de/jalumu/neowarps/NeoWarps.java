package de.jalumu.neowarps;

import de.jalumu.neowarps.commands.NeoWarpsCommand;
import de.jalumu.neowarps.commands.WarpCommand;
import de.jalumu.neowarps.commands.WarpsCommand;
import de.jalumu.neowarps.metrics.Metrics;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name = "NeoWarps", version = "@version@")
@Description(value = "A Better Minecraft 1.16 Warp Plugin")
@Author(value = "JanLuca")
@Author(value = "Infinity_dev")
@Website(value = "https://github.com/JaLuMu/NeoWarps")
public final class NeoWarps extends JavaPlugin {

    @Getter
    private static NeoWarps instance;
    @Getter
    private static Metrics metrics;

    @Override
    public void onEnable() {
        instance = this;
        metrics = new Metrics(this,9638);

        getCommand("neowarps").setExecutor(new NeoWarpsCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("warps").setExecutor(new WarpsCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
