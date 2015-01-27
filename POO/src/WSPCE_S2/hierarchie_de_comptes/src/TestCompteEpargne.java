import junit.framework.TestCase;
import junit.framework.TestSuite;

/* Test de la classe CompteEpargne
 *
 * Test simples : constructeurs, ajouterInterets(), interetsCompte(),  
 * ... et transformateurs (setters) hérités
 * 
 */

public class TestCompteEpargne extends TestCase {

	// Attributs locaux pour les tests.
	// A ne pas modifier
	private CompteEpargne cDef, cTrois;

	private final String pasDeNC = "Pas de numéro";
	private final String pasDeNP = "Pas de propriétaire";
	private final String np = "Durand";
	private final String nc = "010101";

	private final double cre = 2000;
	private final double deb = 1000;

	private final double taux = 5.0;

	private void initCompte() {
		this.cDef = new CompteEpargne();
		this.cTrois = new CompteEpargne(new String(this.nc),
				new String(this.np), this.taux);
	}

	public void testCompteSecuriseDefaut() {
		this.initCompte() ;
		// test constructeur par défaut
		TestCase.assertEquals("PROBLEME CompteEpargne() : mauvais taux d'intérêts ...",
				0.0, this.cDef.getTauxInterets());
		TestCase.assertEquals("PROBLEME CompteEpargne() : mauvais solde ...",
				0.0, this.cDef.soldeCompte());
		TestCase.assertEquals(
				"PROBLEME CompteEpargne() : mauvais calcul des intérêts ...",
				0.0, this.cDef.interetsCompte());
		this.cDef.ajouterInterets();
		TestCase.assertEquals(
				"PROBLEME CompteEpargne() : on peut verser des intérêts sur un compte à solde nul ...",
				0.0, this.cDef.soldeCompte());
		TestCase.assertEquals(
				"PROBLEME CompteEpargne() : mauvais propriétaire ...",
				this.pasDeNP, this.cDef.getProprietaire());
		TestCase.assertEquals(
				"PROBLEME CompteEpargne() : mauvais numéro de compte ...",
				this.pasDeNC, this.cDef.getNumCompte());
	}

	public void testCompteSecurise3Parametres() {
		this.initCompte() ;
		// test constructeur CompteEpargne (String pNumCompte, String pNomProp,
		// double pTxInterets)
		TestCase.assertEquals("PROBLEME CompteEpargne() : mauvais taux d'intérêts ...",
				this.taux, this.cTrois.getTauxInterets());
		TestCase.assertEquals(
				"PROBLEME CompteEpargne(nc, np, tx) : mauvais solde ...", 0.0,
				this.cTrois.soldeCompte());
		TestCase.assertEquals(
				"PROBLEME CompteEpargne(nc, np, tx) : mauvais calcul des intérêts ...",
				0.0, this.cTrois.interetsCompte());
		this.cDef.ajouterInterets();
		TestCase.assertEquals(
				"PROBLEME CompteEpargne(nc, np, tx) : on peut verser des intérêts sur un compte à solde nul ...",
				0.0, this.cTrois.soldeCompte());
		TestCase.assertEquals(
				"PROBLEME CompteEpargne(nc, np, tx) : mauvais propriétaire ...",
				this.np, this.cTrois.getProprietaire());
		TestCase.assertEquals(
				"PROBLEME CompteEpargne(nc, np, tx) : mauvais numéro de compte ...",
				this.nc, this.cTrois.getNumCompte());
	}

