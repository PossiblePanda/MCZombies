package com.possiblepanda.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class ItemHandler implements Listener {
    public static ItemStack simpleBandage;
    public static ItemStack advancedBandage;
    public static ItemStack grenade;
    public static ItemStack trailMix;
    public static ItemStack cereal;
    public static ItemStack syringe;

    public static void init() {

        createSimpleBandage();
        createAdvancedBandage();
        createGrenade();
        createTrailMix();
        createCereal();
        createSyringe();
    }

    private static void createSimpleBandage() {
        ItemStack item = new ItemStack(Material.COOKED_BEEF, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Simple Bandage");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(Collections.singletonList("§a+5 §7instant health."));
        meta.setCustomModelData(1);
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
        meta.setLore(Collections.singletonList("§a+10 §7instant health."));
        meta.setCustomModelData(1);
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
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        grenade = item;
        // Crafting Recipe

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("grenade"), item);
        recipe.addIngredient(Material.IRON_NUGGET);
        recipe.addIngredient(Material.GUNPOWDER);
        recipe.addIngredient(Material.GLASS_BOTTLE);

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void createTrailMix() {
        ItemStack item = new ItemStack(Material.BREAD, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Trail mix");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(Collections.singletonList("§7A healthy, portable snack!"));
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        trailMix = item;
        // Crafting Recipe

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("trail_mix"), item);
        recipe.addIngredient(Material.WHEAT_SEEDS);

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void createCereal() {
        ItemStack item = new ItemStack(Material.BEETROOT_SOUP, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Cereal");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(Collections.singletonList("§7A perfect solution for food, especially for mornings."));
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        cereal = item;
        // Crafting Recipe

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("cereal"), item);
        recipe.addIngredient(new RecipeChoice.ExactChoice(trailMix));
        recipe.addIngredient(Material.BOWL);
        recipe.addIngredient(Material.MILK_BUCKET);

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void createSyringe() {
        ItemStack item = new ItemStack(Material.GLASS_BOTTLE, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Syringe");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(Collections.singletonList("§7''single use only'' - MilkyG"));
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        syringe = item;
        // Crafting Recipe

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("syringe"), item);
        recipe.shape("GAA", "AGA", "AAI");
        recipe.setIngredient('G', Material.GLASS);
        recipe.setIngredient('A', Material.AIR);
        recipe.setIngredient('I', Material.IRON_INGOT);

        Bukkit.getServer().addRecipe(recipe);
    }
}
