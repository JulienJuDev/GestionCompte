package metier;

import client.Client;

public class CompteEpargne extends CompteBancaire {

	protected float coeff;
	
	public CompteEpargne(Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);

	}
	
	public float calculFrais() {
		return agence.getFraisBancaire() * (1 + coeff);
	}

}
