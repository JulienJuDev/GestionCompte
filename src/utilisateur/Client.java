package utilisateur;

import metier.CompteBancaire;
import outils.*;

public class Client extends Utilisateur {

	private int nbDeComptes = 0;
	private CompteBancaire[] listeComptes = new CompteBancaire[3];

	public Client(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email, boolean estActif) {
		super(nom, prenom, dateDeNaissance, adresse, email, estActif);

		this.login = Outils.genererLoginClient();
	}

	//// Generer un Client Random
	public Client() {
		this.nom = RandomNameTable.tableNom[Outils.getRandomNumberInRange(0, RandomNameTable.tableNom.length - 1)];
		this.prenom = RandomNameTable.tablePrenom[Outils.getRandomNumberInRange(0,
				RandomNameTable.tablePrenom.length - 1)];
		this.dateDeNaissance = new Date(String.valueOf(Outils.getRandomNumberInRange(1, 30)),
				String.valueOf(Outils.getRandomNumberInRange(0, 12)),
				String.valueOf(Outils.getRandomNumberInRange(1950, 2002)));
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
		return "[ Client ] \n" + super.toString();
	}

	public int getNbDeComptes() {
		return nbDeComptes;
	}

	public void setNbDeComptes(int nbDeComptes) {
		this.nbDeComptes = nbDeComptes;
	}
}
