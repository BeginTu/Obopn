package com.qq.lesson;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        if(e.getRawSlot()==9) {
            Player p = (Player)e.getWhoClicked();
            p.chat("/spawn");
            p.closeInventory();
            e.setCancelled(true);
        }
    }
}
