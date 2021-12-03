package metier;

import client.Client;

public class FicheClient {
	
	String result;
	
	public FicheClient(Client client) {
	
		result = (
				"Numéro client : " + client.getId() + "\n" +
				"Nom : " + client.getNom() + "\n" +
				"Prénom : " + client.getPrenom() + "\n" +
				"Date de Naissance : " + client.getDateDeNaissance() + "\n" +
				"____________________ \n" +
				"Liste de compte \n " +
				"____________________ \n" +
				"Numéro de Compte \t \t \t Solde" + "\n" +
				"____________________\n");
				
				for (CompteBancaire compte : client.getListeComptes()) {
					result += compte.getId() + " \t \t \t " + compte.solde + " \t \t \t ";
					if(compte.solde >= 0f) result += ":)"; else { result += ":(";}
					result += "\n";
				}
	}

	@Override
	public String toString() {
		return result;
	}
}
