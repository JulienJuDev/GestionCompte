package app;

import java.util.Scanner;

import client.*;
import metier.*;
import outils.*;

public class App {

	public static Agence creerAgence(Scanner scanner) {

		System.out.println("Nom");
		String nom = scanner.next();
		System.out.println("Adresse");
		Adresse adresse = new Adresse(scanner.next(), scanner.next(), scanner.next(), scanner.next());
		System.out.println("Numéro d'identification");
		String id = scanner.next();

		return new Agence(id, nom, adresse);
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

		System.out.println("Quel type de compte ?");
		System.out.println("1 : Compte courant");
		System.out.println("2 : Livret A");
		System.out.println("3 : Plan Epargne Logement");

		switch (scanner.nextInt()) {
		case 1:

			agence.getListeComptes().add(new CompteCourant(agence, client, 0f, false));

			System.out.println("Vous avez déja un compte courant.");
			break;
		case 2:

			agence.getListeComptes().add(new CompteLivretA(agence, client, 0f, false));

			System.out.println("Vous avez déja un Livret A.");
			break;
		case 3:

			agence.getListeComptes().add(new ComptePEL(agence, client, 0f, false));

			System.out.println("Vous avez déja un Plan d'épargne Logement.");
			break;
		default:

			System.out.println("Ca n'est pas un choix valide");
		}

	}

	public static void imprimerInfosClient(Agence agence) {

	}

	public static void afficherListeClient(Agence agence) {

		for (Client client : agence.getListeClient()) {
			System.out.println(client.toString());
			
		}
	}

	public static void afficherListeCompte(Agence agence) {

		for (CompteBancaire compte : agence.getListeComptes()) {
			System.out.println(compte.toString());
		}
	}

	public static void rechercherClient(Scanner scanner) {

	}

	public static void rechercherCompte(Scanner scanner) {

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
