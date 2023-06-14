package com.possiblepanda.handlers;

import com.possiblepanda.MCZombies;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class ItemUseHandler implements Listener {
    public ItemUseHandler(MCZombies plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onSimpleBandageUse(PlayerItemConsumeEvent event) {
        ItemStack item1 = event.getItem();
        if (Objects.equals(Objects.requireNonNull(item1.getItemMeta()).getLore(), Objects.requireNonNull(ItemHandler.simpleBandage.getItemMeta()).getLore())) {
            Player player = event.getPlayer();

            event.setCancelled(true);

            double heal_amount = 5;
            double max_health = 20;
//            player.setHealth(player.getHealth() + heal_amount);
//            player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");

            if (player.getHealth() < max_health - heal_amount) {
                player.setHealth(player.getHealth() + heal_amount);
                player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
            } else {
                player.setHealth(max_health);
                player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
            }
        }
    }
    @EventHandler
    public void onAdvancedBandageUse(PlayerItemConsumeEvent event) {
        ItemStack item1 = event.getItem();
        if (Objects.equals(Objects.requireNonNull(item1.getItemMeta()).getLore(), Objects.requireNonNull(ItemHandler.advancedBandage.getItemMeta()).getLore())) {
            Player player = event.getPlayer();

            event.setCancelled(true);

            double heal_amount = 10;
            double max_health = 20;
//            player.setHealth(player.getHealth() + heal_amount);
//            player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");

            if (player.getHealth() < max_health - heal_amount) {
                player.setHealth(player.getHealth() + heal_amount);
                player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
            } else {
                player.setHealth(max_health);
                player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
            }
        }
    }
}