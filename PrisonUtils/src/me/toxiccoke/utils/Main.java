package me.toxiccoke.utils;

import me.toxiccoke.utils.backpacks.BackPacks;
import me.toxiccoke.utils.scoreboard.Scoreboard;
import me.toxiccoke.utils.warp.Warp;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;

public class Main extends JavaPlugin implements Listener {
	
	public static Plugin plugin;
    public static Economy econ;
    public static EconomyResponse r;
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new BackPacks(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Scoreboard(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Warp(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Commands(), this);
		
		  if (!setupEconomy() ) {
	            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
	            
	            me.toxiccoke.utils.warp.Warp c = new me.toxiccoke.utils.warp.Warp();
	            getCommand("warp").setExecutor(c);
		
		  }
	}
		    public boolean setupEconomy() {
		        if (getServer().getPluginManager().getPlugin("Vault") == null) {
		            return false;
		        }
		        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		        if (rsp == null) {
		            return false;
		        }
		        econ = rsp.getProvider();
		        return econ != null;
		    }
}
