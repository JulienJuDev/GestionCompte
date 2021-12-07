package app;

public class MenuCompte extends Menu {

	static String titre = "Menu Compte";
	static String[] options = { "1. Imprimer un relevé d'un compte", "2. Déposer de l'argent", "3. Retirer de l'argent", "4. Faire un Virement", "5. Consulter les opérations", "\n", "0. Retour Selection de Compte" };

	public static void afficher() {

		System.out.println("--------------");

		for (String options : options) {
			System.out.println(options);
		}
		System.out.println("--------------");
	}
}