	public void testInteretsCompte()
			throws CompteException // Sur retraits et depts
	{
		this.initCompte() ;

		TestCase.assertEquals(
				"PROBLEME interetsCompte() : mauvais calcul des intérêts ...",
				0.0, this.cTrois.interetsCompte());

		this.cTrois.deposer(this.cre);
		TestCase.assertEquals(
				"PROBLEME interetsCompte() : mauvais calcul des intérêts ...",
				this.cre * this.taux / 100, this.cTrois.interetsCompte());

		this.cTrois.retirer(this.deb);
		TestCase.assertEquals(
				"PROBLEME interetsCompte() : mauvais calcul des intérêts ...",
				(this.cre - 1 * this.deb) * this.taux / 100,
				this.cTrois.interetsCompte());

		this.cTrois.retirer(this.deb);
		TestCase.assertEquals(
				"PROBLEME interetsCompte() : mauvais calcul des intérêts ...",
				(this.cre - 2 * this.deb) * this.taux / 100,
				this.cTrois.interetsCompte());
		TestCase.assertEquals(
				"PROBLEME interetsCompte() : mauvais calcul des intérêts ...",
				0.0, this.cTrois.interetsCompte());

		this.cTrois.retirer(this.deb);
		TestCase.assertEquals(
				"PROBLEME interetsCompte() : mauvais calcul des intérêts ...",
				0.0, this.cTrois.interetsCompte());
	}

	public void testAjouterInterets() 
			throws CompteException // Sur retraits et depts
	{
		this.initCompte() ;

		double soldeC;

		this.cTrois.ajouterInterets();
		TestCase.assertEquals(
				"PROBLEME ajouterInterets() : mauvais solde après dépôt des intérêts ...",
				0.0, this.cTrois.soldeCompte());

		this.cTrois.deposer(this.cre);
		soldeC = this.cTrois.soldeCompte();
		this.cTrois.ajouterInterets();
		TestCase.assertEquals(
				"PROBLEME ajouterInterets() : mauvais solde après dépôt des intérêts ...",
				soldeC + soldeC * this.taux / 100, this.cTrois.soldeCompte());

		this.cTrois.retirer(this.deb);
		soldeC = this.cTrois.soldeCompte();
		this.cTrois.ajouterInterets();
		TestCase.assertEquals(
				"PROBLEME ajouterInterets() : mauvais solde après dépôt des intérêts ...",
				soldeC + (soldeC * this.taux / 100), this.cTrois.soldeCompte());

		this.cTrois.retirer(this.deb);
		soldeC = this.cTrois.soldeCompte();
		this.cTrois.ajouterInterets();
		TestCase.assertEquals(
				"PROBLEME ajouterInterets() : mauvais solde après dépôt des intérêts ...",
				soldeC + (soldeC * this.taux / 100), this.cTrois.soldeCompte());

		this.cTrois.retirer(this.deb);
		soldeC = this.cTrois.soldeCompte();
		this.cTrois.ajouterInterets();
		TestCase.assertEquals(
				"PROBLEME ajouterInterets() : mauvais solde après dépôt des intérêts ...",
				soldeC, this.cTrois.soldeCompte());
	}

