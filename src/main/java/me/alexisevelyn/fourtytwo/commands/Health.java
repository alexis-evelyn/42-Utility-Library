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

/** Experimental Health Modification Command
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class Health implements CommandExecutor {
	
	/** Checks For Specific Command and Executes It
	 * @param sender The sender's object (CommandSender)
	 * @param command The command to run
	 * @param label Alias of command run
	 * @param args Array of arguments for the command
	*/
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		// Break Health
		this.breakHealth(sender);
		
		// Reset Health
		this.resetHealth(sender);
		
		return true;
	}
	
	private void breakHealth(CommandSender sender) {
		if (sender instanceof Player) {
			sender.sendMessage(ChatColor.GOLD + "Breaking Health!!!");
			Experimental.breakHealth((Player) sender);
		} else {
			sender.sendMessage(ChatColor.RED + "Player Only Command!!!");
		}
	}
	
	private void resetHealth(CommandSender sender) {
		if (sender instanceof Player) {
			sender.sendMessage(ChatColor.GOLD + "Resetting Health!!!");
			Experimental.resetHealth((Player) sender);
		} else {
			sender.sendMessage(ChatColor.RED + "Player Only Command!!!");
		}
	}
	
	public static void registerCompletions(Main main, Commodore commodore, PluginCommand command) {
		LiteralCommandNode<?> parsedCompletions;
		
		try {
			parsedCompletions = CommodoreFileFormat.parse(main.getResource("health.commodore"));
			commodore.register(command, parsedCompletions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			main.getLogger().severe("Failed To Register Completions for Command Health!!!");
			e.printStackTrace();
		}
	}
}
