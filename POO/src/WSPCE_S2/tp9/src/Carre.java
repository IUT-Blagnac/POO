public class Carre extends Rectangle {

	public Carre() {
		super();
	}
	public Carre(int pX, int pY, int pCote) {
		super(pX, pY, pCote, pCote);
	}
	public int getCote () {
		return this.getLongueur();
	}
	public void afficher() {
		super.afficher();
		System.out.println("Carré : côté "+this.getLongueur());
	}
}