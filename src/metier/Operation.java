package metier;

import java.sql.Date;

public class Operation {

	protected String type;

	protected Date date;
	protected float montant;
	
	public Operation(String type, Date date, float montant, long time) {
		this.type = type;
		this.date = date;
		this.montant = montant;
	}
	
	@Override
	public String toString() {
		return "Operations [type=" + type + ", date=" + date + ", montant=" + montant + "]";
	}
	
	
}
