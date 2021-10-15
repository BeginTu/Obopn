package com.qq;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
public class cow extends JavaPlugin {

    private Block block,block2;

    @Override
    public void onEnable() {
        say("插件已加载！");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("demo")) {
            Player player = (Player) sender;
            int x=(int)player.getLocation().getX(),
                y=(int)player.getLocation().getY(),
                z=(int)player.getLocation().getZ();
            World world = Bukkit.getWorld("world");
            block = world.getBlockAt(player.getLocation());
            block.setType(Material.DIAMOND_BLOCK);
            for(int i=1;i<=50;i++) {
                block2 = world.getBlockAt(x+i,y,z);
                block2.setType(Material.DIAMOND_BLOCK);
                block.setType(Material.GRASS_BLOCK);
                block = world.getBlockAt(x+i,y,z);
                
            }
            return true;
        }
        return true;
    }

    @Override
    public void onDisable() {
        say("插件已卸载！");
    }

    public void say(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}
