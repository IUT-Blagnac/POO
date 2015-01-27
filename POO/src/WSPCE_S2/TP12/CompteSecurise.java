public class CompteSecurise extends CompteDepot {
	private double debitAutorise;

	public CompteSecurise() {
		this("Pas de numéro", "Pas de propriétaire");
	}

	public CompteSecurise(String pNumCompte, String pNomProp) {
		this(pNumCompte, pNomProp, 0);
	}

	public CompteSecurise(String pNumCompte, String pNomProp, double pDA) {
		super(pNumCompte, pNomProp);
		this.debitAutorise = pDA;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Decouvert autorise : " + this.debitAutorise);
	}

	public boolean isRetraitPossible(double pSomme) {
		return (this.soldeCompte() - pSomme >= (-1) * this.debitAutorise);
	}

	@Override
	public void retirer(double pSomme) throws CompteException {
		if (!this.isRetraitPossible(pSomme)) {
			throw new CompteException("Retrait de : "+ pSomme
					+ " impossible sur "+this.getNumCompte());
		}
		super.retirer(pSomme);
	}
}