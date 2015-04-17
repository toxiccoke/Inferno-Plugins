package me.toxiccokearenabrawl.handlers;

import java.util.ArrayList;

import me.toxiccokearenabrawl.Main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump extends Main implements Listener{
	
	ArrayList<Player> cooldown = new ArrayList<Player>();
	
	Main plugin;
	
	  @EventHandler
	  public void onPlayerToggleFlight(PlayerToggleFlightEvent event)
	  {
	    Player p = event.getPlayer();
	    if (p.getGameMode() == GameMode.CREATIVE) {
	      return;
	    }
	    event.setCancelled(true);
	    p.setAllowFlight(false);
	    p.setFlying(false);
	    p.setVelocity(p.getLocation().getDirection().multiply(1.0D)
	      .setY(1));
	  }
	  
	  @EventHandler
	  public void onPlayerMove(PlayerMoveEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((p.getGameMode() != GameMode.CREATIVE) && 
	      (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR) && (!p.isFlying()))
	p.setAllowFlight(true);
    cooldown.add(p);
    plugin.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            public void run() {
                    cooldown.remove(p);
            }
    }, 100);
    return;
}
}

