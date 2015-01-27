import junit.framework.TestCase;
import junit.framework.TestSuite;

/* Test de la classe CompteMoneo
 *
 * Test simples : constructeurs, setNoCarteMoneo() 
 * ... et transformateurs (setters) hérités
 * 
 */

public class TestCompteMoneo extends TestCase {

	// Attributs locaux pour les tests.
	// A ne pas modifier
	
	private CompteMoneo cDef, cUn, cDeux;

	private final String pasDeNC = "Pas de numéro";
	private final String pasDeNP = "Pas de propriétaire";
	private final String pasDeNumMoneo = "Pas de numéro monéo";
	private final String np = "Durand";
	private final String nc = "010101";
	private final String nm = "NM989898";

	private final double cre = 2000;
	private final double deb = 1000;
	
	private void initCompte()  {
		this.cDef = new CompteMoneo();
		this.cUn = new CompteMoneo(new String(this.nm));
		this.cDeux = new CompteMoneo(new String(this.nc), new String(this.np),
				new String(this.nm));
	}

	public void testCompteMoneoDefaut() {
		this.initCompte();
		// test constructeur par défaut
		TestCase.assertEquals(
				"PROBLEME CompteMoneo() : mauvais numéro Monéo ...",
				this.pasDeNumMoneo, this.cDef.getNoCarteMoneo());
		TestCase.assertEquals("PROBLEME CompteMoneo() : mauvais solde ...",
				0.0, this.cDef.soldeCompte());
		TestCase.assertEquals(
				"PROBLEME CompteMoneo() : mauvais propriétaire ...",
				this.pasDeNP, this.cDef.getProprietaire());
		TestCase.assertEquals(
				"PROBLEME CompteMoneo() : mauvais numéro de compte ...",
				this.pasDeNC, this.cDef.getNumCompte());
	}

	public void testCompteMoneo1Parametres() {
		this.initCompte();
		// test constructeur CompteMoneo (String pNoCarteMoneo)
		TestCase.assertEquals(
				"PROBLEME CompteMoneo(ncm) : mauvais numéro Monéo ...",
				this.nm, this.cUn.getNoCarteMoneo());
		TestCase.assertEquals("PROBLEME CompteMoneo(ncm) : mauvais solde ...",
				0.0, this.cUn.soldeCompte());
		TestCase.assertEquals(
				"PROBLEME CompteMoneo(ncm) : mauvais propriétaire ...",
				this.pasDeNP, this.cUn.getProprietaire());
		TestCase.assertEquals(
				"PROBLEME CompteMoneo(ncm) : mauvais numéro de compte ...",
				this.pasDeNC, this.cUn.getNumCompte());
	}

	public void testCompteMoneo2Parametres() {
		this.initCompte();
		// test constructeur CompteMoneo (String pNumCompte, String pNomProp,
		// String pNoCarteMoneo)
		TestCase.assertEquals(
				"PROBLEME CompteMoneo(nc, np, ncm) : mauvais numéro Monéo ...",
				this.nm, this.cDeux.getNoCarteMoneo());
		TestCase.assertEquals(
				"PROBLEME CompteMoneo(nc, np, ncm) : mauvais solde ...", 0.0,
				this.cDeux.soldeCompte());
		TestCase.assertEquals(
				"PROBLEME CompteMoneo(nc, np, ncm) : mauvais propriétaire ...",
				this.np, this.cDeux.getProprietaire());
		TestCase.assertEquals(
				"PROBLEME CompteMoneo(nc, np, ncm) : mauvais numéro de compte ...",
				this.nc, this.cDeux.getNumCompte());
	}

	public void testSetNoCarteMoneo() {
		this.initCompte();
		// tests setNoCarteMoneo (String pNCM)
		String nouvCarte = "CORRIGE" + this.nm + "CORRIGE";

		this.cDeux.setNoCarteMoneo(nouvCarte);
		TestCase.assertEquals("PROBLEME setNoCarteMoneo() : mauvais solde...",
				nouvCarte, this.cDeux.getNoCarteMoneo());
	}

	public void testpourVerifierFonctionnementMinimal() {
		this.initCompte() ;
		double soldeAvant;
		String nouvNom;

		// test deposer()
		soldeAvant = this.cDeux.soldeCompte();
		try {
			this.cDeux.deposer(this.cre);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME deposer() : on ne peut pas deposer " +this.cre + " sur un compte");
		}
		TestCase.assertEquals("PROBLEME deposer() : mauvais solde...",
				soldeAvant + this.cre, this.cDeux.soldeCompte());

		// test retirer()
		soldeAvant = this.cDeux.soldeCompte();
		try {
			this.cDeux.retirer(this.deb);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME retirer() : on ne peut pas retirer " + this.deb + " sur un compte");
		}
		TestCase.assertEquals("PROBLEME retirer() : mauvais solde...",
				soldeAvant - this.deb, this.cDeux.soldeCompte());

		// test retirer()
		soldeAvant = this.cDeux.soldeCompte();
		try {
			this.cDeux.retirer(this.deb);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME retirer() : on ne peut pas retirer " + this.deb + " sur un compte");
		}
		TestCase.assertEquals("PROBLEME retirer() : mauvais solde...",
				soldeAvant - this.deb, this.cDeux.soldeCompte());

		// test retirer()
		soldeAvant = this.cDeux.soldeCompte();
		try {
			this.cDeux.retirer(this.deb);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME retirer() : on ne peut pas retirer " + this.deb + " sur un compte");
		}
		TestCase.assertEquals("PROBLEME retirer() : mauvais solde...",
				soldeAvant - this.deb, this.cDeux.soldeCompte());

		// test setProprietaire
		nouvNom = "CORRIGE" + this.np + "CORRIGE";
		this.cDeux.setProprietaire(nouvNom);
		TestCase.assertEquals(
				"PROBLEME setProprietaire() : mauvaise modification ...",
				nouvNom, this.cDeux.getProprietaire());
		
		// test limites deposer/retirer
		try {
			this.cDeux.deposer(0);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME deposer() : on ne peut pas deposer 0 sur un compte");
		}
		try {
			this.cDeux.deposer(-1);
			TestCase.fail("PROBLEME deposer() : on peut deposer une somme négative (-1) un compte");
		} catch (CompteException e) {}
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

	public static void main(String argv[]) {
		TestSuite suite = new TestSuite("Tests complets");
		suite.addTestSuite(TestCompteMoneo.class);
		junit.textui.TestRunner.run(suite);
	}
}
