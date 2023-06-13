package com.possiblepanda;

import com.possiblepanda.commands.Fly;
import com.possiblepanda.commands.Menu;
import com.possiblepanda.handlers.ItemHandler;
import com.possiblepanda.handlers.StarterHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MCZombies extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("MCZombies has successfully been started up!");

        saveDefaultConfig();

        boolean starter_kit = getConfig().getBoolean("starter_kit");
        boolean custom_recipes = getConfig().getBoolean("custom_recipes");

        Objects.requireNonNull(getCommand("fly")).setExecutor(new Fly());
        Objects.requireNonNull(getCommand("menu")).setExecutor(new Menu(this));

        if (starter_kit) {
            new StarterHandler(this);
        }
        if (custom_recipes) {
            ItemHandler.init();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("MCZombies has been shut down.");
    }
}
