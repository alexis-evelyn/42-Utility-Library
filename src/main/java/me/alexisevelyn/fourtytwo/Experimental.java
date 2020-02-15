package me.alexisevelyn.fourtytwo;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Experimental {

	public static void breakHealth(CommandSender sender) {        
        ((Player) sender).setAbsorptionAmount(Double.MAX_VALUE);
		
		((Player) sender).setFoodLevel(Integer.MAX_VALUE);
		((Player) sender).setSaturation(Float.MAX_VALUE);
    }
	
	public static void resetHealth(CommandSender sender) {
        ((Player) sender).setAbsorptionAmount(0.0);
		
		((Player) sender).setFoodLevel(20);
		((Player) sender).setSaturation(20);
    }
}
