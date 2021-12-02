package outils;

public class Adresse {
	
	String numero;
	String rue;
	String codePostal;
	String ville;
	
	public Adresse(String numero, String rue, String codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse : " + numero + ", rue " + rue + ", " + codePostal + ", " + ville;
	}

	
}
