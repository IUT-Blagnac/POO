public class CompteBancaire extends CompteSecurise {

	// Attribut numero de carte JISA
	private String numCJ;

	// Constructeurs
	public CompteBancaire() // Constructeur par défaut
	{
		this("Pas de numéro", "Pas de propriétaire", "Pas de numéro CJ");
	}

	public CompteBancaire(String pNumCompte, String pNomProp,
			String pNoCarteJisa) {
		this(pNumCompte, pNomProp, pNoCarteJisa, 0);
	}

	public CompteBancaire(String pNumCompte, String pNomProp,
			String pNoCarteJisa, double pDA) {
		super(pNumCompte, pNomProp, pDA);
		this.numCJ = pNoCarteJisa;
	}

	// Methodes de consultation

	// Numero de carte JISA
	public String getNumCarteJisa() {
		return this.numCJ;
		// Les objets String étant non modifiables
		// l'appelant ne pourra pas modifier la chaine
		// donc inutile de faire une copie ...
	}

	// Affichage d'un compte bancaire
	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Numéro carte JISA : " + this.numCJ);
	}

	public void setNumCarteJisa(String pNoCarteJisa) {
		this.numCJ = pNoCarteJisa;
	}

} // Fin Classe CompteBancaire

