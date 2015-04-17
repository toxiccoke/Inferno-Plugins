package me.toxiccoke.prisoncoins;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHandlers
  implements Listener
{

@EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();

    if (!Main.config.contains(p.getName()))
      Main.config.set(p.getUniqueId() + ".Coins", Integer.valueOf(0));
  }
}