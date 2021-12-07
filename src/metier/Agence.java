package metier;

import java.util.ArrayList;

import client.Client;
import outils.*;

public class Agence {

	private String id = Outils.genererNumericalId(3);
	private String nom;
	private Adresse adresse;
	
	private ArrayList<Client> listeClient = new ArrayList<>();
	private ArrayList<CompteBancaire> listeComptes = new ArrayList<>();
	
	private final float fraisBancaire = 25f;
	
	
	public Agence(String nom, Adresse adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}
	
	//// Agence() Genere une agence randomisée
	public Agence() {
		this.adresse = new Adresse();
		this.nom = this.adresse.getLibelle();
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
