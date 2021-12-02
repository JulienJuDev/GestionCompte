package outils;

public class Adresse {
	
	String numero;
	String libelle;
	String codePostal;
	String ville;
	
	public Adresse(String numero, String libelle, String codePostal, String ville) {
		this.numero = numero;
		this.libelle = libelle;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse : " + numero + ", " + libelle + ", " + codePostal + ", " + ville;
	}

	
}
