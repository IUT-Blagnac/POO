public class CompteSecurise extends CompteDepot {
	private double debitAutorise;

	public CompteSecurise() {
		this("Pas de numéro", "Pas de propriétaire");
	}

	public CompteSecurise(String pfNumCompte, String pfNomProp) {
		this(pfNumCompte, pfNomProp, 0);
	}

	public CompteSecurise(String pfNumCompte, String pfNomProp, double pfDA) {
		super(pfNumCompte, pfNomProp);
		this.debitAutorise = pfDA;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Decouvert autorise : " + this.debitAutorise);
	}

	public boolean isRetraitPossible(double pfMontant) {
		return (this.soldeCompte() - pfMontant >= (-1) * this.debitAutorise);
	}

	@Override
	public void retirer(double pfMontant) throws CompteException {
		if (!this.isRetraitPossible(pfMontant)) {
			throw new CompteException("Retrait de : "+ pfMontant
					+ " impossible sur "+this.getNumCompte());
		}
		super.retirer(pfMontant);
	}
}