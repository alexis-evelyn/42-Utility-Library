package me.alexisevelyn.fourtytwo;

import java.util.Random;

/** Math Utility Class
 * @author Alexis Evelyn
 * @author alexisevelyn.me
 * @version 0.0.1-Snapshot
 * @since 0.0.1-Snapshot
*/
public class Math {
	/** Generate a Random Number in a Range (Inclusive)
	 * @param one One end of the number range
	 * @param two The other end of the number range
	 * @return Random Integer From Within Range
	*/
	public static int getRandomNumberInRange(int one, int two) {
		Random r = new Random();
		
		if (one >= two) {
			// one is max
			// two is min
			
			return r.nextInt((one - two) + 1) + two;
		}
		
		// one is min
		// two is max

		return r.nextInt((two - one) + 1) + one;
	}
}
