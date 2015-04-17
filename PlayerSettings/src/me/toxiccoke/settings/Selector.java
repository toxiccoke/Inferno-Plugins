package me.toxiccoke.settings;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Selector implements Listener {
	
	public static Inventory s;

	public Selector() {
		s = Bukkit.createInventory(null, 9, "§cPlayer Settings");

		s.setItem(1,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cTitles", null));
		s.setItem(4,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cChatColor", null));
		s.setItem(7,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 15, "§cComingSoon", null));
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

	@EventHandler
	public void invClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equals(s.getName())) {
			e.setCancelled(true);
		}
		if (e.getCurrentItem() == null) {
			return;
		}

		if (!e.getCurrentItem().hasItemMeta()) {
			return;
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equals("§cTitles")){
			p.openInventory(me.toxiccoke.settings.Titles.t);
			}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equals("§cChatColor")) {
			p.openInventory(me.toxiccoke.settings.ChatColor.c);
			
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equals("§eKitPVP")) {
			
		}
	}
}