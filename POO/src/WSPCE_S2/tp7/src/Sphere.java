public class Sphere extends Cercle {
	
	public Sphere() {
		super();
	}

	public Sphere(int pX, int pY, double pRayon) 	{
		super(pX, pY, pRayon);
	}
	
	public double surface() 	{
		return 4*super.surface(); // <=>  4 * this.getRayon()*getRayon()*Math.PI;
	}
	//volume of sphere = (4/3)Pi*radius^3
	public double volume() 	{
		return (4.0/3)*super.surface()*this.getRayon();
		// <=>  4 * Math.PI * this.getRayon() * this.getRayon() * this.getRayon() / 3;
	}
	
	public void afficher() { 
		super.afficher();
		System.out.println("Sphere : rayon "+this.getRayon());
	}
}