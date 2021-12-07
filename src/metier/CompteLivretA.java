package metier;

import utilisateur.Client;

public class CompteLivretA extends CompteEpargne {

	public CompteLivretA(metier.Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
		coeff = 0.1f;
		type = "Livret A";
	}

	@Override
	public String toString() {
		return type + super.toString();
	}
}
