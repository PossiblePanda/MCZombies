package com.possiblepanda;

import com.possiblepanda.commands.MCZ_Give;
import com.possiblepanda.commands.MCZ_Recipes;
import com.possiblepanda.handlers.ItemHandler;
import com.possiblepanda.handlers.ItemUseHandler;
import com.possiblepanda.handlers.StarterHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MCZombies extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        boolean starter_kit = getConfig().getBoolean("starter_kit");
        boolean custom_recipes = getConfig().getBoolean("custom_recipes");
        String prefix = getConfig().getString("prefix");

        Bukkit.getLogger().info(prefix + "MCZombies has been started up!");

        new ItemUseHandler(this);

        Objects.requireNonNull(getCommand("mcz_give")).setExecutor(new MCZ_Give(this));
        Objects.requireNonNull(getCommand("mcz_recipes")).setExecutor(new MCZ_Recipes(this));


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

        Bukkit.getLogger().info("[MCZombies] MCZombies has been shut down.");
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {

    }
}
