public class Operation {
	private String sens;
	private double montant;

	public Operation(String pSens, double pMont) {
		if (!(pSens == SensOperation.DEBIT) && !(pSens == SensOperation.CREDIT))
		{
			System.out.println("Erreur de sens " + pSens + " (pour : " + pMont
					+ ").");
			System.out.println("Fin Programme ...");
			System.exit(-1);
		}
		this.sens = pSens;
		this.montant = pMont;
	}

	public String getSens() {
		return this.sens;
	}

	public double getMontant() {
		return this.montant;
	}
}