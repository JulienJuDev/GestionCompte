package client;

import metier.CompteBancaire;
import outils.*;

public class Client {

	private String id = Outils.genererIdClient();
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private int nbDeComptes = 0;

	private Adresse adresse;
	private String email;
	boolean estActif = true;
	private CompteBancaire[] listeComptes = new CompteBancaire[3];

	public Client(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email,
			boolean estActif) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.email = email;
	}
	//// Generer un Client Random
	public Client() {
		this.nom = RandomNameTable.tableNom[Outils.getRandomNumberInRange(0, RandomNameTable.tableNom.length - 1)];
		this.prenom = RandomNameTable.tablePrenom[Outils.getRandomNumberInRange(0, RandomNameTable.tablePrenom.length - 1)];
		this.dateDeNaissance = new Date(
				String.valueOf(Outils.getRandomNumberInRange(1, 30)),
				String.valueOf(Outils.getRandomNumberInRange(0, 12)), 
				String.valueOf(Outils.getRandomNumberInRange(1950,2002))
				);
		this.adresse = new Adresse();
		this.email = this.nom + this.prenom + "@gmail.com";
		
	}

	public CompteBancaire[] getListeComptes() {
		return listeComptes;
	}

	public void ajouterCompte(int indice, CompteBancaire compte) {
		this.listeComptes[indice] = compte;
		
	}
	
	@Override
	public String toString() {
		return 	"Client #" + id + "\n" +
				nom + " " +  prenom + "\n" +
				"Né le " + dateDeNaissance + "\n" +
				adresse.toString() + "\n" +
				email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEstActif() {
		return estActif;
	}

	public void setEstActif(boolean estActif) {
		this.estActif = estActif;
	}

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public int getNbDeComptes() {
		return nbDeComptes;
	}

	public void setNbDeComptes(int nbDeComptes) {
		this.nbDeComptes = nbDeComptes;
	}
}
