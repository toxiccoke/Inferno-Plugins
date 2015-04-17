package me.toxiccoke.prisoncoins;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Commands implements Listener, CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	  	Player p = (Player)sender;
	  	
	    if(cmd.getName().equalsIgnoreCase("prisoncoins")) {
	    	MyAPI.giveCoins(p, 110);
	  }
		return true;

}
}