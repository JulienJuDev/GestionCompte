package app;

public class MenuClient extends Menu {

	static String titre = "Menu Client";
	static String[] options = { "1. Consulter vos informations", "2. Sélectionner un compte", "\n", "0. Se déconnecter" };

	
	public static void afficher() {

		System.out.println("--------------");
		System.out.println(titre);
		System.out.println(App.getCurrentAgence().getNom());
		System.out.println(App.getCurrentAgence().getId());
		System.out.println("--------------");

		for (String options : options) {
			System.out.println(options);
		}
		System.out.println("--------------");
	}
}
