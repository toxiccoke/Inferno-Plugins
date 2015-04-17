package me.toxiccoke.mines;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;

public class Main extends JavaPlugin implements Listener{
	
    private Selection s;
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);	
	}
	
    public WorldEditPlugin getWorldEdit() {
        Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
        if (p instanceof WorldEditPlugin) return (WorldEditPlugin) p;
        else return null;
}
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "The console cannot set up Welcome.");
                return true;
        }
       
        Player p = (Player) sender;
       
    if (cmd.getName().equalsIgnoreCase("setmine")) {
        s = getWorldEdit().getSelection(p);
        if (s == null) {
                sender.sendMessage(ChatColor.RED + "Make a selection!");
                return true;
        }
        sender.sendMessage(ChatColor.GREEN + "Set area!");
}
return true;
}
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
            if (s == null) return;
            if (s.contains(e.getTo()) && !s.contains(e.getFrom())) {
                    e.getPlayer().sendMessage(ChatColor.GREEN + "Welcome");
            }
    }
}
