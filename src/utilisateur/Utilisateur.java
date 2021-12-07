package utilisateur;

import metier.Agence;
import outils.Adresse;
import outils.DateNaissance;
import outils.Outils;
import outils.RandomNameTable;

public abstract class Utilisateur {

	protected String login;
	protected String motDePasse = Outils.genererMotDePasse(8);
	protected String id = Outils.genererId();
	protected String nom;
	protected String prenom;
	protected DateNaissance dateDeNaissance;
	protected Adresse adresse;
	protected String email;
	protected String profil;
	protected boolean estActif = true;
	protected Agence agence;
	
	


	public Utilisateur(String nom, String prenom, DateNaissance dateDeNaissance, Adresse adresse, String email,
			boolean estActif, Agence agence) {

		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.email = email;
		this.agence = agence;
		
	}

	//// Version random de cette classe
	public Utilisateur(Agence agence) {
		this.nom = RandomNameTable.tableNom[Outils.getRandomNumberInRange(0, RandomNameTable.tableNom.length - 1)];
		this.prenom = RandomNameTable.tablePrenom[Outils.getRandomNumberInRange(0,
				RandomNameTable.tablePrenom.length - 1)];
		this.dateDeNaissance = new DateNaissance(String.valueOf(Outils.getRandomNumberInRange(1, 30)),
				String.valueOf(Outils.getRandomNumberInRange(0, 12)),
				String.valueOf(Outils.getRandomNumberInRange(1950, 2002)));
		this.adresse = new Adresse();
		this.email = this.nom + this.prenom + "@gmail.com";
		this.agence = agence;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public DateNaissance getDateDeNaissance() {
		return dateDeNaissance;
	}
	@Override
	public String toString() {
		return id + "\n" + nom + " " + prenom + "\n" + "Né le " + dateDeNaissance + "\n"
				+ adresse.toString() + "\n" + email;
	}
	public String getProfil() {
		return profil;
	}
	public Agence getAgence() {
		return agence;
	}
	
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
}
