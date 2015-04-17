package me.toxiccoke.crates;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Commands implements Listener, CommandExecutor{
	
	private ItemStack make(Material material, int amount, int shrt, String displayName, List<String> string) {
		ItemStack item = new ItemStack(material, amount, (short) shrt);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(string);
		item.setItemMeta(meta);
		return item;
	}

	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
		 
		 Player p = (Player) sender;
		 String cName = cmd.getName().toLowerCase();
		 
			if (!cmd.getName().equals("crates"))
				return false;

			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "crates givekey (Player)");
				return true;

			} else {
				String arg1 = args[0];
				if (arg1.equals("givekey")) {
					p.getInventory().addItem(
							make(Material.TRIPWIRE_HOOK, 1, 0, "§c§lVoting Crate Key", null));
					
				}else if (arg1.equals("givecrate")) {
						p.getInventory().addItem(
								make(Material.CHEST, 1, 0, "§c§lVote Crate", null));
					
				}
			}
		return false;
	 }
}
