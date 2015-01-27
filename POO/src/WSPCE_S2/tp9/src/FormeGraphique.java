public class FormeGraphique {
	private int origine_x ;
	private int origine_y ;
	
	public FormeGraphique() {
		this.origine_x = 0 ;
		this.origine_y = 0 ;
	}
	public FormeGraphique(int pX, int pY) {
		this.origine_x = pX ;
		this.origine_y = pY ;
	}
	public int getOrigineX() {
		return this.origine_x ;
	}
	public int getOrigineY() {
		return this.origine_y ;
	}
	public void setOrigineX(int pX) {
		this.origine_x = pX ;
	}
	public void setOrigineY(int pY) {
		this.origine_y = pY ;
	}
	public double surface() { // aussi appelé aire pour les figures planes
		return 0; 
	}
	public double volume() { 
		return 0; 
	}
	public void afficher() { 
		System.out.println("Forme graphique : abscisse " 
			+ this.origine_x 
			+ " ordonnée " 
			+ this.origine_y);
	}
}