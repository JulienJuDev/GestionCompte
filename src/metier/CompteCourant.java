package metier;

import client.Client;

public class CompteCourant extends CompteBancaire {

	public CompteCourant(metier.Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
	}
	
}
