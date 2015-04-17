package me.toxiccoke.clans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Commands implements Listener, CommandExecutor{
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		 Player  p = (Player) sender;
		 
		if(label.equalsIgnoreCase("clans")){
			p.sendMessage(ChatColor.BLUE + "------------------------------");
			p.sendMessage(ChatColor.RED + "Clans Commands");
			p.sendMessage(ChatColor.YELLOW + "/clan create (name)");
			p.sendMessage(ChatColor.YELLOW + "/clan invite (name)");
			p.sendMessage(ChatColor.YELLOW + "/clan kick (name)");
			p.sendMessage(ChatColor.YELLOW + "/clan leave");
			p.sendMessage(ChatColor.YELLOW + "/clan disband");
			p.sendMessage(ChatColor.BLUE + "------------------------------");
			
		}
		return false;
	}

}
