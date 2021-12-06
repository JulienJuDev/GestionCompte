package utilisateur;

import outils.Adresse;
import outils.Date;
import outils.Outils;

public class Admin extends Utilisateur {

	String login = Outils.genererLoginAdmin();
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email, boolean estActif) {
		super(nom, prenom, dateDeNaissance, adresse, email, estActif);
		// TODO Auto-generated constructor stub
	}
}
