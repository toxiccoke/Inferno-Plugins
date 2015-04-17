package me.toxiccoke.utils.scoreboard;

import me.toxiccoke.prisoncoins.Main;
import me.toxiccoke.prisoncoins.MyAPI;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;
 
public class Scoreboard implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		showScoreboard(p);
	}
	
	 public static void showScoreboard(Player p) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();

		Objective objective = board.registerNewObjective("test", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.GOLD + "§6§lInferno Network ");
		Score Online = objective.getScore("§cOnline");
		Online.setScore(11);
		Score Online1 = objective.getScore("§4» " + p.getServer().getOnlinePlayers().length + "/" + p.getServer().getMaxPlayers());
		Online1.setScore(10);
		
		Score Spacer0 = objective.getScore("  ");
		Spacer0.setScore(9);
		
		Score Balance = objective.getScore("§cBalance");
		Balance.setScore(8);
		Score Balance1 = objective.getScore("§4» $" + me.toxiccoke.utils.Main.econ.getBalance(p.getName()));
		Balance1.setScore(7);
		
		Score Spacer1 = objective.getScore(" ");
		Spacer1.setScore(6);
		
		Score Coins = objective.getScore("§cPrisonCoins");
		Coins.setScore(5);
		Score Coins1 = objective.getScore("§4» " + Main.plugin.getConfig().getInt(p.getUniqueId() + ".Coins"));
		Coins1.setScore(4);
		
		p.setScoreboard(board);
			
		}
	 

}
