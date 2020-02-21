package me.alexisevelyn.fourtytwo.debug;

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
	
	private int value;

	Verbosity(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

    public int getValue(){
        return this.value;
    }
    
    public static Verbosity getVerbosityName(int value) {
	  for(Verbosity verbosity: Verbosity.values()) {
	    if(verbosity.value == value) {
	      return verbosity;
	    }
	  }
	  
	  return notfound; // not found
	}

}
