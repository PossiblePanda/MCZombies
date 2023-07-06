package com.possiblepanda.components;

import com.possiblepanda.utility.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum CustomMob {
    SPEED_ZOMBIE("Speed Zombie", 15, EntityType.ZOMBIE, null, null, new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3), new LootItem(utils.materialToItemStack(Material.ROTTEN_FLESH, 1), 75));

    private String name;
    private double maxHealth;
    private EntityType type;
    private ItemStack mainItem;
    private ItemStack[] armour;
    private List<LootItem> lootTable;
    private PotionEffect potion;

    CustomMob(String name, double maxHealth, EntityType type, ItemStack mainItem, ItemStack[] armour, PotionEffect potion, LootItem... lootItems) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.type = type;
        this.mainItem = mainItem;
        this.armour = armour;
        this.potion = potion;
        lootTable = Arrays.asList(lootItems);
    }

    public LivingEntity spawn(Location location) {
        LivingEntity entity = (LivingEntity) Objects.requireNonNull(location.getWorld()).spawnEntity(location, type);
        entity.setCustomNameVisible(true);
        entity.setCustomName(name);
        Objects.requireNonNull(entity.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(maxHealth);
        entity.setHealth(maxHealth);
        entity.addPotionEffect(potion);
        EntityEquipment inv = entity.getEquipment();
        if (armour != null) inv.setArmorContents(armour);
        inv.setHelmetDropChance(0f);
        inv.setChestplateDropChance(0f);
        inv.setLeggingsDropChance(0f);
        inv.setBootsDropChance(0f);
        inv.setItemInMainHand(mainItem);
        inv.setItemInMainHandDropChance(0f);
        return entity;
    }

    public void tryDropLoot(Location location) {
        for (LootItem item : lootTable) {
            item.tryDropItem(location);
        }
    }

    public String getName() {
        return name;
    }

    public double getMaxHealth() {
        return maxHealth;
    }
}


