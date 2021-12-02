package metier;

import client.Client;

public class ComptePEL extends CompteEpargne {

	private final float coeff = 0.025f;
	
	public ComptePEL(String id, metier.Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(id, agence, client, solde, decouvertAutorise);
	}
	
}
