
public class Rectangle extends FormeGraphique {
	private int largeur ;
	private int longueur ;

	public Rectangle() {
		super();
		this.largeur = 0 ;
		this.longueur = 0 ;
	}
	public Rectangle(int pX, int pY, int pLarg, int pLong) {
		super(pX, pY);
		this.largeur = pLarg ;
		this.longueur = pLong ;
	}
	
	public int getLargeur() {
		return this.largeur ;
	}
	public int getLongueur() {
		return this.longueur ;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public double surface() {
		return this.longueur * this.largeur ;
	}
	public void afficher() {
		super.afficher();
		System.out.println("Rectangle : hauteur " + this.longueur + " largeur " + this.largeur);
	}
}