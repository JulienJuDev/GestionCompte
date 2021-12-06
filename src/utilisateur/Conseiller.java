package utilisateur;

import outils.Adresse;
import outils.Date;

public class Conseiller extends Utilisateur {

	
	public Conseiller() {
		super();
	}

	public Conseiller(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email,
			boolean estActif) {
		super(nom, prenom, dateDeNaissance, adresse, email, estActif);
	}
	

}
