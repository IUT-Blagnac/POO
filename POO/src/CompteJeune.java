public class CompteJeune extends CompteSecurise {
	// Constructeurs
	public CompteJeune() // Constructeur par defaut
	{
		this("Pas de numéro", "Pas de propriétaire");
	}

	public CompteJeune(String pfNumCompte, String pfNomProp) {
		super(pfNumCompte, pfNomProp);
	}

	@Override
	public void afficher() {
		System.out.println("Compte Jeune");
		super.afficher();
	}
} // Fin Classe CompteJeune
