package me.alexisevelyn.fourtytwo;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

/** Currently Unused - Maybe Used in the Future For Bungeecord Integration */
public class PluginMessages implements PluginMessageListener {
	Main plugin;
	
	PluginMessages(Main main) {
		this.plugin = main;
	}

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		// TODO Auto-generated method stub
		// Plugin Messages Received Will Show Up Here First
		
		this.plugin.getLogger().info("Currently Received a Bungeecord Message on Channel: '" + channel
				+ "' From Player: '" + player.getName() + " (" + player.getUniqueId() + ")"
				+ "' With Message: '" + message.toString() + "'");
		
		this.plugin.getLogger().info("I don't know why since this hasn't been implemented yet, but we received a message anyway!!!");
	}
	
	public boolean isBungee() {
        // we check if the server is Spigot/Paper (because of the spigot.yml file)
        if (!this.plugin.getServer().getVersion().contains("Paper")) {
//        	this.plugin.getLogger().warning("You probably run CraftBukkit... Please update to least to Paper for this to work...");
            return false;
        } else if (this.plugin.getServer().spigot().getConfig().getConfigurationSection("settings").getBoolean("settings.bungeecord")) {
//        	this.plugin.getLogger().warning("This server is not connected to BungeeCord.");
            return false;
        }
        
        return true;
    }

}
