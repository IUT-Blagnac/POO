public class Vehicule {
	// Attributs :
	
	private String immatriculation;
	private int puissance ;
	private int distParcourue ;
	private double consommation ;

	// Constructeurs
	
	public Vehicule () 	{
		this ("",0); // Appel de Vehicule (String pImmat, int pPuiss)
	}

	public Vehicule (String pImmat, int pPuiss) {
		super (); // Optionnel car Implicite
				// Mais "ne mange pas de pain..."
		this.immatriculation = pImmat;
		this.puissance = pPuiss;
		this.distParcourue = 0;
		this.consommation = 0;
	}

	// Observateurs
	
	public String getImmat () {
		return this.immatriculation ;
	}
	
	public int getPuissance () {
		return this.puissance ;
	}
	
	public int getKilometrage () {
		return this.distParcourue ;
	}
	
	public double coutTotal ()  {
		return this.distParcourue * this.consommation / 100;
	}
		
	public double coutSuppl () {
		return 0;
	}

	// Modifieurs

	public void rouler (int pKm) {
		this.distParcourue = this.distParcourue + pKm;
	}
		
	public void setConso (double pConso) {
		this.consommation = pConso;
	}

	public void setPuissance (int pPuiss) {
		this.puissance = pPuiss;
	}
	
	public void setImmat (String pImmat) {
		this.immatriculation = pImmat;
	}

	// Special TP

	public void afficher () {
		System.out.println (
			  "Imm "   + this.immatriculation + " "
		    + "Puis "  + this.puissance + " "
			+ "Km "    + this.distParcourue + " "
			+ "Conso " + this.consommation);
	}
}
