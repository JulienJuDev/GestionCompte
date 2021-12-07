package app;

public class MenuConseiller{

	static String titre = "Menu Conseiller";
	
	static String[] optionsConseiller1 = { "1. Selectionner un Client", "2. Créer un client", "0. Se déconnecter" };
	static String[] optionsConseiller2 = { "1. Changer de Client", "2. Créer un client", "3. Afficher la liste des clients", "4. Ouvrir un compte",
			"5. Modifier les informations du client", "6.Opérations sur un compte du client", "0. Se déconnecter" };
	
	public static void afficher(boolean isClientSelected) {
		System.out.println("--------------");
		System.out.println("Menu Conseiller");
		
		
		if(!isClientSelected) {
			for (String string : optionsConseiller1) {
				System.out.println(string);
			}
		}
		else {
			for (String string : optionsConseiller2) {
				System.out.println(string);
			}
		}
		
		System.out.println("--------------");
	}
}
