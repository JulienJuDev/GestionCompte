package utilisateur;

import metier.Agence;
import outils.Adresse;
import outils.Date;
import outils.Outils;

public class Conseiller extends Utilisateur {

	
	public Conseiller(Agence agence) {
		
		super(agence);
		this.profil = "CONS";
		this.login = Outils.genererLoginConseiller();
	}

	public Conseiller(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String email,
			boolean estActif, Agence agence) {
		super(nom, prenom, dateDeNaissance, adresse, email, estActif, agence);
		this.login = Outils.genererLoginConseiller();
		this.profil = "CONS";
	}
	

}
