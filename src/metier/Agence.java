package metier;

import java.util.ArrayList;
import java.util.Scanner;

import client.Client;
import outils.*;

public class Agence {

	private String id;
	private String nom;
	private Adresse adresse;
	
	private ArrayList<Client> listeClient = new ArrayList<>();
	private ArrayList<CompteBancaire> listeComptes = new ArrayList<>();
	
	private final float fraisBancaire = 25f;
	
	
	public Agence(String id, String nom, Adresse adresse) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return ("Agence " + this.nom + "\n" +
				this.adresse.toString() + "\n" +
				"Id : " + this.id);
				
	}
	
	public ArrayList<Client> getListeClient() {
		return listeClient;
	}
	
	public void ajouterCompte(Agence agence, Client client, Scanner scanner) {
		
		System.out.println("Quel type de compte ?");
		System.out.println("1 : Compte courant");
		System.out.println("2 : Livret A");
		System.out.println("3 : Plan Epargne Logement");
		
		CompteBancaire compteCreated;
		switch (scanner.nextInt()) {
		case 1:
			if(client.getCompteCourant() == null ) {
				
				compteCreated = new CompteCourant(id, agence, client, 0, false);
				listeComptes.add(compteCreated);
				client.setCompteCourant((CompteCourant) compteCreated);
			}

			System.out.println("Vous avez déja un compte courant.");
			
		case 2:
			
			compteCreated = new CompteLivretA(id, agence, client, 0, false);
			listeComptes.add(compteCreated);
			client.setLivretA((CompteLivretA) compteCreated);
			
			System.out.println("Vous avez déja un Livret A.");
		case 3:
			
			compteCreated = new CompteCourant(id, agence, client, 0, false);
			listeComptes.add(compteCreated);
			client.setPEL((ComptePEL) compteCreated);
			System.out.println("Vous avez déja un Plan d'épargne Logement.");

		default:
			
			System.out.println("Ca n'est pas un choix valide");
		}
		
	}
	public void desactiverCompte(CompteBancaire compte) {
		compte.setEstActive(false);
	}
	public void activerCompte(CompteBancaire compte) {
		compte.setEstActive(true);
	}

	public void ajouterClient(Client client) {
		listeClient.add(client);
	}
	public void desactiverClient(Client client) {
		client.setEstActif(false);
	}
	public void activerClient(Client client) {
		client.setEstActif(true);
	}

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public float getFraisBancaire() {
		return fraisBancaire;
	}
}
