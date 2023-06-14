package com.possiblepanda.handlers;

import com.possiblepanda.MCZombies;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class ItemUseHandler implements Listener {
    public ItemUseHandler(MCZombies plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onSimpleBandageUse(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (item.getItemMeta() != ItemHandler.simpleBandage.getItemMeta()) {
            return;
        }
        Bukkit.getLogger().info("TEST");
    }

}
