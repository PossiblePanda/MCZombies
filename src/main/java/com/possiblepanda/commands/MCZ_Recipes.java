package com.possiblepanda.commands;

import com.possiblepanda.MCZombies;
import com.possiblepanda.handlers.ItemHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.*;

import java.util.*;

public class MCZ_Recipes implements Listener, CommandExecutor {

    public MCZ_Recipes(MCZombies plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("MCZombies Recipe Menu")) {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        event.setCancelled(true);
        Bukkit.getLogger().info("TEST");
        if (event.getClick() == ClickType.LEFT) {
            Recipe recipe = (Recipe) Bukkit.getServer().getRecipesFor(Objects.requireNonNull(event.getCurrentItem()));
            if (recipe instanceof ShapedRecipe) {
                ShapedRecipe shaped = (ShapedRecipe) recipe;
            }
            else if (recipe instanceof ShapelessRecipe) {
                ShapelessRecipe shapeless = (ShapelessRecipe)recipe;
                int inv_size = 2;
                Bukkit.getLogger().info("TEST2");

                Inventory inv = Bukkit.createInventory(player, 9*inv_size, Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName());

                for (ItemStack itemStack : shapeless.getIngredientList()) {
                    inv.addItem(itemStack);
                    Bukkit.getLogger().info("TEST3");
                }
                Bukkit.getLogger().info("TEST4");
                player.openInventory(inv);
            }
            else if (recipe instanceof FurnaceRecipe) {
                FurnaceRecipe furnace = (FurnaceRecipe)recipe;
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return true;
        }
        Player player = (Player) sender;

        int inv_size = 2;

        Inventory inv = Bukkit.createInventory(player, 9*inv_size, "MCZombies Recipe Menu");

        for (ItemStack itemStack : ItemHandler.item_list) {
            inv.addItem(itemStack);
        }

        player.openInventory(inv);

        return true;
    }
}
