package com.possiblepanda.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

public class ItemHandler {
    public static ItemStack simpleBandage;
    public static ItemStack advancedBandage;

    public static void init() {
        createSimpleBandage();
        createAdvancedBandage();
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

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("simple_bandage"), item);
        recipe.addIngredient(4, Material.STRING);
        recipe.addIngredient(1, Material.COOKED_BEEF);
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
        recipe.shape("XSX","SBS", "XSX");
        recipe.setIngredient('X', Material.AIR);
        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(advancedBandage));
        Bukkit.getServer().addRecipe(recipe);

    }
}
