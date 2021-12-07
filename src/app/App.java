package app;

import java.util.Scanner;

import client.*;
import metier.*;
import outils.*;

public class App {

	private static Agence currentAgence;
	
	public static Agence creerFakeAgence() {

		return new Agence();
	}

	public static void creerFakeClient() {

		currentAgence.getListeClient().add(new Client());
	}

	public static Agence creerAgence(Scanner scanner) {

		System.out.println("Nom");
		String nom = scanner.next();
		System.out.println("numero de voie");
		String numero = scanner.next();
		System.out.println("nom de la voie");
		String voie = scanner.next();
		System.out.println("code postal");
		String codePostal = scanner.next();
		System.out.println("Ville");
		String ville= scanner.next();
		Adresse adresse = new Adresse(numero, voie, codePostal, ville);
		
		return new Agence(nom, adresse);
	}

	public static void creerClient(Scanner scanner) {

		System.out.println("Nom");
		String nom = scanner.next();
		System.out.println("Prenom");
		String prenom = scanner.next();
		System.out.println("Date de Naissance");
		System.out.println("Jour");
		String jour = scanner.next();
		System.out.println("Mois");
		String mois = scanner.next();
		System.out.println("Année");
		String annee = scanner.next();
		Date dateNaissance = new Date(jour, mois, annee);
		System.out.println("numero de voie");
		String numero = scanner.next();
		System.out.println("nom de la voie");
		String voie = scanner.next();
		System.out.println("code postal");
		String codePostal = scanner.next();
		System.out.println("Ville");
		String ville= scanner.next();
		Adresse adresse = new Adresse(numero, voie, codePostal, ville);
		System.out.println("email");
		String email = scanner.next();

		currentAgence.getListeClient().add(new Client(nom, prenom, dateNaissance, adresse, email, true));
	}

	public static void creerCompte(Client client, Scanner scanner) {

		if (client.getNbDeComptes() < 3) {

			System.out.println("Quel type de compte ?");
			System.out.println("1 : Compte courant");
			System.out.println("2 : Livret A");
			System.out.println("3 : Plan Epargne Logement");
			

			switch (scanner.nextInt()) {
			case 1:
				System.out.println("Combien voulez vous déposer");
				client.ajouterCompte(client.getNbDeComptes(), new CompteCourant(currentAgence, client, Float.parseFloat(scanner.next()), false));
				currentAgence.getListeComptes().add(client.getListeComptes()[client.getNbDeComptes()]);
				client.setNbDeComptes(client.getNbDeComptes() + 1);

				System.out.println("Vous avez ouvert le compte courant : "
						+ client.getListeComptes()[client.getNbDeComptes() - 1].toString());

				break;
			case 2:
				System.out.println("Combien voulez vous déposer");
				client.ajouterCompte(client.getNbDeComptes(), new CompteLivretA(currentAgence, client, Float.parseFloat(scanner.next()), false));
				currentAgence.getListeComptes().add(client.getListeComptes()[client.getNbDeComptes()]);
				client.setNbDeComptes(client.getNbDeComptes() + 1);
				System.out.println("Vous avez ouvert le Livret A : "
						+ client.getListeComptes()[client.getNbDeComptes() - 1].toString());
				break;
			case 3:
				System.out.println("Combien voulez vous déposer");
				client.ajouterCompte(client.getNbDeComptes(), new ComptePEL(currentAgence, client, Float.parseFloat(scanner.next()), false));
				currentAgence.getListeComptes().add(new ComptePEL(currentAgence, client, 0f, false));
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

	public static FicheClient creerFicheClient(String clientId) {
		FicheClient fiche;
		fiche = new FicheClient(rechercherClient(clientId));
		return fiche;
	}

	public static void afficherListeClient() {

		for (Client client : currentAgence.getListeClient()) {
			System.out.println(client.toString());
			System.out.println();

		}
	}

	public static void afficherComptesAgence() {

		for (CompteBancaire compte : currentAgence.getListeComptes()) {
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

	public static CompteBancaire rechercherCompte(String recherche) {
		System.out.println("Rentrez un identifiant client");

		for (CompteBancaire compte : currentAgence.getListeComptes()) {
			if (compte.getId().equals(recherche)) {
				return compte;
			}
		}
		System.out.println("Aucun compte ne correspond à cet identifiant");
		return null;

	}

	public static Client rechercherClient(String recherche) {

		for (Client client : currentAgence.getListeClient()) {

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
			for (CompteBancaire compte : currentAgence.getListeComptes()) {
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

	public static Agence getCurrentAgence() {
		return currentAgence;
	}

	public static void setCurrentAgence(Agence agence) {
		currentAgence = agence;
	}

}
