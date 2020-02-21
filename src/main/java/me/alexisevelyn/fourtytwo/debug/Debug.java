package me.alexisevelyn.fourtytwo.debug;

import net.md_5.bungee.api.ChatColor;

public class Debug {
	private Verbosity verbosity = Verbosity.silent;

	// Getters and Setters
	
	public boolean isVerboseEnough(Verbosity value) {
		// TODO: Have functions called this with a requested verbosity and 
		// return true if current verbosity setting is that value or higher
		
//		System.out.println(ChatColor.GOLD + "[VERBOSITY] Requested Value: " + value.getValue()
//		+ " Config Value: " + this.verbosity.getValue());
				
		if(this.verbosity.getValue() >= value.getValue()) {
			return true;
		}
		
		return false;
	}

	public void setVerbosity(Verbosity value) {
		// Useful If Already Know Verbosity Value
		this.verbosity = value;
	}
	
	public void setVerbosity(int value) {
		// Useful For Configs
		this.verbosity = Verbosity.getVerbosityName(value);
	}
	
	public Verbosity getVerbosity() {
		return this.verbosity;
	}
}
