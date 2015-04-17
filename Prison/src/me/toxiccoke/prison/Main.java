package me.toxiccoke.prison;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	final Logger log = Logger.getLogger("Minecraft");
	public static Plugin plugin;
	
	public void onEnable(){
		System.out.println("Core Enabled");
		plugin = this;

		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new me.toxiccoke.prison.ranks, this);
	}

}
