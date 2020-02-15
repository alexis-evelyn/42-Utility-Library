package me.alexisevelyn.fourtytwo;

import org.bukkit.plugin.java.JavaPlugin;

// https://www.spigotmc.org/wiki/creating-external-libraries/

public class Main extends JavaPlugin {
	// Event Listeners

	@Override
    public void onEnable() {
		// Register Commands
		this.getCommand("42").setExecutor(new Commands());

		// Announce Successful Start
		getLogger().info("42 Utility Library has successfully started!!!");
	}

	@Override
    public void onDisable() {
		getLogger().info("Thank you for using 42 Utility Library!!!");
	}
}
