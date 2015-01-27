import tps.banque.Compte;
import tps.banque.exception.CompteException;
import tps.utils.Keyboard;

public class ClasseEssaiCompteAMoi {
	public static void main(String argv[]) {
		
		Compte cUn, cDeux;

		// Déclarer deux variables cUn et cDeux "de type Compte" :
		// références vers un Compte.
		// cf ci-dessus
		
		// cUn.afficher(); // Pb d'initialisation
		
		// Créer un Compte à l'aide de cUn au nom de "Jean". Créer un
		// autre Compte à l'aide de cDeux au nom de "Marie".
		cUn = new Compte("3001", "Jean");
		cDeux = new Compte("9992", "Marie");

		// Afficher cUn et cDeux.
		cUn.afficher();
		System.out.println("  Solde : " + cUn.soldeCompte());
		cDeux.afficher();
		System.out.println("  Solde : " + cDeux.soldeCompte());

		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));

		System.out.println(cUn); // toString()
		
		// Déposer 1€ sur cUn. Déposer 1000€ sur cDeux.
		try {
			cUn.deposer(1);
			cDeux.deposer(1000);
		} catch (CompteException e) {
			System.out.println(e);
		}

		// Afficher cUn et cDeux. Conclusion …
		System.out.println();
		System.out.println("Apres depot 1 et 1000");
		cUn.afficher();
		System.out.println("  Solde : " + cUn.soldeCompte());
		cDeux.afficher();
		System.out.println("  Solde : " + cDeux.soldeCompte());

		// Retirer 1€ de cUn. Retirer 1000€ de cDeux.
		try {
			cUn.retirer(1);
			cDeux.retirer(1000);
		} catch (CompteException e) {
			System.out.println(e);
		}

		// Afficher cUn et cDeux. Conclusion …
		System.out.println();
		System.out.println("Apres retrait 1 et 1000");
		cUn.afficher();
		System.out.println("  Solde : " + cUn.soldeCompte());
		cDeux.afficher();
		System.out.println("  Solde : " + cDeux.soldeCompte());
		// Deux objets vraiement différents
		
		// Essayer de retirer -100 euros du compte cUn. Que se passe-t-il ?
		// -> Exception
		try {
			cUn.retirer(-100);
		} catch (CompteException e) {
			System.out.println(e);
		}
		
		// Essayer de déposer -100 euros sur le compte cDeux. Que se passe-t-il ?
		// -> Exception
		try {
			cDeux.deposer(-100);
		} catch (CompteException e) {
			System.out.println(e);
		}
		
		// Affecter cUn à cDeux (cDeux = cUn;).
		cDeux = cUn;

		// Afficher cUn et cDeux. Conclusion …
		System.out.println();
		System.out.println("Apres Affectation");
		cUn.afficher();
		System.out.println("  Solde : " + cUn.soldeCompte());
		cDeux.afficher();
		System.out.println("  Solde : " + cDeux.soldeCompte());
		// Ils référencent le meme objet
		
		try {
			cUn.deposer(1000);
		} catch (CompteException e) {
			System.out.println(e);
		}
		
		System.out.println();
		System.out.println("Apres Affectation");
		cUn.afficher();
		System.out.println("  Solde : " + cUn.soldeCompte());
		cDeux.afficher();
		System.out.println("  Solde : " + cDeux.soldeCompte());
		// Ils référencent le meme objet
		
		// Déposer 2000€ sur le Compte ayant pour propriétaire Marie.
		// Conclusion …
		// Impossible, la référence est perdue ...
		
		// Affecter à cUn la valeur null. 
		cUn = null;
		System.out.println(cUn); // null
		cUn.afficher();
	}
}
