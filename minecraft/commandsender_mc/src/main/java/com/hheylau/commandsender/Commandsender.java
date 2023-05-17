package com.hheylau.commandsender;

import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Commandsender extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //   /die  - kill a player
        if(command.getName().equalsIgnoreCase("die")) {
            if (sender instanceof Player){
                Player pl = (Player) sender;
                pl.setHealth(0.0);
                pl.sendMessage(ChatColor.RED +"you have to die");
            } else if (sender instanceof ConsoleCommandSender) {
                System.out.println("This is run in console");
            }else if (sender instanceof BlockCommandSender){
                System.out.println("This is sent by cmd block");
            }
        }else if(command.getLabel().equalsIgnoreCase("poop")){
            Player pl = (Player) sender;
            pl.setHealth(5.0);
        }



        return true;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
