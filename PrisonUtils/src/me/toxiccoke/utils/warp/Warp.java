package me.toxiccoke.utils.warp;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Warp implements Listener, CommandExecutor{
	
	public static Inventory w;

	public Warp() {
		w = Bukkit.createInventory(null, 9, "§aGameSelector");

		w.setItem(0,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cRank1", null));
		w.setItem(1,
				createItem(Material.IRON_FENCE, 1, (short) 0, "§aPrison", null));
		w.setItem(2,
				createItem(Material.DIAMOND_CHESTPLATE, 1, (short) 0, "§eKitPVP", null));
		w.setItem(3,
				createItem(Material.NETHER_STAR, 1, (short) 0, "§6Creative", null));
		w.setItem(8,
				createItem(Material.MINECART, 1, (short) 0, "§8Close", null));
	}

	public ItemStack createItem(Material material, int amount, short shrt,
			String displayname, String lore) {
		ItemStack item = new ItemStack(material, amount, shrt);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayname);
		ArrayList Lore = new ArrayList();
		Lore.add(lore);
		meta.setLore(Lore);

		item.setItemMeta(meta);
		return item;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args){
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("warp")){
			p.openInventory(w);
			
		}
		
		return false;
		
}
	

}
