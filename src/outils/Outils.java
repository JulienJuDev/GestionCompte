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
	static String lowerCaseLettersString = "abcdefghijklmnopqrstuvwxyz";
	static String numericsString = "0123456789";
	static String allString = lettersString + lowerCaseLettersString + numericsString;
		
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
			result += lettersString.charAt(getRandomNumberInRange(0, lettersString.length()-1));
		}
		for (int i = 0; i < 6 ; i++) {
			result += numericsString.charAt(getRandomNumberInRange(0, numericsString.length()-1));
		}
		return result;
	}
	public static String genererLoginClient() {
		String result = "";
		
		for (int i = 0; i < 10 ; i++) {
			result += numericsString.charAt(getRandomNumberInRange(0, numericsString.length()-1));
		}
		return result;
	}
	public static String genererLoginConseiller() {
		String result = "CO";
		
		for (int i = 0; i < 4 ; i++) {
			result += numericsString.charAt(getRandomNumberInRange(0, numericsString.length()-1));
		}
		return result;
	}
	public static String genererLoginAdmin() {
		String result = "ADM";
		
		
		for (int i = 0; i < 2 ; i++) {
			result += numericsString.charAt(getRandomNumberInRange(0, numericsString.length()-1));
		}
		return result;
	}
	public static String genererMotDePasse(int length) {
		String result = "";
		
		for (int i = 0; i < length ; i++) {
			result += allString.charAt(getRandomNumberInRange(0, allString.length()-1));
		}
		return result;
	}

	
}
