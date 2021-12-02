package client;

import metier.CompteBancaire;
import metier.CompteCourant;
import metier.CompteLivretA;
import metier.ComptePEL;
import outils.*;

public class Client {

	private String id = Outils.genererIdClient();
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private Adresse adresse;
	private String email;
	boolean estActif;
	private CompteCourant compteCourant;
	private CompteLivretA LivretA;
	private ComptePEL PEL;

	public Client(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email,
			boolean estActif) {

		
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.email = email;
		this.estActif = estActif;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance
				+ ", adresse=" + adresse + ", email=" + email + ", estActif=" + estActif + "]";
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

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}


	public CompteLivretA getLivretA() {
		return LivretA;
	}

	public void setLivretA(CompteLivretA livretA) {
		LivretA = livretA;
	}

	public ComptePEL getPEL() {
		return PEL;
	}

	public void setPEL(ComptePEL pEL) {
		PEL = pEL;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

}
