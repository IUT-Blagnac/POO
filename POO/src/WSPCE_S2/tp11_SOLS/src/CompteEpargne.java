public class CompteEpargne extends CompteDepot {
	// Attributs

	// Taux d'interets
	private double txInterets;

	// Constructeurs
	public CompteEpargne()// Constructeur par défaut
	{
		this("Pas de numéro", "Pas de propriétaire", 0);
	}

	public CompteEpargne(String pNumCompte, String pNomProp, double pTxInterets) {
		super(pNumCompte, pNomProp);
		this.txInterets = pTxInterets;
	}

	// Methodes de consultation

	// Taux d'interets du compte
	public double getTauxInterets() {
		return this.txInterets;
	}

	// Interets courants sur le compte
	public double interetsCompte() {
		if (this.soldeCompte() > 0)
			return this.soldeCompte() * this.txInterets / 100;
		return 0;
	}

	// Affichage d'un compte epargne
	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Taux : " + this.txInterets);
	}

	// Methodes de mise a jour

	// Comptabilisation des interets
	public void ajouterInterets() {
		if (this.interetsCompte() > 0)
			try {
				this.deposer(this.interetsCompte());
			} catch (CompteException e) {}
	}
} // Fin Classe CompteEpargne