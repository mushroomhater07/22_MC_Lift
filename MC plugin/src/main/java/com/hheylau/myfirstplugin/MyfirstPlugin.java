package com.hheylau.myfirstplugin;

import org.bukkit.plugin.java.JavaPlugin;
public final class MyfirstPlugin extends JavaPlugin{
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("hi");
        System.out.println("hi");System.out.println("hi");
        System.out.println("hi");System.out.println("hi");System.out.println("hi");
        System.out.println("the plugin has started. You may not notice but I'm here");

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("have a nice day");
        System.out.println("have a nice day");System.out.println("have a nice day");
        System.out.println("have a nice day");System.out.println("have a nice day");System.out.println("have a nice day");
        System.out.println("ahh, bye......");

    }
}
