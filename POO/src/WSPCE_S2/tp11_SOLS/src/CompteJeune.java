public class CompteJeune extends CompteSecurise {
	// Constructeurs
	public CompteJeune() // Constructeur par d�faut
	{
		this("Pas de num�ro", "Pas de propri�taire");
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
