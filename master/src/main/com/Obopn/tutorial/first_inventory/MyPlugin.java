package com.qq.lesson;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class MyPlugin extends JavaPlugin {
    public void onEnable() {
        say("插件已加载");
    }

    public void onDisable() {
        say("插件已卸载");
    }

    public boolean onCommand(Command cmd, CommandSender sender, String label, String args[]) {
        if(label.equalsIgnoreCase("test")) {
            Player p = (Player) sender;
            if(!(p instanceof Player)) {
                sender.sendMessage("§4这个指令只能在游戏中使用");
                return true;
            }
            Inventory inv = Bukkit.createInventory(null,54,"12");
            p.openInventory(inv);
            ItemStack is = new ItemStack(Material.COMPASS);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName("点我传送");
            im.setLore(Arrays.asList("一个功能"));
            inv.addItem(is);
            inv.setItem(9,is);
            return true;
        }
        return true;
    }

    public void say(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}
