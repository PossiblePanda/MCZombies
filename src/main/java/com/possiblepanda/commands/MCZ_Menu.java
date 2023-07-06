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

import java.util.Objects;

public class MCZ_Menu implements Listener, CommandExecutor {
    public MCZ_Menu(MCZombies plugin) {
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
            event.getWhoClicked().sendMessage("§7You have recieved §a" + curr_item.getAmount() + "x§c " + Objects.requireNonNull(curr_item.getItemMeta()).getDisplayName());
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
            event.getWhoClicked().sendMessage("§7You have recieved §a" + curr_item.getAmount() + "x§c " + Objects.requireNonNull(curr_item.getItemMeta()).getDisplayName());
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

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return true;
        }
        Player player = (Player) sender;

        int inv_size = 2;

        Inventory inv = Bukkit.createInventory(player, 9*inv_size, "MCZombies Give Menu");

        inv.addItem();

        player.openInventory(inv);

        return true;
    }
}
