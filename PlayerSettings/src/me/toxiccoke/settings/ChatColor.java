package me.toxiccoke.settings;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChatColor implements Listener {
	
	public static Inventory c;

	public ChatColor() {
		c = Bukkit.createInventory(null, 18, "§cChatColor");

		c.setItem(0,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 11, "§1Blue", null));
		c.setItem(1,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 13, "§2Green", null));
		c.setItem(2,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 3, "§3Aqua", null));
		c.setItem(3,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 3, "§4Aqua", null));
		c.setItem(4,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 3, "§5Aqua", null));
		c.setItem(5,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 3, "§6Aqua", null));
		c.setItem(6,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 3, "§7Aqua", null));
		c.setItem(7,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 3, "§8Aqua", null));
		c.setItem(8,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 3, "§9Aqua", null));
		c.setItem(9,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 3, "§3Aqua", null));
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
}