	public void testGetOperations()
			throws CompteException // Sur retraits et depts
	{
		this.initCompte() ;

		// un compte créé n'a pas d'opération.
		TestCase.assertNotNull("PROBLEME getOperations() : renvoie null ...",
				this.cTrois.getOperations());
		TestCase.assertEquals(
				"PROBLEME getOperations() : compte créé contient des opérations ...",
				0, this.cTrois.getOperations().length);

		this.cTrois.deposer(this.cre);

		TestCase.assertNotNull("PROBLEME getOperations() : renvoie null ...",
				this.cTrois.getOperations());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvaise taille tableau renvoyé ...",
				1, this.cTrois.getOperations().length);
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais montant suite à un dépot ...",
				this.cre, this.cTrois.getOperations()[0].getMontant());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais sens d'opération suite à un dépot ...",
				SensOperation.CREDIT, this.cTrois.getOperations()[0].getSens());

		this.cTrois.retirer(this.deb);

		TestCase.assertNotNull("PROBLEME getOperations() : renvoie null ...",
				this.cTrois.getOperations());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvaise taille tableau renvoyé ...",
				2, this.cTrois.getOperations().length);
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais montant suite à un dépot ...",
				this.cre, this.cTrois.getOperations()[0].getMontant());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais sens d'opération suite à un dépot ...",
				SensOperation.CREDIT, this.cTrois.getOperations()[0].getSens());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais montant suite à un retrait ...",
				this.deb, this.cTrois.getOperations()[1].getMontant());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais sens d'opération suite à un retrait ...",
				SensOperation.DEBIT, this.cTrois.getOperations()[1].getSens());

		this.cTrois.retirer(this.deb);
		this.cTrois.retirer(this.deb);
		this.cTrois.retirer(this.deb);

		TestCase.assertNotNull("PROBLEME getOperations() : renvoie null ...",
				this.cTrois.getOperations());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvaise taille tableau renvoyé ...",
				5, this.cTrois.getOperations().length);
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais montant suite à un retrait ...",
				this.deb, this.cTrois.getOperations()[4].getMontant());
		TestCase.assertEquals(
				"PROBLEME getOperations() : mauvais sens d'opération suite à un retrait ...",
				SensOperation.DEBIT, this.cTrois.getOperations()[4].getSens());
	}

	public void testpourVerifierFonctionnementMinimal() {
		this.initCompte() ;
		double soldeAvant;
		String nouvNom;

		// test deposer()
		soldeAvant = this.cTrois.soldeCompte();
		try {
			this.cTrois.deposer(this.cre);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME deposer() : on ne peut pas deposer " +this.cre + " sur un compte");
		}
		TestCase.assertEquals("PROBLEME deposer() : mauvais solde...",
				soldeAvant + this.cre, this.cTrois.soldeCompte());

		// test retirer()
		soldeAvant = this.cTrois.soldeCompte();
		try {
			this.cTrois.retirer(this.deb);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME retirer() : on ne peut pas retirer " + this.deb + " sur un compte");
		}
		TestCase.assertEquals("PROBLEME retirer() : mauvais solde...",
				soldeAvant - this.deb, this.cTrois.soldeCompte());

		// test retirer()
		soldeAvant = this.cTrois.soldeCompte();
		try {
			this.cTrois.retirer(this.deb);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME retirer() : on ne peut pas retirer " + this.deb + " sur un compte");
		}
		TestCase.assertEquals("PROBLEME retirer() : mauvais solde...",
				soldeAvant - this.deb, this.cTrois.soldeCompte());

		// test retirer()
		soldeAvant = this.cTrois.soldeCompte();
		try {
			this.cTrois.retirer(this.deb);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME retirer() : on ne peut pas retirer " + this.deb + " sur un compte");
		}
		TestCase.assertEquals("PROBLEME retirer() : mauvais solde...",
				soldeAvant - this.deb, this.cTrois.soldeCompte());

		// test setProprietaire
		nouvNom = "CORRIGE" + this.np + "CORRIGE";
		this.cTrois.setProprietaire(nouvNom);
		TestCase.assertEquals(
				"PROBLEME setProprietaire() : mauvaise modification ...",
				nouvNom, this.cTrois.getProprietaire());
		
		// test limites deposer/retirer
		try {
			this.cTrois.deposer(0);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME deposer() : on ne peut pas deposer 0 sur un compte");
		}
		try {
			this.cTrois.deposer(-1);
			TestCase.fail("PROBLEME deposer() : on peut deposer une somme négative (-1) un compte");
		} catch (CompteException e) {}
		try {
			this.cTrois.retirer(0);
		} catch (CompteException e) {
			TestCase.fail("PROBLEME retirer() : on ne peut pas retirer 0 sur un compte");
		}
		try {
			this.cTrois.retirer(-1);
			TestCase.fail("PROBLEME retirer() : on peut retirer une somme négative (-1) sur un compte");
		} catch (CompteException e) {}
	}

	public static void main(String argv[]) {
		TestSuite suite = new TestSuite("Tests complets");
		suite.addTestSuite(TestCompteEpargne.class);
		junit.textui.TestRunner.run(suite);
	}
}
