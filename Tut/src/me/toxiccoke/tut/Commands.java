package me.toxiccoke.tut;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Commands implements Listener, CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		Location loc = p.getLocation();
		
		if(cmd.getName().equalsIgnoreCase("tutorial")){
			Villager v = (Villager) loc.getWorld().spawn(loc, Villager.class);
			v.setCustomName(ChatColor.GREEN + "Tutorial");
			v.setCustomNameVisible(true);
			v.setProfession(Profession.BLACKSMITH);
		}
		
		return false;
		
	}

}
