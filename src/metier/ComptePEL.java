package metier;

import utilisateur.Client;

public class ComptePEL extends CompteEpargne {

	
	public ComptePEL(Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
		coeff = 0.025f;
		type = "Plan Epargne Logement";
	}
	
	@Override
	public String toString() {
		return type + super.toString();
	}
}
