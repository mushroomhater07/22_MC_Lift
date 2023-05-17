package com.hheylau.eventlistener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
public final class Eventlistener extends JavaPlugin implements Listener {
    public int numberOfplayer;
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("The plugin has started-----=====-----");

        getServer().getPluginManager().registerEvents(this, this);
        //implement listener from the class and extend from JavaPlugin
        // this class has listener and plugin so, "this" means this class
    }

    @EventHandler
    public void playerjoin(PlayerJoinEvent event){
        numberOfplayer += 1;
        System.out.println("A player has joined to the server.");
        event.setJoinMessage("Welcome to this server");
        event.notifyAll();
    }

    @EventHandler
    public void playerquit(PlayerQuitEvent event){
        numberOfplayer -= 1;
    }
    @EventHandler
    public void leaveBed(PlayerBedLeaveEvent event){
        Player player = event.getPlayer();
        player.setHealth(0);
        player.setHealthScale(5);
        player.sendMessage("起身屌閪啦 ");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
