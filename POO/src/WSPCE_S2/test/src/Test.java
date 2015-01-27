import java.util.LinkedList;

 class Test {

	public static void main(String argv[])  {
		
		System.out.println(10/0);
		Compte c1, c2;
		Compte tabC [];
		Compte indexTabC [];
		int i, j;
		
		c1 = new Compte ("01", "César");
		c2 = new Compte ("02", "Brutus", 100, 200);
		
		c1.deposer (100);
		c2.retirer (50);
		
		c1.afficher();
		c2.afficher();
		System.out.println();
		
		tabC = new Compte [5];
		tabC[0] = c1;
		tabC[1] = c2;
		tabC[2] = new Compte ("03", "Astérix");
		tabC[3] = new Compte ("04", "Obélix");
		tabC[4] = new Compte ("05", "Idéfix");
		
		for (i=0; i<tabC.length-1; i++) {
			for (j=i+1; j<tabC.length; j++) {
				if (tabC[i].getProprietaire().compareTo(tabC[j].getProprietaire()) > 0) {
					c1 = tabC[i];   tabC[i] = tabC[j];  tabC[j] = c1;
				}
			}
		}
		for (i=0; i<tabC.length; i++) {
			tabC[i].afficher();
		}
		System.out.println();
		
		indexTabC = new Compte[5];
		for (i=0; i<tabC.length; i++) {
			indexTabC[i] = tabC[i];
		}
		for (i=0; i<indexTabC.length-1; i++) {
			for (j=i+1; j<indexTabC.length; j++) {
				if (indexTabC[i].getNumCompte().compareTo(indexTabC[j].getNumCompte()) > 0) {
					c1 = indexTabC[i];   indexTabC[i] = indexTabC[j];  indexTabC[j] = c1;
				}
			}
		}
		for (i=0; i<tabC.length; i++) {
			indexTabC[i].afficher();
		}
		System.out.println();
		
		int index2[] = new int[5];
		int temp;
		for (i=0; i<tabC.length; i++) {
			index2[i] = i;
		}
		for (i=0; i<index2.length-1; i++) {
			for (j=i+1; j<index2.length; j++) {
				if (tabC[index2[i]].getNumCompte().compareTo(tabC[index2[j]].getNumCompte()) > 0) {
					temp = index2[i];   index2[i] = index2[j];  index2[j] = temp;
				}
			}
		}
		for (i=0; i<tabC.length; i++) {
			tabC[index2[i]].afficher();
		}
		System.out.println();
	}
}

class PileLL {
	  /*
	    Enregistrement
	  */
	  private LinkedList<String> pile ;

	  /*
	    Opérations
	  */
	  boolean estVide() { return(pile.size() == 0); }

	  PileLL empiler(String element) throws Exception {
	    pile.addFirst(element) ;
	    return(this);
	  }

	  PileLL depiler() throws Exception {
	    pile.removeFirst() ;
	    return(this);
	  }

	  String sommet() throws Exception {
	    return pile.getFirst();
	  }

	  /*
	    Opérations supplémentaires
	  */
	  public String toString(){
	    String resultat = "";
	    Object[] elements = pile.toArray();
	    for (int i = 0; i < elements.length; i=i + 1){ resultat += "|"+elements[i] ; }
	    if (elements.length==0) resultat += "|vide" ;
	    return(resultat);
	  }

	  int nbElements(){
	    return(pile.size());
	  }

	  /*
	    Constructeurs
	  */
	  PileLL(){
	    pile = new LinkedList<String>();
	  }

	} // fin class

