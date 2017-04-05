
public class Cube_V1 extends Carre {
	public Cube() {
		super();
	}
	public Cube(int pfX, int pfY, int pfCote) {
		super(pfX, pfY, pfCote);
	}
	public double surface () {
		return 6*super.surface();
	}
	public double volume () {
		return this.getCote()*this.getCote();
	}
	public void afficher() {
		super.afficher();
		System.out.println("Cube");
	}
}
