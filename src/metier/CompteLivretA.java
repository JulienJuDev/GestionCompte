package metier;

import client.Client;

public class CompteLivretA extends CompteEpargne {

	private final float coeff = 0.1f;
	
	public CompteLivretA(String id, metier.Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(id, agence, client, solde, decouvertAutorise);
	}

}
