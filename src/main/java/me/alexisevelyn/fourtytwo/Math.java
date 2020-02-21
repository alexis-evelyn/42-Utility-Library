package me.alexisevelyn.fourtytwo;

import java.util.Random;

public class Math {
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
