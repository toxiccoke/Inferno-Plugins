package me.toxiccoke.settings;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Titles implements Listener {
	
	public static Inventory t;

	public Titles() {
		t = Bukkit.createInventory(null, 18, "§cTitles");

		t.setItem(0,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cSusieBarMihauw", null));
		t.setItem(1,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§c#Inferno", null));
		t.setItem(2,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cFat Unicorn", null));
		t.setItem(3,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cBaconBits", null));
		t.setItem(4,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cAddicted", null));
		t.setItem(5,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cDonor", null));
		t.setItem(6,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cMoneyMan", null));
		t.setItem(7,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cSwag", null));
		t.setItem(8,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cYolo", null));
		t.setItem(9,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cMVP", null));
		t.setItem(10,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cTryHard", null));
		t.setItem(11,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cUnstopable", null));
		t.setItem(12,
				createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§cKing", null));
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
		if (e.getInventory().getName().equals(t.getName())) {
			e.setCancelled(true);
		}
		if (e.getCurrentItem() == null) {
			return;
		}

		if (!e.getCurrentItem().hasItemMeta()) {
			return;
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equals("§cSusieBarMihauw")){
			
			
			}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equals("§c#Inferno")) {
			p.setDisplayName("[Test1]" + p.getName());
			
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equals("§eKitPVP")) {
			
		}
	}
}