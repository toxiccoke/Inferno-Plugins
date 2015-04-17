package me.toxiccokie.nocaps;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoCaps extends JavaPlugin implements Listener{
	
	
	public void OnEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onTalkEvent (PlayerChatEvent event) {
		event.setMessage(event.getMessage().toLowerCase());
	}
	}
