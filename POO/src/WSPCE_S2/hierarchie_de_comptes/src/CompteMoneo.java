public class CompteMoneo extends Compte {
	private String noCarteMoneo;

	// Constructeurs
	public CompteMoneo() {
		this("Pas de numéro monéo");
	}

	public CompteMoneo(String pNoCarteMoneo) // Constructeur par défaut
	{
		this("Pas de numéro", "Pas de propriétaire", pNoCarteMoneo);
	}

	public CompteMoneo(String pNumCompte, String pNomProp, String pNoCarteMoneo) {
		super(pNumCompte, pNomProp);
		this.noCarteMoneo = pNoCarteMoneo;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Numero de carte Moneo : " + this.noCarteMoneo);
	}

	public String getNoCarteMoneo() {
		return this.noCarteMoneo;
	}

	public void setNoCarteMoneo(String pNCM) {
		this.noCarteMoneo = pNCM;
	}
}
