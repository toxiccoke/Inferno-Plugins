package me.toxiccoke.friends;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{ 
	
	static Main plugin;
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new Commands(), this);
		
		Commands c = new Commands();
		getCommand("friends").setExecutor(c);
		
	}
	
	

}
