package me.toxiccoke.settings;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Commands implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
		 
		 Player p = (Player) sender;
		 
		 if(cmd.getName().equalsIgnoreCase("pp")){
			 p.openInventory(me.toxiccoke.settings.Selector.s);
			 p.sendMessage("§cPlayerSettings> §8Opening Settings");
		 }
		return false;

}
}
