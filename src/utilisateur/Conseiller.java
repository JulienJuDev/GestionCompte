package utilisateur;

import outils.Adresse;
import outils.Date;
import outils.Outils;

public class Conseiller extends Utilisateur {

	
	public Conseiller() {
		
		this.profil = "CONS";
		this.login = Outils.genererLoginConseiller();
	}

	public Conseiller(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email,
			boolean estActif) {
		super(nom, prenom, dateDeNaissance, adresse, email, estActif);
		this.login = Outils.genererLoginConseiller();
	}
	

}
