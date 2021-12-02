package main;

import java.util.ArrayList;
import java.util.Scanner;

import client.*;
import metier.*;
import outils.Adresse;
import outils.Date;
import app.*;

public class Main {

	static ArrayList<Agence> listeAgences = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean saisieTermine = false;
		Agence currentAgence;
		
		//// TEST DEBUG ///
		Adresse adresseDebug = new Adresse("22", "rue des gros Gérards", "59250", "Quelquepart");
		Agence agenceDebug = new Agence("5454", "Chez Gérard bank", adresseDebug);
		
		Client clientDebug = new Client("Gérard", "Gérard", new Date("22","04","1965"), adresseDebug, "gerard@hotmail.fr", true);
		agenceDebug.getListeClient().add(clientDebug);
		ComptePEL Pel1 = new ComptePEL(agenceDebug, clientDebug , 0, false);
		App.creerCompte(agenceDebug, clientDebug, scanner);

		
		currentAgence = agenceDebug;
		clientDebug.setPEL(Pel1);
				
		//// TEST DEBUG ///
		
		// Debut de la boucle de saisie
		
		do {
			MenuPrincipal.afficher();
			
			
			
			switch (scanner.nextInt()) {
			case 1:
				
				listeAgences.add(App.creerAgence(scanner));
				System.out.println("Nouvelle agence créée :");
				System.out.println(listeAgences.get(listeAgences.size() - 1).toString());
				
				break;
			case 2:
				//// TODO : Selectionner l'agence à qui rajouter un client (Agence currentAgence ? ---> Menu Agence ?)
				App.creerClient(currentAgence, scanner);
				System.out.println("Nouveau client crée :");
				System.out.println(currentAgence.getListeClient().get(0).toString());
				
				break;
			case 3:
				App.creerCompte(currentAgence, currentAgence.getListeClient().get(0), scanner);
				
				break;
			case 4:
				App.rechercherCompte(scanner);
				break;
			case 5:
				App.rechercherClient(scanner);
				
				break;
			case 6:
				App.afficherListeClient(currentAgence);
				
				break;
			case 7:
				App.imprimerInfosClient(currentAgence);
				
				break;
				/// Quitte l'app
			case 8:
				
				System.out.println("Bonne journée");
				saisieTermine = true;
				break;
	
			default:
				break;
			}
		}while(!saisieTermine);
		scanner.close();
		
	}
}
