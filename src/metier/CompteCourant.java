package metier;

import utilisateur.Client;

public class CompteCourant extends CompteBancaire {

	public CompteCourant(metier.Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
		type = "Compte Courant";
	}

	@Override
	public String toString() {
		return type + super.toString();
	}
	
	
}
