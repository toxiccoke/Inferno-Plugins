package me.toxiccoke.etokens;

import java.util.HashMap;
import java.util.UUID;
import java.util.Map.Entry;

import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	private HashMap<UUID, Integer> money = new HashMap<>();

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	public void onDisable() {
		for (Entry<UUID, Integer> entry : money.entrySet()) {
			getConfig().set(entry.getKey() + ".Silver", entry.getValue());
		}

		saveConfig();
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if (!getConfig().contains(p.getUniqueId().toString())) {
			getConfig().set(p.getUniqueId() + ".Silver", 0);
			money.put(p.getUniqueId(), 0);
		} else {
			money.put(p.getUniqueId(), getConfig().getInt(p.getUniqueId() + ".Silver"));
		}
	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		if (e.getEntity() instanceof Monster) {
			if (e.getEntity().getKiller() instanceof Player) {
				Player p = e.getEntity().getKiller();
				giveSilver(p, 200);
			}
		} else if (e.getEntity() instanceof Villager) {
			if (e.getEntity() instanceof Player) {
				Player p = e.getEntity().getKiller();
				takeSilver(p, 200);
			}
		}
	}

	private void giveSilver(Player p, int i) {
		UUID uuid = p.getUniqueId();
		money.put(uuid, money.get(uuid) + i);
		p.sendMessage("�2�l$" + i + " silver received!");
	}

	private void takeSilver(Player p, int i) {
		UUID uuid = p.getUniqueId();
		money.put(uuid, money.get(uuid) - i);
		p.sendMessage("�c�l$" + i + " silver taken!");
	}
}