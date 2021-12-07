package outils;


public class DateNaissance {


	
	String jour;
	String mois;
	String annee;
	
	public DateNaissance(String jour, String mois, String annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	@Override
	public String toString() {
		return jour + " / " + mois + " / " + annee;
	}
	
	
}
