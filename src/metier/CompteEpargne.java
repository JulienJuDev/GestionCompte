package metier;

import client.Client;

public class CompteEpargne extends CompteBancaire {

	protected float coeff;
	
	public CompteEpargne(String id, Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(id, agence, client, solde, decouvertAutorise);

	}
	
	public float calculFrais() {
		return agence.getFraisBancaire() * (1 + coeff);
	}

}
