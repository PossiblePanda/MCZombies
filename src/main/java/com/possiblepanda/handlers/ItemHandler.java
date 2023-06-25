package com.possiblepanda.handlers;

import com.possiblepanda.MCZombies;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Furnace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.Collections;

public class ItemHandler implements Listener {
    public static FileConfiguration config = MCZombies.getPlugin(MCZombies.class).getConfig();
    String prefix = config.getString("prefix");

    public static ItemStack cloth;
    public static ItemStack simpleBandage;
    public static ItemStack advancedBandage;
    public static ItemStack grenade;
    public static ItemStack trailMix;
    public static ItemStack cereal;
    public static ItemStack syringe;
    public static ItemStack molotovCocktail;
    public static ItemStack steelNugget;
    public static ItemStack steelIngot;

    public static void init() {
        createCloth();
        createSimpleBandage();
        createAdvancedBandage();
        createGrenade();
        createTrailMix();
        createCereal();
        createSyringe();
        createMolotovCocktail();
        createSteelNugget();
        createSteelIngot();
    }
    private static void createCloth() {
        ItemStack item = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§bCloth");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(Collections.singletonList("§7A useful material"));
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        cloth = item;
        // Crafting Recipe

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("cloth"), item);
        recipe.addIngredient(3,Material.STRING);

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void createSimpleBandage() {
        ItemStack item = new ItemStack(Material.COOKED_BEEF, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§bSimple Bandage");
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
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(cloth));
        Bukkit.getServer().addRecipe(recipe);
    }

    private static void createAdvancedBandage() {
        ItemStack item = new ItemStack(Material.COOKED_MUTTON, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§bAdvanced Bandage");
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
        meta.setDisplayName("§bGrenade");
        meta.setLore(Collections.singletonList("§7Throw to create an explosion wherever it lands."));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        PotionMeta pmeta = (PotionMeta) item.getItemMeta();
        pmeta.setColor(Color.fromRGB(0,208,21));
        item.setItemMeta(pmeta);
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
        meta.setDisplayName("§bTrail mix");
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
        meta.setDisplayName("§bCereal");
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
        meta.setDisplayName("§bSyringe");
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
    private static void createMolotovCocktail() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§bMolotov Cocktail");
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(Collections.singletonList("§7Boom baby!"));
        meta.setCustomModelData(2);
        item.setItemMeta(meta);
        PotionMeta pmeta = (PotionMeta) item.getItemMeta();
        pmeta.setColor(Color.fromRGB(255,96,3));
        item.setItemMeta(pmeta);
        molotovCocktail = item;
        // Crafting Recipe

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("molotov_cocktail"), item);
        recipe.addIngredient(Material.FLINT_AND_STEEL);
        recipe.addIngredient(Material.GLASS_BOTTLE);
        recipe.addIngredient(new RecipeChoice.ExactChoice(cloth));

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void createSteelNugget() {
        ItemStack item = new ItemStack(Material.IRON_NUGGET, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§bSteel Nugget");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(Collections.singletonList("§7Me when Nugget. Nugget."));
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        steelNugget = item;
        // Furnace Recipe
        FurnaceRecipe recipe = new FurnaceRecipe(NamespacedKey.minecraft("steel_nugget"), item, new RecipeChoice.MaterialChoice(Material.IRON_NUGGET),1, config.getInt("steel_nugget_cook_time") * 20);
        Bukkit.getServer().addRecipe(recipe);
    }
    private static void createSteelIngot() {
        ItemStack item = new ItemStack(Material.IRON_INGOT,1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§bSteel Ingot");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(Collections.singletonList("§7A metal material!"));
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        steelIngot = item;
        // Crafting Recipe

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("steel_ingot"), item);
        recipe.shape("SSS", "SSS", "SSS");
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(steelNugget));
        Bukkit.getServer().addRecipe(recipe);
    }
}
