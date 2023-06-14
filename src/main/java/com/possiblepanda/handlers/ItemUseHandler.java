package com.possiblepanda.handlers;

import com.possiblepanda.MCZombies;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.projectiles.ProjectileSource;

import java.util.Objects;

public class ItemUseHandler implements Listener {
    FileConfiguration config = MCZombies.getPlugin(MCZombies.class).getConfig();
    String prefix = config.getString("prefix");
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
            if (config.getBoolean("simple_bandage")) {
                if (player.getHealth() < max_health - heal_amount) {
                    player.setHealth(player.getHealth() + heal_amount);
                    player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
                } else {
                    player.setHealth(max_health);
                    player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
                }
            } else {
                player.sendMessage(prefix + "§cThis item is disabled on this server, if you believe this is a mistake, tell the owner of the server to enable it.");
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
            if (config.getBoolean("advanced_bandage")) {
                if (player.getHealth() < max_health - heal_amount) {
                    player.setHealth(player.getHealth() + heal_amount);
                    player.sendMessage(prefix + "§7You have been healed for §a+" + heal_amount + ".");
                } else {
                    player.setHealth(max_health);
                    player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
                }
            } else {
                player.sendMessage(prefix + "§cThis item is disabled on this server, if you believe this is a mistake, tell the owner of the server to enable it.");
            }
        }
    }
    @EventHandler
    public void onGrenadeUse(PotionSplashEvent event) {
        ItemStack item1 = event.getPotion().getItem();
        ProjectileSource source = event.getEntity().getShooter();
        Player player = (Player) source;
        assert player != null;
        World world = player.getWorld();
        Bukkit.getLogger().info("First");
        if (item1.hasItemMeta()) {
            if (Objects.equals(Objects.requireNonNull(event.getPotion().getItem().getItemMeta()).getLore(), Objects.requireNonNull(ItemHandler.grenade.getItemMeta()).getLore())) {
                Bukkit.getLogger().info("Seconds");
                ItemMeta potion_meta = event.getPotion().getItem().getItemMeta();

                event.setCancelled(true);

                if (config.getBoolean("grenade")) {
                    world.createExplosion(event.getPotion().getLocation(), config.getInt("grenade_radius"));
                } else {
                    player.sendMessage(prefix + "§cThis item is disabled on this server, if you believe this is a mistake, tell the owner of the server to enable it.");
                }
            }
        }
    }
}