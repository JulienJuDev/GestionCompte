package app;

import utilisateur.Client;

public class MenuSelectionCompte extends Menu {

	static String titre = "Sélectionner un Compte";

	public static void afficher(Client client) {

		System.out.println("--------------");
		System.out.println(titre);
		System.out.println("--------------");

		App.afficherComptesClient(client);
		
		System.out.println("--------------");
	}
}
