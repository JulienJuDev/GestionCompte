package metier;

import client.Client;

public class CompteCourant extends CompteBancaire {

	public CompteCourant(String id, metier.Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(id, agence, client, solde, decouvertAutorise);
	}
	
}
