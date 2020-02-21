package me.alexisevelyn.fourtytwo;

import org.bukkit.plugin.java.JavaPlugin;

// https://www.spigotmc.org/wiki/creating-external-libraries/

/** Main Class
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class Main extends JavaPlugin {
	// Event Listeners

	/** Called When Enabling Plugin
	*/
	@Override
    public void onEnable() {
		// Register Commands
		this.getCommand("42").setExecutor(new Commands());

		// Announce Successful Start
		getLogger().info("42 Utility Library has successfully started!!!");
	}

	/** Called When Disabling
	*/
	@Override
    public void onDisable() {
		getLogger().info("Thank you for using 42 Utility Library!!!");
	}
}
