package me.alexisevelyn.fourtytwo;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/** Game Breaking Functions
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class Experimental {

	/** Make the player's health bar disappear
	 * @param sender The sender's object (CommandSender)
	*/
	public static void breakHealth(CommandSender sender) {        
        ((Player) sender).setAbsorptionAmount(Double.MAX_VALUE);
		
		((Player) sender).setFoodLevel(Integer.MAX_VALUE);
		((Player) sender).setSaturation(Float.MAX_VALUE);
    }
	
	/** Reset player to full, vanilla, health and hunger
	 * @param sender The sender's object (CommandSender)
	*/
	public static void resetHealth(CommandSender sender) {
        ((Player) sender).setAbsorptionAmount(0.0);
		
		((Player) sender).setFoodLevel(20);
		((Player) sender).setSaturation(20);
    }
}
