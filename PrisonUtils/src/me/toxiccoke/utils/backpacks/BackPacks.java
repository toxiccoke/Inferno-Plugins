package me.toxiccoke.utils.backpacks;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BackPacks implements Listener, CommandExecutor {
	
	private ItemStack make(Material material, int amount, int shrt, String displayName, List<String> string) {
		ItemStack item = new ItemStack(material, amount, (short) shrt);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(string);
		item.setItemMeta(meta);
		return item;
	}
	
	@EventHandler
	public void inventoryClick(InventoryClickEvent event) {
	    event.getInventory().setMaxStackSize(127);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel,
			String[] args) {
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("backpack")){
			
			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "Choose a backpack from 9-54");
				return true;

			} else {
				String arg1 = args[0];
				
				if (arg1.equals("9")) {
					p.sendMessage("§9BackPacks> §8You Have Recived A 9 Slot Backpack");
					p.getInventory().addItem(
							make(Material.CHEST, 1, 0, "§e 9 Slot Backpack §7(RightClick)", Arrays.asList("Test", "Line 2")));
					
				}else if (arg1.equals("18")) {
					p.sendMessage("§9BackPacks> §8You Have Recived A 18 Slot Backpack");
					p.getInventory().addItem(
							make(Material.CHEST, 1, 0, "§e 18 Slot Backpack §7(RightClick)", Arrays.asList("Test", "Line 2")));
					
				}else if (arg1.equals("27")) {
					p.sendMessage("§9BackPacks> §8You Have Recived A 27 Slot Backpack");
					p.getInventory().addItem(
							make(Material.CHEST, 1, 0, "§e 27 Slot Backpack §7(RightClick)", Arrays.asList("Test", "Line 2")));
					
				}else if (arg1.equals("36")) {
					p.sendMessage("§9BackPacks> §8You Have Recived A 36 Slot Backpack");
					p.getInventory().addItem(
							make(Material.CHEST, 1, 0, "§e 36 Slot Backpack §7(RightClick)", Arrays.asList("Test", "Line 2")));
					
				}else if (arg1.equals("45")) {
					p.sendMessage("§9BackPacks> §8You Have Recived A 45 Slot Backpack");
					p.getInventory().addItem(
							make(Material.CHEST, 1, 0, "§e 45 Slot Backpack §7(RightClick)", Arrays.asList("Test", "Line 2")));
					
				}else if (arg1.equals("54")) {
					p.sendMessage("§9BackPacks> §8You Have Recived A 54 Slot Backpack");
					p.getInventory().addItem(
							make(Material.CHEST, 1, 0, "§e 54 Slot Backpack §7(RightClick)", Arrays.asList("Test", "Line 2")));
				}
			}
		}
		return false;
	}
}
