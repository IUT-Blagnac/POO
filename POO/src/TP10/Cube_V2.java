
public class Cube_V2 extends Carre {
	public Cube() {
		super();
	}
	public Cube(int pfX, int pfY, int pfCote) {
		super(pfX, pfY, pfCote);
	}
	public double surface () {
		return 5*super.surface();
	}
	public double volume () {
		return this.getCote()*super.surface();
	}
	public void afficher() {
		super.afficher();
		System.out.println("Cube");
	}
}
