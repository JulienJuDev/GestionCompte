package utilisateur;

import metier.Agence;
import outils.Adresse;
import outils.Date;
import outils.Outils;

public class Admin extends Utilisateur {

	public Admin(Agence agence) {
		super(agence);
		this.login = Outils.genererLoginAdmin();
		this.profil = "ADM";

	}

	public Admin(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email, boolean estActif, Agence agence) {
		super(nom, prenom, dateDeNaissance, adresse, email, estActif, agence);
		this.profil = "ADM";
	}
}
