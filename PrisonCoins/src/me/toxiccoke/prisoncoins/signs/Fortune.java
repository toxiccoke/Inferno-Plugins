package me.toxiccoke.prisoncoins.signs;

import java.util.Arrays;
import java.util.List;

import me.toxiccoke.prisoncoins.MyAPI;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Fortune implements Listener{
	
	private ItemStack make(Material material, int amount, int shrt, String displayName, List<String> string) {
		ItemStack item = new ItemStack(material, amount, (short) shrt);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(string);
		item.setItemMeta(meta);
		return item;
	}
	
    @EventHandler
    public void onSignChange(SignChangeEvent e) {
            if (e.getLine(0).equalsIgnoreCase("[PrisonCoins]")) {
            if (e.getLine(1).equalsIgnoreCase("Fortune")) {
            if (e.getLine(2).equalsIgnoreCase("RightClick")) {
            if (e.getLine(3).equalsIgnoreCase("3")) {
                    e.setLine(0, "§6[PrisonCoins]");
                    e.setLine(1, "§8Fortune");
                    e.setLine(2, "§8(RightClick)");
                    e.setLine(3, "§83 Coins");
            }
    }
            }
        }
    }
   
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
    	Player p = e.getPlayer();
            if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
            if (e.getClickedBlock().getState() instanceof Sign) {
                    Sign s = (Sign) e.getClickedBlock().getState();
                    if("§8Fortune".equals(s.getLine(1))){
                        if (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
                            e.getPlayer().getItemInHand()
                                    .addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
                    		
                    	}
                    }
            }
    }
                    	public void updateEnchant(ItemStack pic,Enchantment en){
                    		ItemMeta picMeta=pic.getItemMeta();
                    		int Currentenchant =picMeta.getEnchantLevel(en);
                    		int NextLevel=Currentenchant+1;
                    		picMeta.addEnchant(en,NextLevel , true);
                    		}
                        
                    }
