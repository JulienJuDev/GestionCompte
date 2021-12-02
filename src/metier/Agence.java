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



	public ArrayList<CompteBancaire> getListeComptes() {
		return listeComptes;
	}
}
