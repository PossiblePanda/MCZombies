package com.possiblepanda;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class utils {

    public static ItemStack materialToItemStack(Material mat, int amount) {
        return new ItemStack(mat, amount);
    }

}
