package metier;

import client.Client;

public class CompteLivretA extends CompteEpargne {

	public CompteLivretA(metier.Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
		coeff = 0.1f;
	}

	@Override
	public String toString() {
		return "[ Livret A ] \n" + super.toString();
	}
}
