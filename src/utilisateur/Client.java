package utilisateur;

import metier.Agence;
import metier.CompteBancaire;
import outils.*;

public class Client extends Utilisateur {

	private int nbDeComptes = 0;
	private CompteBancaire[] listeComptes = new CompteBancaire[3];

	public Client(String nom, String prenom, DateNaissance dateDeNaissance, Adresse adresse, String email, boolean estActif, Agence agence) {
		super(nom, prenom, dateDeNaissance, adresse, email, estActif, agence);

		this.login = Outils.genererLoginClient();
		this.profil = "CLI";
	}

	//// Generer un Client Random
	public Client(Agence agence) {
		
		super(agence);
		this.login = Outils.genererLoginClient();
		this.profil = "CLI";
		
	}

	public CompteBancaire[] getListeComptes() {
		return listeComptes;
	}

	public void ajouterCompte(int indice, CompteBancaire compte) {
		this.listeComptes[indice] = compte;

	}

	@Override
	public String toString() {
		return "[ Client ] \n" + super.toString();
	}

	public int getNbDeComptes() {
		return nbDeComptes;
	}

	public void setNbDeComptes(int nbDeComptes) {
		this.nbDeComptes = nbDeComptes;
	}
}
