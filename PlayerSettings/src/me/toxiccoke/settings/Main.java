package me.toxiccoke.settings;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new Commands(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Selector(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Titles(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ChatColor(), this);
		
	    Commands c = new Commands();
		getCommand("pp").setExecutor(c);
	}
	

}
