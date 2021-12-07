package utilisateur;

import outils.Adresse;
import outils.Date;
import outils.Outils;

public class Admin extends Utilisateur {

	public Admin() {
		
		this.login = Outils.genererLoginAdmin();
		this.profil = "ADM";

	}

	public Admin(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email, boolean estActif) {
		super(nom, prenom, dateDeNaissance, adresse, email, estActif);
		this.profil = "ADM";
	}
}
