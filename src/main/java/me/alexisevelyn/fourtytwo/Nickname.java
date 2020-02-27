package me.alexisevelyn.fourtytwo;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.earth2me.essentials.Essentials;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Nickname {
	Plugin plugin;
	Essentials ess;
	
	public Nickname(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
		this.ess = (Essentials) this.plugin.getServer().getPluginManager().getPlugin("Essentials");
	}
	
	public void syncNickname(Player player) {
		syncNickname(player, ess.getUser(player).getNickname());
	}
	
	public void syncNickname(Player player, String nickname) {
		// "MaSuiteChat", "Nick", String PlayerUUID, String PlayerNick
		
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("MaSuiteChat");
        out.writeUTF("Nick"); // Write the sub-channel
        out.writeUTF(player.getUniqueId().toString()); // Write the player's uuid - player.getUniqueId().toString()
        out.writeUTF(nickname); // Write the updated nickname
        
        this.plugin.getServer().sendPluginMessage(this.plugin, "BungeeCord", out.toByteArray()); // Send to Bungee
	}
}
