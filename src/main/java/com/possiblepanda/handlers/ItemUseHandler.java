package com.possiblepanda.handlers;

import com.possiblepanda.MCZombies;
import com.possiblepanda.components.CustomMob;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Fire;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import sun.jvm.hotspot.opto.Block_List;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ItemUseHandler implements Listener {
    FileConfiguration config = MCZombies.getPlugin(MCZombies.class).getConfig();
    String prefix = config.getString("prefix");
    public ItemUseHandler(MCZombies plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void breakChance(int breakChance, ItemStack item, Player player, EquipmentSlot slot) {
        final int number = ThreadLocalRandom.current().nextInt(1, 100);
        Inventory inv = player.getInventory();
        Bukkit.getLogger().info(Integer.toString(number));
        if (number <= breakChance) {
            item.setAmount(item.getAmount()-1);
//            inv.setItem(test);
        }
    }

    @EventHandler
    public void onSimpleBandageUse(PlayerItemConsumeEvent event) {
        ItemStack item1 = event.getItem();
        if (Objects.equals(Objects.requireNonNull(item1.getItemMeta()).getLore(), Objects.requireNonNull(ItemHandler.simpleBandage.getItemMeta()).getLore())) {
            Player player = event.getPlayer();
            event.setCancelled(true);

            double heal_amount = 3;
            double max_health = 20;
//            player.setHealth(player.getHealth() + heal_amount);
//            player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
            if (config.getBoolean("simple_bandage")) {
                if (player.getHealth() < max_health - heal_amount) {
                    player.setHealth(player.getHealth() + heal_amount);
                    player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
                    //breakChance(50, ItemHandler.simpleBandage, player, event.getHand());
                } else {
                    player.setHealth(max_health);
                    player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
                    //breakChance(50, ItemHandler.simpleBandage, player;
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

            double heal_amount = 7;
            double max_health = 20;
//            player.setHealth(player.getHealth() + heal_amount);
//            player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
            if (config.getBoolean("advanced_bandage")) {
                if (player.getHealth() < max_health - heal_amount) {
                    player.setHealth(player.getHealth() + heal_amount);
                    player.sendMessage(prefix + "§7You have been healed for §a+" + heal_amount + ".");
                   // breakChance(35, ItemHandler.advancedBandage, player);
                } else {
                    player.setHealth(max_health);
                    player.sendMessage("§7You have been healed for §a+" + heal_amount + ".");
//                    breakChance(35, ItemHandler.advancedBandage, player);
                }
            } else {
                player.sendMessage(prefix + "§cThis item is disabled on this server, if you believe this is a mistake, tell the owner of the server to enable it.");
            }
        }
    }
    @EventHandler
    public void onTrailMixUse(PlayerItemConsumeEvent event) {
        ItemStack item1 = event.getItem();
        if (Objects.equals(Objects.requireNonNull(item1.getItemMeta()).getLore(), Objects.requireNonNull(ItemHandler.trailMix.getItemMeta()).getLore())) {
            Player player = event.getPlayer();

            event.setCancelled(true);

            double food_amount = 3;
            double max_hunger = 20;
                if (player.getFoodLevel() < max_hunger - food_amount) {
                    player.setFoodLevel((int) (player.getFoodLevel() + food_amount));
                    CustomMob.SPEED_ZOMBIE.spawn(player.getLocation());
                } else {
                    player.setFoodLevel((int) max_hunger);
                    CustomMob.SPEED_ZOMBIE.spawn(player.getLocation());
                }
        }
    }
    @EventHandler
    public void onCerealUse(PlayerItemConsumeEvent event) {
        ItemStack item1 = event.getItem();
        if (Objects.equals(Objects.requireNonNull(item1.getItemMeta()).getLore(), Objects.requireNonNull(ItemHandler.cereal.getItemMeta()).getLore())) {
            event.setCancelled(true);
            Player player = event.getPlayer();

            event.setCancelled(true);

            double food_amount = 6;
            double max_hunger = 20;
            if (player.getFoodLevel() < max_hunger - food_amount) {
                player.setFoodLevel((int) (player.getFoodLevel() + food_amount));
            } else {
                player.setFoodLevel((int) max_hunger);
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
    @EventHandler
    public void onMolotovCocktailUse(PotionSplashEvent event) {
        ItemStack item1 = event.getPotion().getItem();
        ProjectileSource source = event.getEntity().getShooter();
        Player player = (Player) source;
        assert player != null;
        World world = player.getWorld();
        if (item1.hasItemMeta()) {
            if (Objects.equals(Objects.requireNonNull(event.getPotion().getItem().getItemMeta()).getLore(), Objects.requireNonNull(ItemHandler.molotovCocktail.getItemMeta()).getLore())) {
                ItemMeta potion_meta = event.getPotion().getItem().getItemMeta();
                event.setCancelled(true);
                if (config.getBoolean("molotov")) {
                    world.createExplosion(event.getPotion().getLocation(), config.getInt("molotov_radius"),true);
                } else {
                    player.sendMessage(prefix + "§cThis item is disabled on this server, if you believe this is a mistake, tell the owner of the server to enable it.");
                }
            }
        }
    }
    @EventHandler
    public void onSpawnEggUse(PlayerInteractEvent event) {
        if(event.getItem().getItemMeta().equals(ItemHandler.speedZombieSpawnEgg.getItemMeta())) {
            event.setCancelled(true);
            Location loc;
            if (Objects.requireNonNull(event.getClickedBlock()).isPassable()) {
                loc = event.getClickedBlock().getLocation().add(0.5,0,0.5);
            }
            else {
                loc = event.getClickedBlock().getRelative(event.getBlockFace()).getLocation().add(0.5,0,0.5);
            }
            CustomMob.SPEED_ZOMBIE.spawn(loc);
        }
    }
}