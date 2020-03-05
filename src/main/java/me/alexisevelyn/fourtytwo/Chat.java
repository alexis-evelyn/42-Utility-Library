package me.alexisevelyn.fourtytwo;

import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

/** Chat Related Functions
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class Chat {
	/** Colorizes and Sends A Message to the Specified Sender (Player, Console, or Command Block)
	 * @param sender The sender's object (CommandSender)
	 * @param message The message formatted with Mojang Color Codes, but with &amp; instead of &#xA7;
	*/
	public static void tell(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }

	/** Colorizes A Messag
	 * @param message The message formatted with Mojang Color Codes, but with &amp; instead of &#xA7;
	 * @return Colorized Message
	*/
    public static String colorize(final String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
