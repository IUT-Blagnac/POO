



public class Outils {  

	/* On voudrait pouvoir passer en paramètre pour d
	 *	autant un Compte qu'une Voiture ...
	 *	... ou qu'un autre objet ultérieurement (Personne, Banque, ...) ...
	 */
		 
	public static void testAffichage ( Displayable d) {
		d.displayObject();
	}

	public static void testAffichageTableau ( Displayable td[]) {
		System.out.println ("Aff tab : " + td.getClass());
		for (int i =0; i<td.length; i++) {	
			System.out.print ("--->");
			td[i].displayObject();
		}
	}
		
}
