package app;

public class MenuChoixAgence extends Menu {

	static String titre = "Selection";
	static String[] options = { "Selectionnez une agence"};

	public static void afficher() {

		System.out.println("--------------");
		System.out.println(titre);
		System.out.println("--------------");

		for (String options : options) {
			System.out.println(options);
		}
		System.out.println("--------------");
	}


}
