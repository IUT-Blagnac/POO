public class Operation {
	private String sens;
	private double montant;

	public Operation(String pfSens, double pfMont) {
		if (!(pfSens == SensOperation.DEBIT) && !(pfSens == SensOperation.CREDIT))
		{
			System.out.println("Erreur de sens " + pfSens + " (pour : " + pfMont
					+ ").");
			System.out.println("Fin Programme ...");
			System.exit(-1);
		}
		this.sens = pfSens;
		this.montant = pfMont;
	}

	public String getSens() {
		return this.sens;
	}

	public double getMontant() {
		return this.montant;
	}
}