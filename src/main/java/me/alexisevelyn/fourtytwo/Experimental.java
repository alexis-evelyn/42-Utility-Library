package me.alexisevelyn.fourtytwo;

import org.bukkit.attribute.Attribute;
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
	 * @param player The player to modify
	*/
	public static void breakHealth(Player player) {        
        player.setAbsorptionAmount(Double.MAX_VALUE);
		
		//player.setFoodLevel(Integer.MAX_VALUE);
		//player.setSaturation(Float.MAX_VALUE);
    }
	
	/** Reset player to full, vanilla, health and hunger
	 * @param player The player to modify
	*/
	public static void resetHealth(Player player) {
        player.setAbsorptionAmount(0.0);
		
		//player.setFoodLevel(20);
		//player.setSaturation(20);
    }
	
	/** Maximize Custom Armor Base and Toughness
	 * @param player The player to modify
	*/
	public static void customArmor(Player player) {
		player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(20.0);
		player.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(30.0);
	}
}
