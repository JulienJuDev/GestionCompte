package app;

public class MenuConseiller extends MenuClient {

	static String titre = "Menu Conseiller";
	
	static String[] optionsConseiller = { "1. Ouvrir un compte", "2. Créer un client", "3. Changer la domiciliation",
			"4. Modifier les informations" };
	
	public static void afficher() {

		for (String options : options) {
			System.out.println(options);
		}
		System.out.println("--------------");
		
		for (String options : optionsConseiller) {
			System.out.println(options);
		}
		System.out.println("--------------");
	}
}
