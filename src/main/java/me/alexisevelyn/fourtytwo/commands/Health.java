package me.alexisevelyn.fourtytwo.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

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
public class Health implements CommandExecutor, TabCompleter {
	Plugin plugin;
	
	public Health(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	/** Checks For Specific Command and Executes It
	 * @param sender The sender's object (CommandSender)
	 * @param command The command to run
	 * @param label Alias of command run
	 * @param args Array of arguments for the command
	*/
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		// TODO: Convert to Switch Case and Offload SubArg Parsing To Separate Functions For Code Cleanliness
		if (args.length == 1 || args.length == 2) {
			if (args[0].equalsIgnoreCase("break")) {
				if (args.length == 1) {
					// Break Health
					this.breakHealth(sender);
				} else {
					Player player = Bukkit.getPlayer(args[1]);
					
					if (player == null) {
						sender.sendMessage(ChatColor.RED + "Player, " + args[1] + ", not found!!!");
					} else {
						this.breakHealth(player);
					}
				}
			} else if (args[0].equalsIgnoreCase("reset")) {
				if (args.length == 1) {
					// Reset Health
					this.resetHealth(sender);
				} else {
					Player player = Bukkit.getPlayer(args[1]);
					
					if (player == null) {
						sender.sendMessage(ChatColor.RED + "Player, " + args[1] + ", not found!!!");
					} else {
						this.resetHealth(player);
					}
				}
			} else if (args[0].equalsIgnoreCase("set")) {
				sender.sendMessage(ChatColor.RED + "Set is not implemented yet!!!");
			} else {
				sender.sendMessage(ChatColor.RED + "Use <break/reset> [username]");
			}
		} else {
			sender.sendMessage(ChatColor.RED + "Use <break/reset> [username]");
		}
		
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

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if(args.length == 2) {
			ArrayList<String> usernames = new ArrayList<String>();
			Player tabber;
			
			for (Player player : plugin.getServer().getOnlinePlayers()) {
				if (!args[1].equals("") && player.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
					if(sender instanceof Player) {
						tabber = (Player) sender;
						if(tabber.canSee(player)) {
							usernames.add(player.getName());
						}
					} else {
						usernames.add(player.getName());
					}
				} else {
					if(sender instanceof Player) {
						tabber = (Player) sender;
						if(tabber.canSee(player)) {
							usernames.add(player.getName());
						}
					} else {
						usernames.add(player.getName());
					}
				}
			}
			
			Collections.sort(usernames);
			
			tabber = null;
			return usernames;
		}
		
		List<String> empty = Arrays.asList();
		return empty;
	}
}
