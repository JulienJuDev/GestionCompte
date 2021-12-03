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
		this.nom = 	RandomNameTable.tableBankPrefix[Outils.getRandomNumberInRange(0, RandomNameTable.tableBankPrefix.length - 1)] + 
					RandomNameTable.tableBankMiddleName[Outils.getRandomNumberInRange(0, RandomNameTable.tableBankMiddleName.length - 1)] +	
					RandomNameTable.tableBankSuffix[Outils.getRandomNumberInRange(0, RandomNameTable.tableBankSuffix.length - 1)];
		this.adresse = new Adresse();
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
