package com.qq.me;

import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
public class Tutorial extends JavaPlugin {

    public static Player player;

    @Override
    public void onEnable() {say("插件已加载！");}

    @Override
    public void onDisable() {say("插件已卸载！");}
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("demo")) {
            player = (Player)sender;
            new Example(this).start(0,1L);
            return true;
        }
        return true;
    }

    public void say(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}

class Example extends BukkitRunnable {

    public Plugin plugin;
    private World world;
    private Block block;
    private int x,y,z,s=50,i=0;

    public Example(Plugin plugin) {
        world = Bukkit.getWorld("world");
        Player player = Tutorial.player;
        block = world.getBlockAt(player.getLocation());
        x=player.getLocation().getBlockX();
        y=player.getLocation().getBlockY();
        z=player.getLocation().getBlockZ();
        this.plugin=plugin;
    }

    @Override
    public void run() {
        s--;
        i++;
        if(s<=0) this.cancel();
        //TODO
        Block block2;
        block.setType(Material.DIAMOND_BLOCK);
        block2 = world.getBlockAt(x+i,y,z);
        block2.setType(Material.DIAMOND_BLOCK);
        //block,捡石子的人，TA需要跟在block2的后面捡石子，于是乎block本身需要改变TA的位置
        block.setType(Material.GRASS_BLOCK);
        block = world.getBlockAt(x+i,y,z);
    }

    //任务执行开始函数
    public void start(long delay,long time) {
        this.runTaskTimer(this.plugin,20L*delay,20L*time);
    }
}