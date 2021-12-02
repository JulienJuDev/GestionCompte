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
		System.out.println("Numéro de client");
		String email = scanner.next();
		System.out.println("Numéro de client");
		String id = scanner.next();
		
		agence.ajouterClient(new Client(id, nom, prenom, dateNaissance, adresse, email, true));
	}
	public static void creerCompte(Agence agence, Client client, Scanner scanner) {

		agence.ajouterCompte(agence, client, scanner);
		
	}


	public static void imprimerInfosClient() {

	}

	public static void afficherListeClient() {
		
	}
	public static void afficherListeCompte() {

	}

	public static void rechercherClient(Scanner scanner) {

	}

	public static void rechercherCompte(Scanner scanner) {

	}

}
