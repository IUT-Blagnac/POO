package RATT;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CelluleDC c1, c2, c3, debut;
		CelluleDC c ;
		
		c1 = new CelluleDC (10.5, null, null);
		c2 = new CelluleDC (20.5, null, null);
		c3 = new CelluleDC (30.5, null, null);
		c1.setSuivant(c2);
		c2.setPrecedent(c1);
		c2.setSuivant(c3);
		c3.setPrecedent(c2);
		
		debut=c1;
		
		c=c3;
		while (c!= null) {
			System.out.println(c.getContenu());
			c = c.getPrecedent();
		}

		c=debut;
		while (c!= null) {
			System.out.println(c.getContenu());
			c = c.getSuivant();
		}
	}

}
