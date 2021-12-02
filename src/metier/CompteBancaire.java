package metier;

import client.Client;
import outils.Outils;

public abstract class CompteBancaire {

	protected String id = Outils.genererNumericalId(11);
	protected Agence agence;
	protected Client client;
	protected float solde;
	protected boolean decouvertAutorise;
	protected boolean estActif = true;

	public CompteBancaire(Agence agence, Client client, float solde, boolean decouvertAutorise) {
		
		this.agence = agence;
		this.client = client;
		this.solde = solde;
		this.decouvertAutorise = decouvertAutorise;
		
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public boolean isDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(boolean decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	public String getId() {
		return id;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setEstActive(boolean estActive) {
		this.estActif = estActive;
	}

	public boolean isEstActive() {
		return estActif;
	}

}
