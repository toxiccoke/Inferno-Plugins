package me.toxiccoke.addons;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Main extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	private ItemStack make(Material material, int amount, int shrt, String displayName, List<String> string) {
		ItemStack item = new ItemStack(material, amount, (short) shrt);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(string);
		item.setItemMeta(meta);
		return item;
	}

	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		Entity passanger = e.getPlayer().getPassenger();
		if (p.getItemInHand().getType().equals(Material.BLAZE_ROD)) {
			if (p.getItemInHand().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§6Blaster")) {
				e.getRightClicked().setVelocity(e.getPlayer().getLocation().getDirection().multiply(3.5D)
					      .setY(1));
			}
				if (p.getItemInHand().getType().equals(Material.STICK)) {
					if (p.getItemInHand().getItemMeta().getDisplayName()
							.equalsIgnoreCase("§6SuperStick")) {
						e.getRightClicked().setVelocity(e.getPlayer().getLocation().getDirection().multiply(4.5D)
							      .setY(1));
			}
		}
			}
		}
	  @EventHandler
	  public void onPlayerToggleFlight(PlayerToggleFlightEvent event)
	  {
	    Player player = event.getPlayer();
	    if (player.getGameMode() == GameMode.CREATIVE) {
	      return;
	    }
	    event.setCancelled(true);
	    player.setAllowFlight(false);
	    player.setFlying(false);
	    player.setVelocity(player.getLocation().getDirection().multiply(1.0D)
	      .setY(1));
	  }
	  
	  @EventHandler
	  public void onPlayerMove(PlayerMoveEvent event)
	  {
	    Player player = event.getPlayer();
	    if ((player.getGameMode() != GameMode.CREATIVE) && 
	      (player.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR) && (!player.isFlying()))
	player.setAllowFlight(true);
	    }
	  @EventHandler
	  public void onzombiedeath(PlayerDeathEvent e){
	  Player p = e.getEntity();
	  
	  p.chat("/home");
	  }
		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String commandlabel,
				String[] args) {
			
			Player p = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("class")){
				
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "Choose a backpack from 9-54");
					return true;

				} else {
					String arg1 = args[0];
					
					if (arg1.equals("rod")) {
						p.getInventory().addItem(
								make(Material.BLAZE_ROD, 1, 0, "§6Blaster", Arrays.asList("Test", "Line 2")));
					}
						if (arg1.equals("stick")) {
							p.getInventory().addItem(
									make(Material.STICK, 1, 0, "§6SuperStick", Arrays.asList("Test", "Line 2")));
					}
				}
			}
			return false;
			}
		public int i = 5;
		@EventHandler
		public void onJoin(PlayerJoinEvent e){
			Player  p = e.getPlayer();
			if (Bukkit.getOnlinePlayers().length >= 4) {
				this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

					@Override
					public void run() {
						if(i!=-1){
							if(i != 0)
							{
								Bukkit.broadcastMessage(ChatColor.AQUA + "The Game Is About To Begin In " + i + " seconds");
								i--;
							}else{
								Bukkit.broadcastMessage("test");
								i--;
							}
						}
						
					}
					
				}, 0L, 20L );
			}
			return;
		}

	}

		