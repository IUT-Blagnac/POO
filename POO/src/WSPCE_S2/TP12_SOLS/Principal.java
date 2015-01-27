



public class Principal { 
	public static void main ( String [] argv ) {
		/* On voudrait pouvoir passer en paramètre
		 *	à la méthode Outils.testAffichage ()
		 *	autant un Compte qu'une Voiture ...
		 */
		 
		Compte c;

		c = new Compte("0808", "Dupont");

		Outils.testAffichage (c);

		Vehicule  v;
		
		v = new Vehicule("0808", 2000);

		Outils.testAffichage (v);
		
		CompteDepot cd = new CompteDepot ("1212", "erer");
		try {
			cd.deposer (100);
			cd.deposer (100);
			cd.retirer (1000);
		} catch (CompteException e) {}

		
		Outils.testAffichage(cd);

		CompteSecurise cs = new CompteSecurise ("1212", "erer", 1000);
		try {
			cs.deposer (100);
			cs.deposer (100);
			cs.retirer (1000);
		} catch (CompteException e) {}
		
		Outils.testAffichage(cs);
		
		Personne p = new Personne ("Durand", 25);
		
		Outils.testAffichage(p);
		
		int  i;
		Compte [] tabComptes;
		Vehicule [] tabVehicules ;
		tabComptes = new Compte [5];
		for (i=0; i<tabComptes.length; i++)
			tabComptes[i] = new Compte ("No "+i, "Prop "+i);
		tabVehicules = new Vehicule [5];
		for (i=0; i<tabVehicules.length; i++)
			tabVehicules[i] = new Vehicule ("Immat "+i, i);
		
		Personne [] tabPersonnes;
		tabPersonnes = new Personne [5];
		for (i=0; i<tabPersonnes.length; i++)
			tabPersonnes[i] = new Personne ("Nom "+i, i*10);
			
		Outils.testAffichageTableau (tabComptes);
		Outils.testAffichageTableau (tabPersonnes);
		Outils.testAffichageTableau (tabVehicules);
	}
}
