package app;

import java.util.Scanner;

import client.*;
import metier.*;
import outils.*;

public class App {

	public static Agence creerFakeAgence() {

		return new Agence();
	}

	public static void creerFakeClient(Agence agence) {

		agence.getListeClient().add(new Client());
	}

	public static Agence creerAgence(Scanner scanner) {

		System.out.println("Nom");
		String nom = scanner.next();
		System.out.println("Adresse");
		Adresse adresse = new Adresse(scanner.next(), scanner.next(), scanner.next(), scanner.next());
		System.out.println("Numéro d'identification");
		String id = scanner.next();

		return new Agence(nom, adresse);
	}

	public static void creerClient(Agence agence, Scanner scanner) {

		System.out.println("Nom");
		String nom = scanner.next();
		System.out.println("Nom");
		String prenom = scanner.next();
		System.out.println("Date de Naissance");
		Date dateNaissance = new Date(scanner.next(), scanner.next(), scanner.next());
		System.out.println("Adresse");
		Adresse adresse = new Adresse(scanner.next(), scanner.next(), scanner.next(), scanner.next());
		System.out.println("email");
		String email = scanner.next();

		agence.getListeClient().add(new Client(nom, prenom, dateNaissance, adresse, email, true));
	}

	public static void creerCompte(Agence agence, Client client, Scanner scanner) {

		if (client.getNbDeComptes() < 3) {

			System.out.println("Quel type de compte ?");
			System.out.println("1 : Compte courant");
			System.out.println("2 : Livret A");
			System.out.println("3 : Plan Epargne Logement");

			switch (scanner.nextInt()) {
			case 1:

				client.ajouterCompte(client.getNbDeComptes(), new CompteCourant(agence, client, 0f, false));
				agence.getListeComptes().add(client.getListeComptes()[client.getNbDeComptes()]);
				client.setNbDeComptes(client.getNbDeComptes() + 1);

				System.out.println("Vous avez ouvert le compte courant : "
						+ client.getListeComptes()[client.getNbDeComptes() - 1].toString());

				break;
			case 2:

				client.ajouterCompte(client.getNbDeComptes(), new CompteLivretA(agence, client, 0f, false));
				agence.getListeComptes().add(client.getListeComptes()[client.getNbDeComptes()]);
				client.setNbDeComptes(client.getNbDeComptes() + 1);
				System.out.println("Vous avez ouvert le Livret A : "
						+ client.getListeComptes()[client.getNbDeComptes() - 1].toString());
				break;
			case 3:

				client.ajouterCompte(client.getNbDeComptes(), new ComptePEL(agence, client, 0f, false));
				agence.getListeComptes().add(new ComptePEL(agence, client, 0f, false));
				client.setNbDeComptes(client.getNbDeComptes() + 1);
				System.out.println("Vous avez ouvert le PEL : "
						+ client.getListeComptes()[client.getNbDeComptes() - 1].toString());
				break;
			default:

				System.out.println("Ca n'est pas un choix valide");
			}

		}
		else {
			System.out.println("Impossible, vous avez déja ouvert 3 comptes dans cette agence.");
		}
	}

	public static FicheClient creerFicheClient(Agence agence, String clientId) {
		FicheClient fiche;
		fiche = new FicheClient(rechercherClient(agence, clientId));
		return fiche;
	}

	public static void afficherListeClient(Agence agence) {

		for (Client client : agence.getListeClient()) {
			System.out.println(client.toString());
			System.out.println();

		}
	}

	public static void afficherComptesAgence(Agence agence) {

		for (CompteBancaire compte : agence.getListeComptes()) {
			System.out.println(compte.toString());
		}
	}

	public static void afficherComptesClient(Client client) {

		for (CompteBancaire compte : client.getListeComptes()) {
			if (compte != null) {
				System.out.println(compte.toString());
			}
		}
	}

	public static CompteBancaire rechercherCompte(Agence agence, String recherche) {

		for (CompteBancaire compte : agence.getListeComptes()) {
			if (compte.getId().equals(recherche)) {
				System.out.println("Compte Trouvé : " + compte.toString());
				return compte;
			}
		}
		System.out.println("Aucun compte ne correspond à cet identifiant");
		return null;

	}

	public static Client rechercherClient(Agence agence, String recherche) {

		for (Client client : agence.getListeClient()) {

			/// Recherche par Nom
			if (client.getNom().equals(recherche)) {
				System.out.println("Client Trouvé : " + client.toString());
				return client;
			}
			/// Recherche par Id
			if (client.getId().equals(recherche)) {
				System.out.println("Client Trouvé : " + client.toString());
				return client;
			}

			/// Recherche par #Compte
			for (CompteBancaire compte : agence.getListeComptes()) {
				if (compte.getId().equals(recherche)) {
					System.out.println("Client Trouvé : " + compte.getClient().toString());
					return compte.getClient();
				}
			}
		}
		System.out.println("La recherche n'a rien donné");
		return null;

	}

	public void desactiverCompte(CompteBancaire compte) {
		compte.setEstActive(false);
	}

	public void activerCompte(CompteBancaire compte) {
		compte.setEstActive(true);
	}

	public void desactiverClient(Client client) {
		client.setEstActif(false);
	}

	public void activerClient(Client client) {
		client.setEstActif(true);
	}

}
