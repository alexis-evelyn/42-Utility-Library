package me.alexisevelyn.fourtytwo.commands;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.mojang.brigadier.tree.LiteralCommandNode;

import me.alexisevelyn.fourtytwo.Main;
import me.lucko.commodore.Commodore;
import me.lucko.commodore.file.CommodoreFileFormat;

/** Version Command From Library (Useful For Ensuring Plugin Loaded Properly)
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class FourtyTwo implements CommandExecutor, TabCompleter {
	
	public FourtyTwo(Main main) {
		// TODO Auto-generated constructor stub
	}

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
	
	public static void registerCompletions(Main main, Commodore commodore, PluginCommand command) {
		LiteralCommandNode<?> parsedCompletions;
		
		try {
			parsedCompletions = CommodoreFileFormat.parse(main.getResource("42.commodore"));
			commodore.register(command, parsedCompletions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			main.getLogger().severe("Failed To Register Completions for Command 42!!!");
			e.printStackTrace();
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> empty = Arrays.asList("");
		return empty;
	}
}
