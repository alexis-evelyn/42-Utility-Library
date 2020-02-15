package me.alexisevelyn.fourtytwo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
//import org.bukkit.plugin.Plugin;
import org.bukkit.ChatColor;

// https://papermc.io/javadocs/paper/1.15/org/bukkit/Chunk.html
// https://papermc.io/javadocs/paper/1.15/org/bukkit/ChunkSnapshot.html

public class Commands implements CommandExecutor {
	//private Plugin plugin = Main.getPlugin(Main.class);
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("42")) {
			if (sender instanceof Player) {
				sender.sendMessage(ChatColor.GOLD + "Hello Player!!!");
			} else {
				sender.sendMessage(ChatColor.GOLD + "Hello Console!!!");
			}
			
			return true;
		}
		
		return false;
	}
}
