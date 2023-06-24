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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class MCZ_Give implements Listener, CommandExecutor {

    public MCZ_Give(MCZombies plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("MCZombies Give Menu")) {
            return;
        }
        event.setCancelled(true);
        Bukkit.getLogger().info("TEST");
        if (event.getClick() == ClickType.LEFT) {
            ItemStack curr_item = event.getCurrentItem();
            event.getWhoClicked().getInventory().addItem(curr_item);
            assert curr_item != null;
            event.getWhoClicked().sendMessage("§7You have recieved §a1x §c" + Objects.requireNonNull(curr_item.getItemMeta()).getDisplayName());
        }
//        if (event.getClick() == ClickType.SHIFT_LEFT) {
//            ItemStack curr_item = event.getCurrentItem();
//            event.getWhoClicked().getInventory().addItem(curr_item);
//        }
        if (event.getClick() == ClickType.RIGHT) {
            ItemStack curr_item = event.getCurrentItem();
            assert curr_item != null;
            curr_item.setAmount(64);
            event.getWhoClicked().getInventory().addItem(curr_item);
            event.getWhoClicked().sendMessage("§7You have recieved §a64x §c" + Objects.requireNonNull(curr_item.getItemMeta()).getDisplayName());
        }
//        if (event.getClick() == ClickType.SHIFT_RIGHT) {
//            ItemStack curr_item = event.getCurrentItem();
//            assert curr_item != null;
//            curr_item.setAmount(64);
//            event.getWhoClicked().getInventory().addItem(curr_item);
//        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){

        List<ItemStack> item_list = new ArrayList<ItemStack>();

        // Very bad way of doing this, I suck at java so feel free to optimize if you want :)
        item_list.add(ItemHandler.cloth);
        item_list.add(ItemHandler.simpleBandage);
        item_list.add(ItemHandler.advancedBandage);
        item_list.add(ItemHandler.grenade);
        item_list.add(ItemHandler.trailMix);
        item_list.add(ItemHandler.cereal);
        item_list.add(ItemHandler.syringe);
        item_list.add(ItemHandler.molotovCocktail);

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return true;
        }
        Player player = (Player) sender;

        int inv_size = 1;

        Inventory inv = Bukkit.createInventory(player, 9*inv_size, "MCZombies Give Menu");

        for (ItemStack itemStack : item_list) {
            inv.addItem(itemStack);
        }

        player.openInventory(inv);

        return true;
    }
}
