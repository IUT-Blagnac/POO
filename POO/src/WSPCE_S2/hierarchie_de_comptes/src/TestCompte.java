import junit.framework.TestCase;
import junit.framework.TestSuite;

/* Test de la classe Compte
 *
 * On supposera que les "méthodes"
 * 		constructeurs
 * 		retirer()
 *		deposer()
 *		setProprietaire()
 * 	"renvoient un objet Compte" afin de pouvoir écrire les 
 *  expressions ci-dessous.
 * 
 * En tant que TAD, il est possible de spécifier :
 *
 * Préconditions : 
 * 		deposer (c, m) valide => m >= 0
 * 		retirer (c, m) valide => m >= 0
 * 
 * soldeCompte (Compte()) == 0
 * getProprietaire (Compte()) == "Pas de propriétaire"
 * getNumCompte (Compte()) == "Pas de numéro"
 *
 * soldeCompte (Compte(nc, np)) == 0
 * getProprietaire (Compte(nc, np)) == np
 * getNumCompte (Compte(nc, np)) == nc
 * 
 * soldeCompte (Compte(nc, np, d, c)) == c - d
 * getProprietaire (Compte(nc, pn, d, c)) == np
 * getNumCompte (Compte(nc, np, d, c)) == nc
 * 
 * soldeCompte(deposer(c, m)) == soldeComte(c) + m
 * 
 * soldeCompte(retirer(c, m)) == soldeComte(c) - m
 * 
 * getProprietaire (setProprietaire(c, np)) == np 
 */

public class TestCompte extends TestCase {

	// Attributs locaux pour les tests.
	// A ne pas modifier
	private Compte cDef, cDeux;

	private final String pasDeNC = "Pas de numéro";
	private final String pasDeNP = "Pas de propriétaire";
	private final String np = "Durand";
	private final String nc = "010101";
	private final double cre = 1000;
	private final double deb = 1000;

	private void initCompte()  {
		this.cDef = new Compte();
		this.cDeux = new Compte(new String(this.nc), new String(this.np));
	}

	public void testCompteDefaut() {
		this.initCompte();
		/*
		 * soldeCompte (Compte()) == 0 getProprietaire (Compte()) ==
		 * "Pas de propriétaire" getNumCompte (Compte()) == "Pas de numéro"
		 */
		TestCase.assertEquals("PROBLEME Compte() : mauvais solde ...", 
				0.0, this.cDef.soldeCompte());
		TestCase.assertEquals("PROBLEME Compte() : mauvais propriétaire ...",
				this.pasDeNP, this.cDef.getProprietaire());
		TestCase.assertEquals(
				"PROBLEME Compte() : mauvais numéro de compte ...",
				this.pasDeNC, this.cDef.getNumCompte());
	}

	public void testCompte2Parametres() {
		this.initCompte();
		/*
		 * soldeCompte (Compte(nc, np)) == 0 getProprietaire (Compte(nc, np)) ==
		 * np getNumCompte (Compte(nc, np)) == nc
		 */
		TestCase.assertEquals("PROBLEME Compte(nc, np) : mauvais solde ...",
				0.0, this.cDeux.soldeCompte());
		TestCase.assertEquals(
				"PROBLEME Compte(nc, np) : mauvais propriétaire ...", 
				this.np, this.cDeux.getProprietaire());
		TestCase.assertEquals(
				"PROBLEME Compte(nc, np) : mauvais numéro de compte ...",
				this.nc, this.cDeux.getNumCompte());
	}

	public void testDeposer() {
		this.initCompte();
		// soldeCompte( deposer(c, m) ) == soldeComte(c) + m
		double soldeAvant = this.cDeux.soldeCompte();
		try {
			this.cDeux.deposer(this.cre);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME deposer() : on ne peut pas deposer " +this.cre + " sur un compte");
		}
		TestCase.assertEquals("PROBLEME deposer() : mauvais solde...",
				soldeAvant + 1000, this.cDeux.soldeCompte());
		try {
			this.cDeux.deposer(0);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME deposer() : on ne peut pas deposer 0 sur un compte");
		}
		try {
			this.cDeux.deposer(-1);
			TestCase.fail("PROBLEME deposer() : on peut deposer une somme négative (-1) un compte");
		} catch (CompteException e) {}
	}

	public void testRetirer() {
		this.initCompte();
		// soldeCompte( retirer(c, m) ) == soldeComte(c) - m
		double soldeAvant = this.cDeux.soldeCompte();
		try {
			this.cDeux.retirer(this.deb);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME retirer() : on ne peut pas retirer " + this.deb + " sur un compte");
		}
		TestCase.assertEquals("PROBLEME retirer() : mauvais solde...",
				soldeAvant - 1000, this.cDeux.soldeCompte());
		try {
			this.cDeux.retirer(0);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME retirer() : on ne peut pas retirer 0 sur un compte");
		}
		try {
			this.cDeux.retirer(-1);
			TestCase.fail("PROBLEME retirer() : on peut retirer une somme négative (-1) sur un compte");
		} catch (CompteException e) {}
	}

	public void testSetProprietaire() {
		this.initCompte();
		// getProprietaire (setProprietaire(c, np)) == np
		String nouvNom = "CORRIGE" + this.np + "CORRIGE";
		this.cDeux.setProprietaire(nouvNom);
		TestCase.assertEquals(
				"PROBLEME setProprietaire() : mauvaise modification ...",
				nouvNom, this.cDeux.getProprietaire());
	}

	public static void main(String argv[]) {
		TestSuite suite = new TestSuite("Tests complets");
		suite.addTestSuite(TestCompte.class);
		junit.textui.TestRunner.run(suite);
	}
}
