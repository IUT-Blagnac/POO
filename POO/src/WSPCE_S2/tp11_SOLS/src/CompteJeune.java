public class CompteJeune extends CompteSecurise {
	// Constructeurs
	public CompteJeune() // Constructeur par défaut
	{
		this("Pas de numéro", "Pas de propriétaire");
	}

	public CompteJeune(String pNumCompte, String pNomProp) {
		super(pNumCompte, pNomProp);
	}

	@Override
	public void afficher() {
		System.out.println("Compte Jeune");
		super.afficher();
	}
} // Fin Classe CompteJeune
