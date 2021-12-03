package metier;

import client.Client;

public class ComptePEL extends CompteEpargne {

	public ComptePEL(Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
		coeff = 0.025f;
	}
	
	@Override
	public String toString() {
		return "[ Plan Epargne Logement ] \n" + super.toString();
	}
}
