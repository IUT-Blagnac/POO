public class CompteBancaire extends CompteSecurise {

	// Attribut numero de carte JISA
	private String numCJ;

	// Constructeurs
	public CompteBancaire() // Constructeur par defaut
	{
		this("Pas de numéro", "Pas de propriétaire", "Pas de numéro CJ");
	}

	public CompteBancaire(String pfNumCompte, String pfNomProp,
			String pNoCarteJisa) {
		this(pfNumCompte, pfNomProp, pNoCarteJisa, 0);
	}

	public CompteBancaire(String pfNumCompte, String pfNomProp,
			String pNoCarteJisa, double pDA) {
		super(pfNumCompte, pfNomProp, pDA);
		this.numCJ = pNoCarteJisa;
	}

	// Methodes de consultation

	// Numero de carte JISA
	public String getNumCarteJisa() {
		return this.numCJ;
		// Les objets String etant non modifiables
		// l'appelant ne pourra pas modifier la chaine
		// donc inutile de faire une copie ...
	}

	// Affichage d'un compte bancaire
	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Numero carte JISA : " + this.numCJ);
	}

	public void setNumCarteJisa(String pfNoCarteJisa) {
		this.numCJ = pfNoCarteJisa;
	}

} // Fin Classe CompteBancaire

