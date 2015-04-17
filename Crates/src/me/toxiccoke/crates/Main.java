package me.toxiccoke.crates;

import java.util.Map.Entry;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Main extends JavaPlugin implements Listener {
	
    private Random random;
    private Material[] items;
    
        @Override
        public void onEnable() {
        	Bukkit.getServer().getPluginManager().registerEvents(this, this);
        	Bukkit.getServer().getPluginManager().registerEvents(new Commands(), this);
        	
            Commands c = new Commands();
    		getCommand("crates").setExecutor(c);
        	
        	getConfig().options().copyDefaults(true);
            saveConfig();
           
            this.random = new Random();
            this.items = new Material[100];
           
            int index = 0;
            for (Entry<String, Object> entry : getConfig().getConfigurationSection("items").getValues(false).entrySet()) {
                    for (int i = 0; i < Integer.valueOf(entry.getValue().toString()); i++) {
                            items[index++] = Material.valueOf(entry.getKey().toUpperCase());
                    }
              }	
        }
        
        @EventHandler
        
        public void clickBlock(PlayerInteractEvent e){
         
        Player p = e.getPlayer();
         
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
         
        Block b = e.getClickedBlock();
         
        if (b.getType() == Material.CHEST )
         
        e.setCancelled(true);
         
        if (e.getPlayer().getItemInHand().getType() == Material.TRIPWIRE_HOOK && e.getPlayer()
        		.getItemInHand().getItemMeta().getDisplayName().equals("§c§lVoting Crate Key")){

        p.getInventory().addItem(new ItemStack(items[random.nextInt(items.length)]));
        
        if (e.getPlayer().getItemInHand().getType() == Material.TRIPWIRE_HOOK && e.getPlayer()
        		.getItemInHand().getItemMeta().getDisplayName().equals("§c§lVoting Crate Key")){
        p.getInventory().removeItem(new ItemStack(Material.TRIPWIRE_HOOK));
         
        p.updateInventory();
         
        } else {
                    	if(p.getItemInHand() == null){
                            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                                    if (b.getType() == Material.CHEST){
                                    	p.sendMessage(ChatColor.RED + "You must use a vote key to recive a gift");
                                    	e.setCancelled(true);
                                    	
                	        }       	
                        }
                    }
                }
            }
        }
    }
}