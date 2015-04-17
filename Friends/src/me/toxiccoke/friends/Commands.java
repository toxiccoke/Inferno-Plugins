package me.toxiccoke.friends;

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
		 Player target = Bukkit.getServer().getPlayer(args[0]);
		 
		if(label.equalsIgnoreCase("friends")){
			p.sendMessage(ChatColor.RED + "Friends Commands");
			p.sendMessage(ChatColor.YELLOW + "/friends add (name)");
			p.sendMessage(ChatColor.YELLOW + "/friends accept (name)");
			p.sendMessage(ChatColor.YELLOW + "/friends remove (name)");
			p.sendMessage(ChatColor.YELLOW + "/friends requests");
			
		}
		return false;
	  }
	  }
