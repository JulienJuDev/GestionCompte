package metier;

import utilisateur.Client;

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
				
		
				for (int i = 0; i < client.getNbDeComptes(); i++) {
					result += client.getListeComptes()[i].getId() + " \t \t \t " + client.getListeComptes()[i].getSolde() + " \t \t \t ";
					if(client.getListeComptes()[i].getSolde() >= 0f) result += ":)"; else { result += ":(";}
					result += "\n";
				}
	}

	@Override
	public String toString() {
		return result;
	}
}
