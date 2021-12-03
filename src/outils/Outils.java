package outils;

import java.util.Random;


public class Outils {
	
	public static int getRandomNumberInRange(int min, int max) {
		
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	static String lettersString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String numericsString = "0123456789";
		
	public static String genererNumericalId(int n) {
		String result = "";
		for (int i = 0; i < n ; i++) {
			result += numericsString.charAt(getRandomNumberInRange(0, numericsString.length()-1));
		}
		return result;
	}
	
	public static String genererIdClient() {
		String result = "";
		for (int i = 0; i < 2 ; i++) {
			result += lettersString.charAt(getRandomNumberInRange(0, numericsString.length()-1));
		}
		for (int i = 0; i < 6 ; i++) {
			result += numericsString.charAt(getRandomNumberInRange(0, numericsString.length()-1));
		}
		return result;
	}

	
}
