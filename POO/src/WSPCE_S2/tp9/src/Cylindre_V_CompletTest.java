public class Cylindresdsd extends Cercle {

	private double hauteur;
	
	public Cylindre() {
		super();
		this.hauteur = 0;
	}
	public Cylindre(int pX, int pY, double pRayon, double pHauteur) {
		super(pX, pY, pRayon);
		this.hauteur = pHauteur;
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur (double pHauteur) {
		hauteur = pHauteur;
	}

	public double surface() {
		return this.surfaceCylindreSeul() +
				+ 2 * Math.PI * this.getRayon() * this.getRayon();
	}

	public double volume() {
		return Math.PI * this.getRayon() * this.getRayon() * this.hauteur;
	}
	
	public void afficher() { 
		super.afficher();
		System.out.println("Cylindre : hauteur " + this.hauteur);
	}
	
	public double surfaceCylindreSeul () {
		return 2 * Math.PI * this.getRayon() * this.hauteur; 
	}
}