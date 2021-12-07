package app;

public class MenuAdmin extends MenuConseiller {

static String titre = "Menu Conseiller";
	
	static String[] optionsAdmin = { "1. Créer une Agence", "2. Désactiver un compte", "3. Désactiver un client"};
	
	public static void afficher() {

		for (String options : options) {
			System.out.println(options);
		}
		System.out.println("--------------");
		
		for (String options : optionsConseiller) {
			System.out.println(options);
		}
		System.out.println("--------------");
		
		for (String options : optionsAdmin) {
			System.out.println(options);
		}
		System.out.println("--------------");
	}
}
