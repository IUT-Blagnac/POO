public class CompteMoneo extends Compte {
	private String noCarteMoneo;

	// Constructeurs
	public CompteMoneo() {
		this("Pas de numero moneo");
	}

	public CompteMoneo(String pfNoCarteMoneo) // Constructeur par defaut
	{
		this("Pas de numero", "Pas de proprietaire", pfNoCarteMoneo);
	}

	public CompteMoneo(String pfNumCompte, String pfNomProp, String pfNoCarteMoneo) {
		super(pfNumCompte, pfNomProp);
		this.noCarteMoneo = pfNoCarteMoneo;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Numero de carte Moneo : " + this.noCarteMoneo);
	}

	public String getNoCarteMoneo() {
		return this.noCarteMoneo;
	}

	public void setNoCarteMoneo(String pfNoCarteMoneo) {
		this.noCarteMoneo = pfNoCarteMoneo;
	}
}
