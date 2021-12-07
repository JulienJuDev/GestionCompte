package utilisateur;

import outils.Adresse;
import outils.Date;
import outils.Outils;

public abstract class Utilisateur {

	protected String login;
	protected String motDePasse = Outils.genererMotDePasse(8);
	protected String id;
	protected String nom;
	protected String prenom;
	protected Date dateDeNaissance;
	protected Adresse adresse;
	protected String email;
	protected boolean estActif = true;
	
	

	public Utilisateur(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email,
			boolean estActif) {

		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.email = email;
		
	}

	public Utilisateur() {

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

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	@Override
	public String toString() {
		return id + "\n" + nom + " " + prenom + "\n" + "Né le " + dateDeNaissance + "\n"
				+ adresse.toString() + "\n" + email;
	}
}
