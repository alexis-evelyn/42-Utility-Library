package me.alexisevelyn.fourtytwo.debug;

/** Verbosity Enum Used by 42 Based Plugins
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public enum Verbosity {
	notfound (-2),
	silent (-1),
	fatal (0),
	error (1),
	warning (2),
	warn (2),
	info (3),
	debug (4),
	verbose (5),
	superverbose (6);
	
	/**
	 * Integer Value Based on Enum
	 */
	private int value;

	/** Constructor For Enum
	 * @param value Integer in Relation to Enum
	*/
	Verbosity(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	/** Retrieve Value of Plugin's Current Verbosity
	 * @return Current Plugin's Verbosity
	*/
    public int getValue() {
        return this.value;
    }
    
    /** Retrieve Verbosity From Enum Based on Integer
	 * @param value Integer Related to Enum
	 * @return Verbosity From Enum or "notfound"
	*/
    public static Verbosity getVerbosityName(int value) {
	  for(Verbosity verbosity: Verbosity.values()) {
	    if(verbosity.value == value) {
	      return verbosity;
	    }
	  }
	  
	  return notfound; // not found
	}

}
