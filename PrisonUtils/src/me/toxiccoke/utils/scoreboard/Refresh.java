package me.toxiccoke.utils.scoreboard;

import me.toxiccoke.utils.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class Refresh extends Main implements Listener{
	
	  public void updateScoreboard(){
		  new BukkitRunnable(){
		    @Override
		    public void run(){
		      for(Player p : Bukkit.getOnlinePlayers()){
		          Scoreboard.showScoreboard(p);    
		       }
		    }
		   } .runTaskTimer(this, 40, 40);
		}

}
