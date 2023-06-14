package com.possiblepanda.handlers;

import com.possiblepanda.MCZombies;
import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.GameEvent;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.meta.KnowledgeBookMeta;

import java.util.Collections;

public class ItemHandler implements Listener {
    public static ItemStack simpleBandage;
    public static ItemStack advancedBandage;
    public static ItemStack grenade;

    public static void init() {

        createSimpleBandage();
        createAdvancedBandage();
        createGrenade();
    }

    private static void createSimpleBandage() {
        ItemStack item = new ItemStack(Material.COOKED_BEEF, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Simple Bandage");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(Collections.singletonList("§a+5 §7 instant health."));
        item.setItemMeta(meta);
        simpleBandage = item;
        // Crafting Recipe

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("simple_bandage"), item);
        recipe.shape("XSX", "SWS", "XSX");
        recipe.setIngredient('X', Material.AIR);
        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('W', Material.WHITE_WOOL);
        Bukkit.getServer().addRecipe(recipe);
    }

    private static void createAdvancedBandage() {
        ItemStack item = new ItemStack(Material.COOKED_MUTTON, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Advanced Bandage");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(Collections.singletonList("§a+10 §7 instant health."));
        item.setItemMeta(meta);
        advancedBandage = item;
        // Crafting Recipe

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("advanced_bandage"), item);
        recipe.shape("SSS", "SBS", "SSS");
        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(simpleBandage));
        Bukkit.getServer().addRecipe(recipe);

    }

    private static void createGrenade() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Grenade");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(Collections.singletonList("§7Throw to create fire wherever it lands."));
        item.setItemMeta(meta);
        grenade = item;
        // Crafting Recipe

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("grenade"), item);
        recipe.addIngredient(Material.IRON_NUGGET);
        recipe.addIngredient(Material.GUNPOWDER);
        recipe.addIngredient(Material.GLASS_BOTTLE);

        Bukkit.getServer().addRecipe(recipe);
    }
}
