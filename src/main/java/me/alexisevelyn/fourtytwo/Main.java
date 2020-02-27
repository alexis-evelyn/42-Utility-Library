package me.alexisevelyn.fourtytwo;

import org.bukkit.Bukkit;
// Bukkit Imports
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

// Own Plugin Imports
import me.alexisevelyn.fourtytwo.commands.*;

// Commodore Imports
import me.lucko.commodore.Commodore;
import me.lucko.commodore.CommodoreProvider;

// Essentials Imports
import net.ess3.api.events.*;

// https://www.spigotmc.org/wiki/creating-external-libraries/

/** Main Class
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class Main extends JavaPlugin implements Listener {
	/** Plugin Messages for Bungeecord/Spigot Communication */
	PluginMessages pmessages = new PluginMessages(this);
	Nickname nick = new Nickname(this);
	
	/** Called When Enabling Plugin */
	@Override
    public void onEnable() {
		// Register Event Handlers
		getServer().getPluginManager().registerEvents(this, this);
		
		// Retrieve Commands For Registry (And Potential Completions Support)
		PluginCommand command42 = this.getCommand("42");
		PluginCommand commandHealth = this.getCommand("health");
		PluginCommand commandArmor = this.getCommand("customarmor");
		PluginCommand commandTestNick = this.getCommand("testnick");
		
		// Instantiate Commands' Classes
		FourtyTwo classFourtyTwo = new FourtyTwo(this);
		Health classHealth = new Health(this);
		Armor classArmor = new Armor(this);
		TestNick classTestNick = new TestNick(this, this.nick);
		
		// Register Commands
		try {
			command42.setExecutor(classFourtyTwo);
			commandHealth.setExecutor(classHealth);
			commandArmor.setExecutor(classArmor);
			commandTestNick.setExecutor(classTestNick);
		} catch(NullPointerException e) {
			getLogger().severe("The idiot of a developer, Alexis Evelyn, forgot to rename a command in plugin.yml!!! Some or all commands from this library will not work!!!");
			e.printStackTrace();
		}
		
		// Register Tab Completions
		try {
			command42.setTabCompleter(classFourtyTwo);
			commandHealth.setTabCompleter(classHealth);
			commandArmor.setTabCompleter(classArmor);
			commandTestNick.setTabCompleter(classTestNick);
		} catch(NullPointerException e) {
			getLogger().severe("The idiot of a developer, Alexis Evelyn, forgot to rename a command in plugin.yml!!! Some or all commands from this library will not work!!!");
			e.printStackTrace();
		}
		
		try {
			// If Brigadier is Support (1.13+), Then Register Command Completions
			if (CommodoreProvider.isSupported()) {
	            // Get Commodore Instance
	            Commodore commodore = CommodoreProvider.getCommodore(this);

	            // Register Command Completions (In Separate Classes To Prevent 1.12- Class Loading Errors)
	            FourtyTwo.registerCompletions(this, commodore, command42);
	            Health.registerCompletions(this, commodore, commandHealth);
	            Armor.registerCompletions(this, commodore, commandArmor);
	            TestNick.registerCompletions(this, commodore, commandTestNick);
	        } else {
	        	getLogger().warning("Brigadier is Unsupported!!! Tab Completions will not work!!! Please use Minecraft 1.13+ For Tab Completions!!!");
	        }
		} catch(me.lucko.commodore.BrigadierUnsupportedException e) {
			getLogger().severe("Failed to Start Commodore Due To Brigadier Being Unsupported!!!");
			e.printStackTrace();
		} catch(Exception e) {
			getLogger().severe("Failed to Start Commodore Due To Exception!!! If this plugin called the developer an idiot above this line, that's why!!!");
			e.printStackTrace();
		}
		
		if(pmessages.isBungee()) {
			// https://www.spigotmc.org/threads/sending-data-from-spigot-to-bungeecord.302447/
			// https://www.spigotmc.org/wiki/sending-a-custom-plugin-message-from-bungeecord/
			getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord"); // Register the outgoing channel, to Bungee
//			getServer().getMessenger().registerIncomingPluginChannel(this, "42:FourtyTwo", pmessages); // Register the incoming channel, from Bungee
		} else {
			getLogger().warning("Bungeecord Support Will Not Work!!!");
		}
		
		// Announce Successful Start
		getLogger().info("42 Utility Library has successfully started!!!");
	}

	/** Called When Disabling Plugin */
	@Override
    public void onDisable() {
		HandlerList.unregisterAll(); // Unregister All Handlers and Listeners
		getLogger().info("Thank you for using 42 Utility Library!!!");
	}
	
	// On Login Doesn't Process
//	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
//	public void onLogin(PlayerLoginEvent event) {
//		getLogger().info("Player '" + event.getPlayer().getName() + " ("
//				+ event.getPlayer().getUniqueId() + ")' Logged In!!!");
//		
//		nick.syncNickname(event.getPlayer());
//	}
	
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
	public void onNickChange(NickChangeEvent event) {
//		getLogger().info("Player Nickname Changed!!! Values: " + event.getValue());
//		getLogger().info("Affected!!! Values: " + event.getAffected().getName());
		
		nick.syncNickname(Bukkit.getPlayer(event.getAffected().getName()), event.getValue());
	}
}
