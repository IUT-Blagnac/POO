public class Cercle extends FormeGraphique {
	private double rayon;
	
	public Cercle() {
		super();
		this.rayon = 0;
	}
	public Cercle (int pX, int pY, double pRayon) {
		super(pX, pY);
		this.rayon = pRayon;
	}
	public double getRayon() {
		return rayon;
	}
	public void setRayon(double pRayon) {
		this.rayon = pRayon;
	}
	public double surface() {
		return Math.PI * this.rayon * this.rayon;
	}
	public void afficher() { 
		super.afficher();
		System.out.println("Cercle : rayon " + this.rayon);
	}
}
