package me.alexisevelyn.fourtytwo.commands;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

import com.mojang.brigadier.tree.LiteralCommandNode;

import me.alexisevelyn.fourtytwo.Experimental;
import me.alexisevelyn.fourtytwo.Main;
import me.lucko.commodore.Commodore;
import me.lucko.commodore.file.CommodoreFileFormat;

/** Experimental Armor Modification Command
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class Armor implements CommandExecutor {
	
	/** Checks For Specific Command and Executes It
	 * @param sender The sender's object (CommandSender)
	 * @param command The command to run
	 * @param label Alias of command run
	 * @param args Array of arguments for the command
	*/
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// Modify Armor
		this.setArmor(sender);
		
		return true;
	}
	
	private void setArmor(CommandSender sender) {
		if (sender instanceof Player) {
			sender.sendMessage(ChatColor.GOLD + "Setting Custom Armor Value!!!");
			
			Experimental.customArmor((Player) sender);
		} else {
			sender.sendMessage(ChatColor.RED + "Player Only Command!!!");
		}
	}
	
	public static void registerCompletions(Main main, Commodore commodore, PluginCommand command) {
		LiteralCommandNode<?> parsedCompletions;
		
		try {
			parsedCompletions = CommodoreFileFormat.parse(main.getResource("customarmor.commodore"));
			commodore.register(command, parsedCompletions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			main.getLogger().severe("Failed To Register Completions for Command CustomArmor!!!");
			e.printStackTrace();
		}
	}
}
