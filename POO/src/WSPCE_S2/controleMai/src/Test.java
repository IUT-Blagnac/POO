
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Cellule c1, c2, c3, debutL;
		Cellule [] tab;
		Cellule c ;
		int i;
		
		c1 = new Cellule (10.5, null);
		c2 = new Cellule (20.5, null);
		c3 = new Cellule (30.5, null);
		c1.setSuivant(c2);
		c2.setSuivant(c3);
		debutL=c1;
		
		tab = new Cellule [4];

		tab[0] = c3;
		tab[1] = c2;
		tab[2] = c1;
		tab[3] = new Cellule (40.5, null);
		
		// ICI POUR QUESTION
		
		c=debutL;
		while (c!= null) {
			System.out.println(c.getContenu());
			c = c.getSuivant();
		}
		for (i=0; i<4; i++) {
			System.out.println(tab[i].getContenu());
		}
			
	}

}
