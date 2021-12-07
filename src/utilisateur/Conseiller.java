package utilisateur;

import outils.Adresse;
import outils.Date;
import outils.Outils;

public class Conseiller extends Utilisateur {

	String login = Outils.genererLoginConseiller();
	public Conseiller() {
		super();
	}

	public Conseiller(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email,
			boolean estActif) {
		super(nom, prenom, dateDeNaissance, adresse, email, estActif);
	}
	

}
