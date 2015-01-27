import junit.framework.TestCase;
import junit.framework.TestSuite;

/* Test de la classe CompteJeune
 *
 * Test simples : constructeurs 
 * ... et transformateurs (setters) hérités
 * 
 */

public class TestCompteJeune extends TestCase {

	// Attributs locaux pour les tests.
	// A ne pas modifier
	private CompteJeune cDef, cDeux;

	private final String pasDeNC = "Pas de numéro";
	private final String pasDeNP = "Pas de propriétaire";
	private final String np = "Durand";
	private final String nc = "010101";

	private final double cre = 2000.0;
	private final double deb = 1000.0;

	private final double retrait = 1000.0;

	private void initCompte() {
		this.cDef = new CompteJeune();
		this.cDeux = new CompteJeune(new String(this.nc), new String(this.np));
	}

	public void testCompteJeuneDefaut() {
		this.initCompte();
		// test constructeur par défaut
		TestCase.assertEquals("PROBLEME CompteJeune() : mauvais solde ...",
				0.0, this.cDef.soldeCompte());
		TestCase.assertEquals(
				"PROBLEME CompteJeune() : mauvais propriétaire ...",
				this.pasDeNP, this.cDef.getProprietaire());
		TestCase.assertEquals(
				"PROBLEME CompteJeune() : mauvais numéro de compte ...",
				this.pasDeNC, this.cDef.getNumCompte());
	}

	public void testCompteJeune2Parametres() {
		this.initCompte();
		// test constructeur CompteJeune (String pNumCompte, String pNomProp)
		TestCase.assertEquals(
				"PROBLEME CompteJeune(nc, np) : mauvais solde ...", 0.0,
				this.cDeux.soldeCompte());
		TestCase.assertEquals(
				"PROBLEME CompteJeune(nc, np) : mauvais propriétaire ...",
				this.np, this.cDeux.getProprietaire());
		TestCase.assertEquals(
				"PROBLEME CompteJeune(nc, np) : mauvais numéro de compte ...",
				this.nc, this.cDeux.getNumCompte());
	}

	public void testIsRetraitPossibleTest1() 
			throws CompteException // Sur retraits et depts
	{
		this.initCompte();
		TestCase.assertFalse(
				"PROBLEME isRetraitPossible () : retrait accepté lorsque impossible ...",
				this.cDeux.isRetraitPossible(this.retrait));
		this.cDeux.deposer(this.cre);
		TestCase.assertTrue(
				"PROBLEME isRetraitPossible () : retrait refusé lorsque possible ...",
				this.cDeux.isRetraitPossible(this.retrait));
		this.cDeux.retirer(this.deb);
		TestCase.assertTrue(
				"PROBLEME isRetraitPossible () : retrait refusé lorsque possible ...",
				this.cDeux.isRetraitPossible(this.retrait));
		this.cDeux.retirer(this.deb);
		TestCase.assertFalse(
				"PROBLEME isRetraitPossible () : retrait accepté lorsque impossible ...",
				this.cDeux.isRetraitPossible(this.retrait));
		this.cDeux.deposer(this.cre);
		this.cDeux.retirer(this.deb);
		this.cDeux.retirer(this.deb);
		this.cDeux.deposer(this.retrait);
		TestCase.assertTrue(
				"PROBLEME isRetraitPossible () : retrait refusé lorsque possible ...",
				this.cDeux.isRetraitPossible(this.retrait));
		this.cDeux.retirer(this.retrait);
		this.cDeux.deposer(this.cre);
		this.cDeux.retirer(this.deb);
		this.cDeux.retirer(this.deb / 2);
		TestCase.assertFalse(
				"PROBLEME isRetraitPossible () : retrait accepté lorsque impossible ...",
				this.cDeux.isRetraitPossible(this.retrait));
	}
	
	public void testGetOperations()
			throws CompteException // Sur retraits et depts
	{
		this.initCompte() ;

		// un compte créé n'a pas d'opération.
		TestCase.assertNotNull("PROBLEME getOperations() : renvoie null ...",
				this.cDeux.getOperations());
		TestCase.assertEquals(
				"PROBLEME getOperations() : compte créé contient des opérations ...",
				0, this.cDeux.getOperations().length);

		this.cDeux.deposer(this.cre);

		TestCase.assertNotNull("PROBLEME getOperations() : renvoie null ...",
				this.cDeux.getOperations());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvaise taille tableau renvoyé ...",
				1, this.cDeux.getOperations().length);
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais montant suite à un dépot ...",
				this.cre, this.cDeux.getOperations()[0].getMontant());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais sens d'opération suite à un dépot ...",
				SensOperation.CREDIT, this.cDeux.getOperations()[0].getSens());

		this.cDeux.retirer(this.deb);

		TestCase.assertNotNull("PROBLEME getOperations() : renvoie null ...",
				this.cDeux.getOperations());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvaise taille tableau renvoyé ...",
				2, this.cDeux.getOperations().length);
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais montant suite à un dépot ...",
				this.cre, this.cDeux.getOperations()[0].getMontant());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais sens d'opération suite à un dépot ...",
				SensOperation.CREDIT, this.cDeux.getOperations()[0].getSens());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais montant suite à un retrait ...",
				this.deb, this.cDeux.getOperations()[1].getMontant());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais sens d'opération suite à un retrait ...",
				SensOperation.DEBIT, this.cDeux.getOperations()[1].getSens());

		this.cDeux.deposer(this.cre);
		this.cDeux.retirer(this.deb);
		this.cDeux.retirer(this.deb);
		this.cDeux.retirer(this.deb);

		TestCase.assertNotNull("PROBLEME getOperations() : renvoie null ...",
				this.cDeux.getOperations());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvaise taille tableau renvoyé ...",
				6, this.cDeux.getOperations().length);
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais montant suite à un retrait ...",
				this.deb, this.cDeux.getOperations()[4].getMontant());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais sens d'opération suite à un retrait ...",
				SensOperation.DEBIT, this.cDeux.getOperations()[4].getSens());	
	}

	public void testpourVerifierFonctionnementMinimal() {
		this.initCompte();
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
		suite.addTestSuite(TestCompteJeune.class);
		junit.textui.TestRunner.run(suite);
	}
}
