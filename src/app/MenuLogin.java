package app;

public class MenuLogin extends Menu {

	static String titre = "Ecran de connexion";
	static String[] options = { "1. Entrez votre login", "2. Créer un nouvel utilisateur" , "3. Changer d'agence"};

	public static void afficher() {

		System.out.println("--------------");
		System.out.println(App.getCurrentAgence().toString());
		System.out.println(titre);
		System.out.println("--------------");

		for (String options : options) {
			System.out.println(options);
		}
		System.out.println("--------------");
	}


}
