package me.toxiccoke.prisoncoins;


import me.toxiccoke.prisoncoins.signs.Efficiency;
import me.toxiccoke.prisoncoins.signs.Explosive;
import me.toxiccoke.prisoncoins.signs.Fortune;
import me.toxiccoke.prisoncoins.signs.Haste;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
  implements Listener
{
  public static FileConfiguration config;
  public static Main plugin = null;


  public void onEnable()
  {
	getServer().getPluginManager().registerEvents(new Fortune(), this);
	getServer().getPluginManager().registerEvents(new Efficiency(), this);
    getServer().getPluginManager().registerEvents(new EventHandlers(), this);
    getServer().getPluginManager().registerEvents(new Haste(), this);
    getServer().getPluginManager().registerEvents(new Explosive(), this);
    getServer().getPluginManager().registerEvents(this, this);

    config = getConfig();

    plugin = this;
    
	Commands c = new Commands();
	getCommand("prisoncoins").setExecutor(c);
     
  }

  public static void saveFile() {
    plugin.saveConfig();
  }
}