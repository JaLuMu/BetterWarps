package de.jalumu.neowarps;

import de.jalumu.neowarps.commands.NeoWarpsCommand;
import de.jalumu.neowarps.commands.WarpCommand;
import de.jalumu.neowarps.commands.WarpsCommand;
import de.jalumu.neowarps.gui.GUIManager;
import de.jalumu.neowarps.metrics.Metrics;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name = "NeoWarps", version = "1.0-SNAPSHOT")
@Description(value = "A Better Minecraft 1.16 Warp Plugin")
@Author(value = "JanLuca")
@Author(value = "Infinity_dev")
@Website(value = "https://github.com/JaLuMu/NeoWarps")
@Getter
public final class NeoWarps extends JavaPlugin {

    @Getter
    private static NeoWarps instance;
    private Metrics metrics;
    private GUIManager guiManager;

    @Override
    public void onEnable() {
        instance = this;
        metrics = new Metrics(this,9638);
        guiManager = new GUIManager();

        getCommand("neowarps").setExecutor(new NeoWarpsCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("warps").setExecutor(new WarpsCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
