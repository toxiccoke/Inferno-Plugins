package me.toxiccoke.tut;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Villager implements Listener{
	
	public void onInteract(PlayerInteractEntityEvent e){
		 Entity ent = e.getRightClicked();
		 Player p = e.getPlayer();
		 if(ent instanceof Pig){
		 ent.setPassenger(p);
		}
	}
}