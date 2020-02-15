package me.alexisevelyn.fourtytwo;

import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

public class Chat {
	public static void tell(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }

    public static String colorize(final String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
