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
	
	/// Adresse() Genere une adresse Randomisée
	public Adresse() {
		this.numero = String.valueOf(Outils.getRandomNumberInRange(0, 200));
		this.libelle = RandomNameTable.tableRue[Outils.getRandomNumberInRange(0, RandomNameTable.tableRue.length - 1)];
		this.codePostal = Outils.genererNumericalId(5);
		this.ville = RandomNameTable.tableVille[Outils.getRandomNumberInRange(0, RandomNameTable.tableVille.length - 1)];
	}

	@Override
	public String toString() {
		return numero + " " + libelle + ", " + codePostal + ", " + ville;
	}

	
}
