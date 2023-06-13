package com.possiblepanda.handlers;

import com.possiblepanda.MCZombies;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StarterHandler implements Listener {
    public StarterHandler(MCZombies plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ItemStack item = new ItemStack(Material.COOKED_BEEF, 10);
        Inventory inv = player.getInventory();
        inv.addItem(item);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Simple Bandage");
    }
}
