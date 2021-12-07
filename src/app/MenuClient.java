package app;

public class MenuClient extends Menu {

	static String titre = "Menu Client";
	static String[] options = { "1. Consulter les informations", "2. Consulter un compte", "3. Virement",
			"4. Imprimer un relevé d'un compte", "5. Déposer de l'argent", "6. Retirer de l'argent" };

	public static void afficher() {

		System.out.println("--------------");
		System.out.println(titre);
		System.out.println(App.getCurrentAgence().toString());
		System.out.println("--------------");

		for (String options : options) {
			System.out.println(options);
		}
		System.out.println("--------------");
	}
}
