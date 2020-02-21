package me.alexisevelyn.fourtytwo.debug;

/** Verbosity Utility Class
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class Debug {
	/** Initialized Default Verbosity
	*/
	private Verbosity verbosity = Verbosity.silent;

	// Getters and Setters
	
	/** Check If Verbosity Is Low Enough To Warrant If Something Should Be Logged
	 * @param value Requested Verbosity Level
	 * @return true if can output log, false if cannot output log
	*/
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

	/** Set Current Plugin's Verbosity
	 * @param value Current Verbosity Level
	*/
	public void setVerbosity(Verbosity value) {
		// Useful If Already Know Verbosity Value
		this.verbosity = value;
	}
	
	/** Set Current Plugin's Verbosity From Integer
	 * @param value Current Verbosity Level As Int
	*/
	public void setVerbosity(int value) {
		// Useful For Configs
		this.verbosity = Verbosity.getVerbosityName(value);
	}
	
	/** Get Current Plugin's Verbosity Level
	 * @return Current Verbosity Level
	*/
	public Verbosity getVerbosity() {
		return this.verbosity;
	}
}
