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

import com.earth2me.essentials.Essentials;
import com.mojang.brigadier.tree.LiteralCommandNode;

import me.alexisevelyn.fourtytwo.Experimental;
import me.alexisevelyn.fourtytwo.Main;
import me.alexisevelyn.fourtytwo.Nickname;
import me.lucko.commodore.Commodore;
import me.lucko.commodore.file.CommodoreFileFormat;

/** Version Command From Library (Useful For Ensuring Plugin Loaded Properly)
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class TestNick implements CommandExecutor, TabCompleter {
	Main plugin;
	Nickname nickname;
	
	public TestNick(Main main, Nickname nick) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
		this.nickname = nick;
	}

	/** Checks For Specific Command and Executes It
	 * @param sender The sender's object (CommandSender)
	 * @param command The command to run
	 * @param label Alias of command run
	 * @param args Array of arguments for the command
	*/
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		this.nickname.syncNickname((Player) sender);
		
		return true;
	}

	
	public static void registerCompletions(Main main, Commodore commodore, PluginCommand command) {
		LiteralCommandNode<?> parsedCompletions;
		
		try {
			parsedCompletions = CommodoreFileFormat.parse(main.getResource("testnick.commodore"));
			commodore.register(command, parsedCompletions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			main.getLogger().severe("Failed To Register Completions for Command TestNick!!!");
			e.printStackTrace();
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> empty = Arrays.asList("");
		return empty;
	}
}
