package me.alexisevelyn.fourtytwo.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/** Version Command From Library (Useful For Ensuring Plugin Loaded Properly)
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class FourtyTwo implements CommandExecutor {
	
	/** Checks For Specific Command and Executes It
	 * @param sender The sender's object (CommandSender)
	 * @param command The command to run
	 * @param label Alias of command run
	 * @param args Array of arguments for the command
	*/
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// Version
		this.version(sender);
		
		return true;
	}
	
	private void version(CommandSender sender) {
		if (sender instanceof Player) {
			sender.sendMessage(ChatColor.GOLD + "Hello Player!!!");
		} else {
			sender.sendMessage(ChatColor.GOLD + "Hello Console!!!");
		}
	}
}
