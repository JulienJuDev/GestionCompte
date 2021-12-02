package main;

import java.util.ArrayList;
import java.util.Scanner;

import client.*;
import metier.*;
import app.*;

public class Main {

	static ArrayList<Agence> listeAgences = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean saisieTermine = false;
		
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
				App.creerClient(listeAgences.get(0), scanner);
				System.out.println("Nouveau client crée :");
				System.out.println(listeAgences.get(0).getListeClient().get(0).toString());
				
				break;
			case 3:
				App.creerCompte(listeAgences.get(0),listeAgences.get(0).getListeClient().get(0), scanner);
				
				break;
			case 4:
				App.rechercherCompte(scanner);
				break;
			case 5:
				App.rechercherClient(scanner);
				
				break;
			case 6:
				App.afficherListeClient();
				
				break;
			case 7:
				App.imprimerInfosClient();
				
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
