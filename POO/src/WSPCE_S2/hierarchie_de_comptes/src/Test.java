
public class Test {
	public static void main(String argv[]) {
		Test.main1TestComptes();
		Test.main2TestComptes();
	}

	public static void main1TestComptes() {
		
		System.out.println("Partie 1");

		// Premiers essais

		Compte c;

		// Appliquer la m�thode afficher � c. Que se passe-t-il ?
		// c.afficher (); // Erreur, c non initialis�e

		// Cr�er un Compte � l'aide de c.
		c = new Compte("010101", "Lepoisson Benoit");

		// Utiliser les m�thodes disponibles sur la classe Compte
		// (Modifieurs, Observateurs).
		c.afficher();
		System.out.println("  Solde : " + c.soldeCompte());

		try {
			c.deposer(2000);
			c.retirer(3000);
		} catch (CompteException e) {
			System.out.println(e);
		}
		c.setProprietaire("Test");
		c.afficher();
		System.out.println("  Solde : " + c.soldeCompte());
		
		// Essayer de retirer -100 euros du compte c. Que se passe-t-il ?
		// -> Exception
		try {
			c.retirer(-100);
		} catch (CompteException e) {
			System.out.println(e);
		}
		
		// Essayer de d�poser -100 euros du compte c. Que se passe-t-il ?
		// -> Exception
		try {
			c.deposer(-100);
		} catch (CompteException e) {
			System.out.println(e);
		}
		
		// Essayer l'instruction : System.out.println(c); Quel est le
		// r�sultat ?
		System.out.println(c); // Affiche c.toString() 
		
		System.out.println(System.identityHashCode(c));

		// Affecter � c la valeur null.
		c = null;

		System.out.println(System.identityHashCode(c)); // Affiche : 0
		System.out.println(c); // Affiche : null

		// Appliquer la m�thode afficher � c. Que se passe-t-il ?
		// c.afficher (); //
		// "Exception in thread "main" java.lang.NullPointerException"
	}
	
	public static void main2TestComptes() {
		
		System.out.println("Partie 2");

		// R�f�rences d'objets suite

		try {
			// 1) 1) D�clarer deux variables cUn et cDeux "de type Compte" :
			// r�f�rences vers un Compte.
			// cf ci-dessus

			Compte cUn, cDeux;

			// 2) Cr�er un Compte � l'aide de cUn au nom de "Jean". Cr�er un
			// autre Compte � l'aide de cDeux au nom de "Marie".
			cUn = new Compte("3001", "Jean");
			cDeux = new Compte("3002", "Marie");

			// 3) Afficher cUn et cDeux.
			cUn.afficher();
			System.out.println("  Solde : " + cUn.soldeCompte());
			cDeux.afficher();
			System.out.println("  Solde : " + cDeux.soldeCompte());

			// 4) D�poser 1� sur cUn. D�poser 1000� sur cDeux.
			cUn.deposer(1);
			cDeux.deposer(1000);

			// 5) Afficher cUn et cDeux. Conclusion �
			System.out.println();
			System.out.println("Apres depot 1 et 1000");
			cUn.afficher();
			System.out.println("  Solde : " + cUn.soldeCompte());
			cDeux.afficher();
			System.out.println("  Solde : " + cDeux.soldeCompte());

			// 6) Retirer 1� de cUn. Retirer 1000� de cDeux.
			cUn.retirer(1);
			cDeux.retirer(1000);

			// 7) Afficher cUn et cDeux. Conclusion �
			System.out.println();
			System.out.println("Apres retrait 1 et 1000");
			cUn.afficher();
			System.out.println("  Solde : " + cUn.soldeCompte());
			cDeux.afficher();
			System.out.println("  Solde : " + cDeux.soldeCompte());
			// Deux objets vraiement diff�rents
			
			// 8) Affecter cUn � cDeux (cDeux = cUn;).
			cDeux = cUn;

			// 9) Afficher cUn et cDeux. Conclusion �
			System.out.println();
			System.out.println("Apres Affectation");
			cUn.afficher();
			System.out.println("  Solde : " + cUn.soldeCompte());
			cDeux.afficher();
			System.out.println("  Solde : " + cDeux.soldeCompte());
			// Ils r�f�rencent le meme objet
			
			// 10) D�poser 2000� sur le Compte ayant pour propri�taire Marie.
			// Conclusion �
			// Impossible, la r�f�rence est perdue ...

		} catch (CompteException e) {
			System.out.println(e);
		}
	}
}
