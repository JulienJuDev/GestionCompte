package metier;

import client.Client;

public class CompteEpargne extends CompteBancaire {

	protected float coeff;
	protected float fraisBancaire = agence.getFraisBancaire() * (1 + coeff);
	
	public CompteEpargne(Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);

	}
}
