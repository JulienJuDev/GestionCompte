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

		listeAgences.get(0).getListeClient().add(new Client(listeAgences.get(0)));
		listeAgences.get(0).getListeClient().add(new Client(listeAgences.get(0)));
		listeAgences.get(1).getListeClient().add(new Client(listeAgences.get(1)));
		listeAgences.get(1).getListeClient().add(new Client(listeAgences.get(1)));

		listeAgences.get(0).getListeConseiller().add(new Conseiller(listeAgences.get(0)));
		listeAgences.get(1).getListeConseiller().add(new Conseiller(listeAgences.get(1)));

		listeAgences.get(0).getListeAdmin().add(new Admin(listeAgences.get(0)));
		listeAgences.get(1).getListeAdmin().add(new Admin(listeAgences.get(1)));

		String currentMenu = "AGENCE";
		Client currentClient = null;

		// Debut de la boucle de saisie

		do {

			//// MENU AGENCE : Selectionne l'agence dans laquelle on va travailler

			if (currentMenu.contentEquals("AGENCE")) {
				MenuChoixAgence.afficher();
				for (int i = 0; i < listeAgences.size(); i++) {

					System.out.println((i + 1) + ". " + listeAgences.get(i).getNom());
				}

				try {
					App.setCurrentAgence(listeAgences.get(scanner.nextInt() - 1));
					currentMenu = "LOGIN";
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Choix invalide");
				}
			}

			//// MENU LOGIN : Permet d'accéder aux utilisateurs enregistrées dans
			//// listeClient/listeConseiller/ListeAdmin
			// TODO Si le login ne correspond a personne dans les listes, il sera crée

			if (currentMenu.contentEquals("LOGIN")) {

				//// DEBUG affiche liste client///
				System.out.println("DEBUG : Liste des clients \n");
				for (Client client : App.getCurrentAgence().getListeClient()) {
					System.out.println(client.getNom() + " " + client.getPrenom());
					System.out.println("login + " + client.getLogin());
					System.out.println("mot de passe " + client.getMotDePasse());
				}
				System.out.println("DEBUG : Liste des conseillers \n");
				for (Conseiller conseiller : App.getCurrentAgence().getListeConseiller()) {
					System.out.println(conseiller.getNom() + " " + conseiller.getPrenom());
					System.out.println("login : " + conseiller.getLogin());
					System.out.println("mot de passe " + conseiller.getMotDePasse());
				}
				System.out.println("DEBUG : Liste des admins \n");
				for (Admin admin : App.getCurrentAgence().getListeAdmin()) {
					System.out.println(admin.getNom() + " " + admin.getPrenom());
					System.out.println("login : " + admin.getLogin());
					System.out.println("mot de passe " + admin.getMotDePasse());
				}
				////////////////////////////////////

				MenuLogin.afficher();
				App.getCurrentAgence().getListeClient();

				switch (scanner.next()) {
				case "1":

					try {
						System.out.println("Rentrez votre login");
						App.setCurrentUser(App.rechercherUserParLogin(scanner.next()));

						System.out.println("Rentrez votre mot de passe");

						if (scanner.next().equals(App.getCurrentUser().getMotDePasse())) {

							System.out.println("Content de vous revoir " + App.getCurrentUser().getNom() + " "
									+ App.getCurrentUser().getPrenom());
							currentMenu = "PRINCIPAL";
						}

						else {
							System.out.println("Mot de passe Incorrect");

						}

					} catch (NullPointerException e) {
						System.out.println("Login incorrect");
					}

					break;
				case "2":

					// TODO Creer un nouvel utilisateur via login
					currentMenu = "AGENCE";
					break;

				case "3":

					currentMenu = "AGENCE";
					break;

				default:
					break;
				}
			}

			//// MENU SELECTION DE CLIENT

			if (currentMenu.contentEquals("SELECTIONCLIENT")) {

				MenuSelectionClient.afficher();
				switch (scanner.next()) {
				case "1":
					currentClient = App.rechercherClientParNom(scanner.next());
					break;
				case "2":
					currentClient = App.rechercherClientParID(scanner.next());
					break;
				case "3":
					currentClient = App.rechercherClientParCompte(scanner.next());
					break;
				case "4":
					currentMenu = "PRINCIPAL";
					break;

				default:
					System.out.println("Ca n'est pas un choix valide");
					break;
				}
			}

			//// MENU PRINCIPAL CLIENT
			if (currentMenu.contentEquals("PRINCIPAL") && App.getCurrentUser().getProfil().equals("CLI")) {

				/// Setting current Client
				currentClient = (Client) App.getCurrentUser();
				MenuClient.afficher();

				switch (scanner.next()) {

				case "1":
					System.out.println(currentClient.toString());

					break;

				case "2":

					currentMenu = "SELECTIONCOMPTE";

					/// Retour au login
				case "0":

					System.out.println("Bonne journée.");
					App.setCurrentUser(null);
					currentClient = null;
					currentMenu = "LOGIN";
					break;

				default:
					System.out.println("Ce n'est pas un choix valide");

					break;
				}
			}
			//// MENU PRINCIPAL CONSEILLER
			if (currentMenu.contentEquals("PRINCIPAL") && App.getCurrentUser().getProfil().equals("CONS")) {

				MenuConseiller.afficher(currentClient != null);

				//// Switch en cas de Client non séléctionné
				if (currentClient == null) {

					switch (scanner.next()) {

					//// Selectionner un Client
					case "1":

						currentMenu = "SELECTIONCLIENT";

						break;
					//// Créer un nouveau Client
					case "2":
						App.getCurrentAgence().getListeClient().add(App.creerClient(scanner, App.getCurrentAgence()));

						break;

					//// Créer un nouveau Random Client
					case "2d":
						App.getCurrentAgence().getListeClient().add(new Client(App.getCurrentAgence()));

						break;

					case "3":
						App.afficherListeClient();

						break;

					case "0":

						System.out.println("Bonne journée.");
						App.setCurrentUser(null);
						currentMenu = "LOGIN";
						break;

					default:
						System.out.println("Ce n'est pas un choix valide");

						break;
					}

				}
				// System.out.println("Vous n'avez pas de client séléctionné");

				//// Switch en cas de Client séléctionné
				else {

					switch (scanner.next()) {

					//// Selectionner un Client
					case "1":

						currentMenu = "SELECTIONCLIENT";

						break;
					//// Créer un nouveau Client
					case "2":

						break;

					//// Créer un nouveau Random Client
					case "3":
						App.getCurrentAgence().getListeClient().add(new Client(App.getCurrentAgence()));

						break;
					case "4":
						App.creerCompte(currentClient, scanner);

						break;
					case "5":
						// TODO Modifier les infos Client

						break;
					case "6":
						currentMenu = "SELECTIONCOMPTE";

						break;
					case "0":

						System.out.println("Bonne journée.");
						App.setCurrentUser(null);
						currentMenu = "LOGIN";
						break;

					default:
						System.out.println("Ce n'est pas un choix valide");

						break;
					}

					System.out.println(currentClient.toString());
				}
				//// MENU SELECTION COMPTE

				if (currentMenu.contentEquals("SELECTIONCOMPTE")) {
					MenuSelectionCompte.afficher(currentClient);

					if (currentClient.getNbDeComptes() > 0) {

						for (int i = 0; i < currentClient.getNbDeComptes(); i++) {
							System.out.println((i + 1) + ". " + currentClient.getListeComptes()[i]);
						}
						try {
							App.setCurrentCompte(currentClient.getListeComptes()[scanner.nextInt() + 1]);
							currentMenu = "COMPTE";

						} catch (IndexOutOfBoundsException e) {
							System.out.println("Choix invalide");
						}

					} else {
						System.out.println("Il n'y a pas de compte actifs.");
					}
					break;

				}
				//// MENU COMPTE

				if (currentMenu.contentEquals("SELECTIONCOMPTE")) {

					MenuCompte.afficher();
					App.getCurrentCompte().afficher();
					switch (scanner.next()) {

					case "1":
						bufferedWritter.append(new FicheClient(currentClient).toString());
						break;

					case "2":
						System.out.println("Combien souhaitez vous déposer ?");
						//TODO sommes positives
						App.getCurrentCompte().setSolde(App.getCurrentCompte().getSolde() + scanner.nextFloat());
						break;
					case "3":
						System.out.println("Combien souhaitez vous retirer ?");
						//TODO sommes positives + compte suffisament alimenté + decouvert autorisé

						App.getCurrentCompte().setSolde(App.getCurrentCompte().getSolde() - scanner.nextFloat());
						break;
						
					case "4":
						System.out.println("Rentrez l'id du compte de destination");
						//TODO sommes positives + compte suffisament alimenté + decouvert autorisé
						
						CompteBancaire compteDestination = App.rechercherCompte(scanner.next());
						float sommeAVirer = scanner.nextFloat();
						App.getCurrentCompte().setSolde(App.getCurrentCompte().getSolde() - sommeAVirer);
						compteDestination.setSolde(App.getCurrentCompte().getSolde() + sommeAVirer);
					}
				}
			}
		} while (!saisieTermine);

		scanner.close();
		bufferedWritter.close();
		bufferedReader.close();

	}
}
