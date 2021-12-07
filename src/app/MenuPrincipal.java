package app;

public class MenuPrincipal extends Menu {

	static String titre = "Menu Principal";
	static String[] options = { "1. Créer Agence", "2. Créer Client", "3. Créer Compte Bancaire",
			"4. Rechercher un compte", "5. Rechercher un client", "6. Afficher la liste des clients",
			"7. Imprimer les informations client", "8. Se déconnecter" };

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
