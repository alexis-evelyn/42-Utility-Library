package me.alexisevelyn.fourtytwo;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import me.alexisevelyn.fourtytwo.commands.*;
import me.lucko.commodore.Commodore;
import me.lucko.commodore.CommodoreProvider;

// https://www.spigotmc.org/wiki/creating-external-libraries/

/** Main Class
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class Main extends JavaPlugin {
	/** Called When Enabling Plugin */
	@Override
    public void onEnable() {
		// Retrieve Commands For Registry (And Potential Completions Support)
		PluginCommand command42 = this.getCommand("42");
		PluginCommand commandHealth = this.getCommand("health");
		PluginCommand commandArmor = this.getCommand("customarmor");
		
		// Register Commands
		try {
			command42.setExecutor(new FourtyTwo());
			commandHealth.setExecutor(new Health());
			commandArmor.setExecutor(new Armor());
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

		// Announce Successful Start
		getLogger().info("42 Utility Library has successfully started!!!");
	}

	/** Called When Disabling Plugin */
	@Override
    public void onDisable() {
		getLogger().info("Thank you for using 42 Utility Library!!!");
	}
}
