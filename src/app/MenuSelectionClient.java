package app;


public class MenuSelectionClient extends Menu {

	static String titre = "Rechercher Client par...";
	static String[] options = { "1. Nom", "2. Id", "3. Numero de Compte", "4. Retour"};
			

	public static void afficher() {

		System.out.println("--------------");
		System.out.println(titre);
//		System.out.println(App.getCurrentAgence().toString());
		System.out.println("--------------");

		for (String options : options) {
			System.out.println(options);
		}
		System.out.println("--------------");
	}
}
