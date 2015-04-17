package me.toxiccoke.prisoncoins;

import org.bukkit.entity.Player;

public class MyAPI
{
  public static void giveCoins(Player p, int i)
  {
    Main.config.set(p.getUniqueId() + ".Coins", 
      Integer.valueOf(Main.config.getInt(p.getUniqueId() + ".Coins", 0) + i));
    Main.saveFile();
    p.sendMessage("§a§l+ " + i + " PrisonCoins!");
  }

  public static void takeCoins(Player p, int i) {
    Main.config.set(p.getUniqueId() + ".Coins", 
      Integer.valueOf(Main.config.getInt(p.getUniqueId() + ".Coins", 0) - i));
    Main.saveFile();
    p.sendMessage("§c§l- " + i + " PrisonCoins!");
  }

  public static boolean hasEnough(Player p, int i)
  {
    if (Main.config.getInt(p.getUniqueId() + ".Coins") <= i)
      return true;
    return false;
  }
}