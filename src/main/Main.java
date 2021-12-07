package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import metier.*;
import utilisateur.*;
import app.*;

public class Main {

	static ArrayList<Agence> listeAgences = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		File outFile = new File("C:\\WorkSpace\\GestionCompte\\src\\testWriter\\test.txt");
		outFile.getParentFile().mkdirs();
		Writer writer = new FileWriter(outFile, true);
		Reader reader = new FileReader(outFile);

		BufferedWriter bufferedWritter = new BufferedWriter(writer);
		BufferedReader bufferedReader = new BufferedReader(reader);

		boolean saisieTermine = false;

		listeAgences.add(new Agence());
		listeAgences.add(new Agence());

		listeAgences.get(0).getListeClient().add(new Client());
		listeAgences.get(0).getListeClient().add(new Client());
		listeAgences.get(0).getListeClient().add(new Client());
		listeAgences.get(1).getListeClient().add(new Client());
		listeAgences.get(1).getListeClient().add(new Client());
		listeAgences.get(1).getListeClient().add(new Client());
		
		listeAgences.get(0).getListeConseiller().add(new Conseiller());
		listeAgences.get(0).getListeConseiller().add(new Conseiller());
		
		listeAgences.get(1).getListeConseiller().add(new Conseiller());
		listeAgences.get(1).getListeConseiller().add(new Conseiller());

		listeAgences.get(0).getListeAdmin().add(new Admin());
		listeAgences.get(1).getListeAdmin().add(new Admin());

		String currentMenu = "AGENCE";

		// Debut de la boucle de saisie

		do {

			//// MENU AGENCE
			if (currentMenu.contentEquals("AGENCE")) {
				MenuChoixAgence.afficher();
				for (int i = 0; i < listeAgences.size(); i++) {

					System.out.println((i + 1) + ". " + listeAgences.get(i).getNom());
				}

				App.setCurrentAgence(listeAgences.get(scanner.nextInt() - 1));
				currentMenu = "LOGIN";
			}

			//// MENU LOGIN
			if (currentMenu.contentEquals("LOGIN")) {
				MenuLogin.afficher();
				App.getCurrentAgence().getListeClient();
				//// DEBUG ///
				for (Client client: App.getCurrentAgence().getListeClient()) {
					System.out.println(client.getNom() + " " + client.getPrenom());
					System.out.println(client.getLogin());
				}
				//// DEBUG ///
				switch (scanner.next()) {
				case "1":

					App.setCurrentUser(App.rechercherClientParLogin(scanner.next()));
					System.out.println("Content de vous revoir " + App.getCurrentUser().getNom()
							+ " " + App.getCurrentUser().getPrenom());
					currentMenu = "PRINCIPAL";

					break;
				case "2":

					currentMenu = "AGENCE";
					break;

				default:
					break;
				}
			}

			//// MENU RECHERCHER
			if (currentMenu.contentEquals("RECHERCHER")) {
				MenuRecherche.afficher();
				switch (scanner.next()) {
				case "1":
					App.rechercherClientParNom(scanner.next());
					break;
				case "2":
					App.rechercherClientParID(scanner.next());
					break;
				case "3":
					App.rechercherClientParCompte(scanner.next());
					break;
				case "4":
					currentMenu = "PRINCIPAL";
					break;
				}
			}

			//// MENU PRINCIPAL
			if (currentMenu.contentEquals("PRINCIPAL")) {

				MenuPrincipal.afficher();

				switch (scanner.next()) {
				case "1":

					listeAgences.add(App.creerAgence(scanner));
					System.out.println("Nouvelle agence créée :");
					System.out.println(listeAgences.get(listeAgences.size() - 1).toString());

					break;
				case "d1": // debug fakeAgence

					listeAgences.add(App.creerFakeAgence());
					System.out.println("Nouvelle agence créée :");
					System.out.println(listeAgences.get(listeAgences.size() - 1).toString());

					break;

				case "2":
					App.creerClient(scanner);

					System.out.println("Nouveau client crée :");
					System.out.println(App.getCurrentAgence().getListeClient()
							.get(App.getCurrentAgence().getListeClient().size() - 1).toString());
					bufferedWritter.append(App.getCurrentAgence().getListeClient()
							.get(App.getCurrentAgence().getListeClient().size() - 1).toString());

					break;
				case "d2": // debug fake Client

					App.creerFakeClient();

					System.out.println("Nouveau client crée :");
					System.out.println(App.getCurrentAgence().getListeClient()
							.get(App.getCurrentAgence().getListeClient().size() - 1).toString());
					bufferedWritter.append(App.getCurrentAgence().getListeClient()
							.get(App.getCurrentAgence().getListeClient().size() - 1).toString());

					break;
				case "3":

					App.creerCompte(App.getCurrentAgence().getListeClient().get(0), scanner);

					break;

				case "4":
					System.out.println("Rentrez le numéro de compte");
					App.rechercherCompte(scanner.next());
					break;

				case "5":
					currentMenu = "RECHERCHER";

					break;
				case "6":
					App.afficherListeClient();

					break;
				case "7":

					bufferedWritter.append(App.creerFicheClient(scanner.next()).toString());
					bufferedWritter.flush();

					break;
				/// Retour au login
				case "8":

					System.out.println("Bonne journée.");
					App.setCurrentUser(null);
					currentMenu = "LOGIN"; 
//					saisieTermine = true;
					break;

				default:
					System.out.println("Ce n'est pas un choix valide");
					
					break;
				}
			}
		} while (!saisieTermine);

		scanner.close();
		bufferedWritter.close();
		bufferedReader.close();
	}
}
