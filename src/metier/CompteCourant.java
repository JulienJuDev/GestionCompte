package metier;

import utilisateur.Client;

public class CompteCourant extends CompteBancaire {

	public CompteCourant(metier.Agence agence, Client client, float solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
	}

	@Override
	public String toString() {
		return "[ Compte courant ] \n" + super.toString();
	}
	
	
}
