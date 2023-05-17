package com.hheylau.lift;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lift extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }
    //actual jump: event.getFrom().getY()+0.419
    @EventHandler
    public void onJump(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if ((event.getTo().getY()> event.getFrom().getY()+0.001)){
            Location block1 = event.getFrom();
            block1.setY(block1.getY() -1);
            Block jumpblock = block1.getBlock();
            if(jumpblock.getBlockData().getMaterial().toString() == "IRON_BLOCK"){
                player.sendMessage("you are up");
                try {
                    player.teleport(SearchForIronBlock(block1, true));
                }catch(Exception ex){ player.sendMessage("no iron block above");}
            }
        }
    }
    @EventHandler
    public void Crouch(PlayerToggleSneakEvent event){
        if(event.isSneaking() == true) {
            Player player = event.getPlayer();
            Location hi = player.getLocation();
            hi.setY(hi.getY() - 1);
            Block crouch1 = hi.getBlock();
            if (crouch1.getBlockData().getMaterial().toString() == "IRON_BLOCK") {
                player.sendMessage("you are down");
                try{player.teleport(SearchForIronBlock(hi, false));}
                catch(Exception ex){ player.sendMessage("no iron block below");}
            }
        }
    }

    public Location SearchForIronBlock(Location loc, Boolean up) {
        Location find = loc;
        Boolean repeat = true;
        if (up) {
            find.setY(find.getY() + 1);
            Block block = find.getBlock();
            while ((!(block.getBlockData().getMaterial().toString() == "IRON_BLOCK"))||repeat == true) {
                if (find.getY() > 257) {
                    return null;
                }
                find.setY(find.getY() + 1);
                block = find.getBlock();
                //check if tpable
                if(block.getBlockData().getMaterial().toString() == "IRON_BLOCK") {
                    Location check = find;
                    for (int i = 0; i < 2; i++) {
                        check.setY(find.getY() + 1);
                        System.out.println(check.getY());
                        Block checkclear = check.getBlock();
                        System.out.println(checkclear.getBlockData());
                        if (checkclear.getBlockData().getMaterial().toString() != "AIR") {
                            find.setY(check.getY());
                            break;
                        } else {
                            repeat = false;
                        }
                    }
                }
            }} else {
            find.setY(find.getY() - 1);
            Block block = find.getBlock();
            while ((!(block.getBlockData().getMaterial().toString() == "IRON_BLOCK"))|| repeat == true) {
                if (find.getY() < -129) {
                    return null;
                }
                find.setY(find.getY() - 1);
                block = find.getBlock();

            //check if tpable
            if(block.getBlockData().getMaterial().toString() == "IRON_BLOCK") {
                Location check = find;
                for (int i = 0; i < 2; i++) {
                    check.setY(find.getY() + 1);
                    System.out.println(check.getY());
                    Block checkclear = check.getBlock();
                    System.out.println(checkclear.getBlockData());
                    if (checkclear.getBlockData().getMaterial().toString() != "AIR") {
                        find.setY(find.getY() -1);
                        break;
                    } else {
                        repeat = false;
                    }
                }
            }
        }}
        find.setY(find.getY() + 1); //one up for player to stand, not in the block
        return find;
    }
    @EventHandler
    public void Put(BlockDamageEvent event){
        Player player = event.getPlayer();
        Block block1 = event.getBlock();
            player.sendMessage(block1.toString());
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
