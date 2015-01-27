
import junit.framework.TestCase;
import junit.framework.TestSuite;

/* Test de la classe Banque
 *
 * On supposera que les fonctions
 *        constructeurs
 *         addCompte()
 *         removeCompte()
 *     "renvoient un objet Banque" afin de pouvoir écrire les
 *  expressions ci-dessous.
 *
 * L'approche TAD est assez compliquée (cf. fin du fichier)
 * 
 * Les tests porteront sur :
 * 
 * Constructeur :
 * getNomBanque( Banque( nomB, locB) ) == nomB
 * getLocBanque( Banque( nomB, locB) ) == locB
 * getNbComptes( Banque( nomB, locB) ) == 0
 * getCompte( Banque( nomB, locB), numCpteQuelconque ) == null
 * length( getComptesDe( Banque( nomB, locB), nomProp )) == 0
 *
 * addCompte() :
 * getNomBanque( adCompte (b, c)) == getNomBanque(b)
 * getLocBanque( addCompte (b, c)) == getLocBanque(b)
 * addCompte (b, c) ==
 *         Si c == null
 *         Alors false
 *         Sinon
 *             Si getCompte(b, getNumCompte(c)) != null
 *             Alors false
 *             Sinon true
 *
 * removeCompte() :
 * getNomBanque( removeCompte (b, nc)) == getNomBanque(b)
 * getLocBanque( removeCompte (b, nc)) == getLocBanque(b)
 * removeCompte (b, nc) ==
 *         Si getCompte(b, getNumCompte(c)) == null
 *         Alors false
 *         Sinon true
 *
 * getNbComptes() : le nombre de Compte renvoyés par getNbComptes()
 *
 * getCompte() : un compte absent donc non trouvé ou présent donc trouvé
 *
 * getComptesDe() : les comptes sont trouvés si propriétaire présent, sinon non
 *
 * Les tests seront faits sur :
 * - Banque vide
 * - Banque après des ajouts de comptes
 * - Banque après des ajouts et des retraits de comptes
 * - Banque après des ajouts et retrait de tous les comptes (banque "vide")
 */

public class VInitTestBanque extends TestCase {

    // Attributs locaux pour les tests.
    // A ne pas modifier

    private Banque b; // La banque testée
    private Compte c1, c2, c3, c4; // 3 comptes différents (num compte différents)
    private Compte c1TestProp, c2TestProp, c3TestProp; // 3 comptes meme proprio
    private final String nom = "Banque Test";
    private final String loc = "Localisation Banque Test";

    private final String numC1 = "11Exist";
    private final String propC1 = "11propExist";
    private final String numC2 = "22Exist";
    private final String propC2 = "22propExist";
    private final String numC3 = "33Exist";
    private final String propC3 = "33propExist";
    private final String numC4 = "44Exist";
    private final String propC4 = "44propExist";

    private final String numTC1prop = "55AmemeProp";
    private final String numTC2prop = "55BmemeProp";
    private final String numTC3prop = "55CmemeProp";
    private final String propTprop = "55MEMEPROPRIETAIRE";

    private final String numInexistant = "88Inexist"; // numéro sans compte
    private final String propInexistant = "88propInExist"; // propriétaire sans compte

    // Nombre d'ajouts de compte max pour remplissages
    // Nombre de valeurs dans initialisation de tabCptesTests
    private final int MAX_CPTS_TESTS = 20;
    // Comptes de tests
    private final Compte[] tabCptesTests = {
            new Compte ("99a", "99"), new Compte ("99b", "99"), new Compte ("99c", "99"), new Compte ("99d", "99"),
            new Compte ("99e", "99"), new Compte ("99f", "99"), new Compte ("99g", "99"), new Compte ("99h", "99"),
            new Compte ("99i", "99"), new Compte ("99j", "99"),
            new Compte ("99k", "99"), new Compte ("99l", "99"), new Compte ("99m", "99"), new Compte ("99n", "99"),
            new Compte ("99o", "99"), new Compte ("99p", "99"), new Compte ("99q", "99"), new Compte ("99r", "99"),
            new Compte ("99s", "99"), new Compte ("99t", "99")
    };

    @Override
    protected void setUp() throws Exception {
        // On fait des "new String ()" à chaque fois
        // pour invlider des tests dans la Banque
        // du type : if (numC == autreNumC) ...
        this.b = new Banque(new String(this.nom), new String(this.loc));
        this.c1 = new Compte(new String(this.numC1), new String(this.propC1));
        this.c2 = new Compte(new String(this.numC2), new String(this.propC2));
        this.c3 = new Compte(new String(this.numC3), new String(this.propC3));
        this.c4 = new Compte(new String(this.numC4), new String(this.propC4));
        this.c1TestProp = new Compte(new String(this.numTC1prop), new String(this.propTprop));
        this.c2TestProp = new Compte(new String(this.numTC2prop), new String(this.propTprop));
        this.c3TestProp = new Compte(new String(this.numTC3prop), new String(this.propTprop));
    }

    @Override
    protected void tearDown() throws Exception {
        this.b = null;
        this.c1 = null; this.c2 = null; this.c3 = null; this.c4 = null;
        this.c1TestProp = null; this.c2TestProp = null; this.c3TestProp = null;
    }

    // Ajoute entre 0 et MAX_CPTS_TESTS comptes de tabCptesTests dans la Banque b
    private void ajoutsComptes(Banque b) {
        int i, jcpte;
        int nbAdd = (int) (Math.random() * this.MAX_CPTS_TESTS);
        for (i = 0; i < nbAdd; i++) {
            jcpte = (int) (Math.random() * this.MAX_CPTS_TESTS);
            b.addCompte(this.tabCptesTests[jcpte]);
        }
    }

    // Retire entre 0 et MAX_CPTS_TESTS comptes de tabCptesTests dans la Banque b
    private void retraitsComptes(Banque b) {
        int i, jcpte;
        int nbRem = (int) (Math.random() * this.MAX_CPTS_TESTS);
        for (i = 0; i < nbRem; i++) {
            jcpte = (int) (Math.random() * this.MAX_CPTS_TESTS);
            b.removeCompte(this.tabCptesTests[jcpte].getNumCompte());
        }
    }

    // Retire tous les comptes de tabCptesTests présents dans la Banque b
    private void retraitsTousLesComptes(Banque b) {
        int i;
        for (i = 0; i < this.MAX_CPTS_TESTS; i++) {
            b.removeCompte(this.tabCptesTests[i].getNumCompte());
        }
    }
    
	public void testBanque() {
        /*
         * getNomBanque( Banque( nomB, locB) ) == nomB
         * getLocBanque( Banque( nomB, locB) ) == locB
         * getNbComptes( Banque( nomB, locB) ) == 0
         * getCompte( Banque( nomB, locB), numCpteQuelconque ) == null
         * length( getComptesDe( Banque( nomB, locB), nomProp )) == 0
         */
		
        TestCase.assertEquals("PROBLEME Banque () : mauvais nom de banque ...",
                this.nom, this.b.getNomBanque());
        TestCase.assertEquals("PROBLEME Banque () : mauvaise localisation ...",
                this.loc, this.b.getLocBanque());
        TestCase.assertEquals("PROBLEME Banque () : mauvais nombre de comptes ...",
                0, this.b.getNbComptes());
        TestCase.assertNull("PROBLEME Banque () : un compte est trouvé dans une banque vide ...",
                this.b.getCompte(this.numInexistant));
        Compte[] t;
        t = this.b.getComptesDe(this.propInexistant);
        TestCase.assertEquals("PROBLEME Banque () : un proporétaire est trouvé dans une banque vide ...",
                0, t.length);
    }

    public void testAddCompte_1 () {
        /*
         * addCompte (b, c) ==
         *         Si c == null
         *         Alors false
         *         Sinon
         *             Si getCompte(b, getNumCompte(c)) != null
         *             Alors false
         *             Sinon true
         */
    	
    	// Test su Banque vide
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un objet Compte à null ...",
                this.b.addCompte(null));
        TestCase.assertTrue("PROBLEME addCompte() : on ne peut pas ajouter un compte nouveau dans la banque ...",
                this.b.addCompte(this.c1));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
                this.b.addCompte(this.c1));
    }

    public void testAddCompte_2 () {
        /*
         * addCompte (b, c) ==
         *         Si c == null
         *         Alors false
         *         Sinon
         *             Si getCompte(b, getNumCompte(c)) != null
         *             Alors false
         *             Sinon true
         */

        // Test sur Banque après des ajouts de comptes
        this.b.addCompte(this.c1);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c2);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c3);
        // Test début, milieu, fin
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un objet Compte à null ...",
                this.b.addCompte(null));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
        		this.b.addCompte(this.c1));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
        		this.b.addCompte(this.c2));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
        		this.b.addCompte(this.c3));
        TestCase.assertTrue("PROBLEME addCompte() : on ne peut pas ajouter un objet Compte inexistant ...",
        		this.b.addCompte(this.c4));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
                this.b.addCompte(this.c4));
    }

    public void testAddCompte_3 () {
        /*
         * addCompte (b, c) ==
         *         Si c == null
         *         Alors false
         *         Sinon
         *             Si getCompte(b, getNumCompte(c)) != null
         *             Alors false
         *             Sinon true
         */

        // Test sur Banque après des ajouts et des retraits de comptes
        this.b.addCompte(this.c1);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c2);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c3);
        
        this.retraitsComptes(this.b);
        
        // Test début, milieu, fin
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un objet Compte à null ...",
                this.b.addCompte(null));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
            this.b.addCompte(this.c1));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
            this.b.addCompte(this.c2));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
            this.b.addCompte(this.c3));
        TestCase.assertTrue("PROBLEME addCompte() : on ne peut pas ajouter un objet Compte inexistant ...",
            this.b.addCompte(this.c4));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
                this.b.addCompte(this.c4));
    }
    
    public void testAddCompte_4 () {
        /*
         * addCompte (b, c) ==
         *         Si c == null
         *         Alors false
         *         Sinon
         *             Si getCompte(b, getNumCompte(c)) != null
         *             Alors false
         *             Sinon true
         */

        // Test sur Banque après des ajouts et retrait de tous les comptes (banque "vide")
        this.b.addCompte(this.c1);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c2);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c3);

        this.retraitsTousLesComptes(this.b);
        
        this.b.removeCompte(numC1);
        this.b.removeCompte(numC2);
        this.b.removeCompte(numC3);

        TestCase.assertTrue("PROBLEME addCompte() : on ne peut pas ajouter un objet Compte inexistant ...",
                this.b.addCompte(this.c1));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
                this.b.addCompte(this.c1));
        TestCase.assertTrue("PROBLEME addCompte() : on ne peut pas ajouter un objet Compte inexistant ...",
                this.b.addCompte(this.c4));
        TestCase.assertFalse("PROBLEME addCompte() : on peut ajouter un compte dont le numéro est déjà existant dans la Banque ...",
                this.b.addCompte(this.c4));   
    }
   
    public void testAddCompte_5 () {
        /*
		 * getNomBanque( adCompte (b, c)) == getNomBanque(b)
		 * getLocBanque( addCompte (b, c)) == getLocBanque(b)
         */
    	String nomBDebut, nomBAvDernierAdd;
    	String locBDebut, locBAvDernierAdd;
    	
        // Test sur Banque après un seul ajout
        nomBDebut = this.b.getNomBanque();
        locBDebut = this.b.getLocBanque();
       
    	this.b.addCompte(this.c1);

        TestCase.assertEquals("PROBLEME addCompte() : modifie le nom de la Banque  ...",
                nomBDebut, this.b.getNomBanque());
        TestCase.assertEquals("PROBLEME addCompte() : modifie la localisation de la Banque  ...",
                locBDebut, this.b.getLocBanque());

        // Test sur Banque après ajouts de comptes
    	this.ajoutsComptes(this.b);
        
        nomBAvDernierAdd = this.b.getNomBanque();
        locBAvDernierAdd = this.b.getLocBanque();

        this.b.addCompte(this.c2);

        TestCase.assertEquals("PROBLEME addCompte() : modifie le nom de la Banque  ...",
        		nomBAvDernierAdd, this.b.getNomBanque());
        TestCase.assertEquals("PROBLEME addCompte() : modifie la localisation de la Banque  ...",
        		locBAvDernierAdd, this.b.getLocBanque());
        
        // Test sur Banque après retraits de quelques comptes
        this.retraitsComptes(this.b);
        this.b.removeCompte(this.numC1);
        
        nomBAvDernierAdd = this.b.getNomBanque();
        locBAvDernierAdd = this.b.getLocBanque();

        this.b.addCompte(this.c1);

        TestCase.assertEquals("PROBLEME addCompte() : modifie le nom de la Banque  ...",
        		nomBAvDernierAdd, this.b.getNomBanque());
        TestCase.assertEquals("PROBLEME addCompte() : modifie la localisation de la Banque  ...",
        		locBAvDernierAdd, this.b.getLocBanque());

        // Test sur Banque "vidée"
        this.retraitsTousLesComptes(this.b);
        this.b.removeCompte(this.numC1);
        this.b.removeCompte(this.numC2);
        
        nomBAvDernierAdd = this.b.getNomBanque();
        locBAvDernierAdd = this.b.getLocBanque();

        this.b.addCompte(this.c1);

        TestCase.assertEquals("PROBLEME addCompte() : modifie le nom de la Banque  ...",
        		nomBAvDernierAdd, this.b.getNomBanque());
        TestCase.assertEquals("PROBLEME addCompte() : modifie la localisation de la Banque  ...",
        		locBAvDernierAdd, this.b.getLocBanque());
    }

    public void testRemoveCompte_1 () {
        /*
		 * removeCompte (b, nc) ==
		 *         Si getCompte(b, getNumCompte(c)) == null
		 *         Alors false
		 *         Sinon true
         */
    	
    	// Test su Banque vide
        TestCase.assertFalse("PROBLEME removeCompte() : on peut enlever un compte inexistant ...",
                this.b.removeCompte(this.numInexistant));
    }

    public void testRemoveCompte_2 () {
        /*
		 * removeCompte (b, nc) ==
		 *         Si getCompte(b, getNumCompte(c)) == null
		 *         Alors false
		 *         Sinon true
         */

        // Test sur Banque après des ajouts de comptes
        this.b.addCompte(this.c1);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c2);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c3);

        // Test début, milieu, fin
        TestCase.assertFalse("PROBLEME removeCompte() : on peut enlever un compte inexistant ...",
                this.b.removeCompte(this.numInexistant));
        TestCase.assertTrue("PROBLEME removeCompte() : on ne peut pas enlever un compte existant ...",
        		this.b.removeCompte(this.numC1));
        TestCase.assertTrue("PROBLEME removeCompte() : on ne peut pas enlever un compte existant ...",
                this.b.removeCompte(this.numC2));
        TestCase.assertTrue("PROBLEME removeCompte() : on ne peut pas enlever un compte existant ...",
                this.b.removeCompte(this.numC3));
        TestCase.assertFalse("PROBLEME removeCompte() : on peut enlever un compte inexistant ...",
                this.b.removeCompte(this.numInexistant));
    }

    public void testRemoveCompte_3 () {
        /*
		 * removeCompte (b, nc) ==
		 *         Si getCompte(b, getNumCompte(c)) == null
		 *         Alors false
		 *         Sinon true
         */

        // Test sur Banque après des ajouts et des retraits de comptes
        this.b.addCompte(this.c1);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c2);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c3);
        
        this.retraitsComptes(this.b);
        
        // Test début, milieu, fin
        TestCase.assertFalse("PROBLEME removeCompte() : on peut enlever un compte inexistant ...",
                this.b.removeCompte(this.numInexistant));
        TestCase.assertTrue("PROBLEME removeCompte() : on ne peut pas enlever un compte existant ...",
        		this.b.removeCompte(this.numC1));
        TestCase.assertTrue("PROBLEME removeCompte() : on ne peut pas enlever un compte existant ...",
                this.b.removeCompte(this.numC2));
        TestCase.assertTrue("PROBLEME removeCompte() : on ne peut pas enlever un compte existant ...",
                this.b.removeCompte(this.numC3));
        TestCase.assertFalse("PROBLEME removeCompte() : on peut enlever un compte inexistant ...",
                this.b.removeCompte(this.numInexistant));
    }
    
    public void testRemoveCompte_4 () {
        /*
		 * removeCompte (b, nc) ==
		 *         Si getCompte(b, getNumCompte(c)) == null
		 *         Alors false
		 *         Sinon true
         */

    	// Test sur Banque après des ajouts et retrait de tous les comptes (banque "vide")
        this.b.addCompte(this.c1);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c2);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c3);

        this.retraitsTousLesComptes(this.b);
        
        this.b.removeCompte(numC1);
        this.b.removeCompte(numC2);
        this.b.removeCompte(numC3);
        
        TestCase.assertFalse("PROBLEME removeCompte() : on peut enlever un compte inexistant ...",
                this.b.removeCompte(this.numInexistant));
    }
   
    public void testRemoveCompte_5 () {
        /*
		 * getNomBanque( removeCompte (b, nc)) == getNomBanque(b)
		 * getLocBanque( removeCompte (b, nc)) == getLocBanque(b)
         */
    	String nomBAvant;
    	String locBAvant;
    	
        // Test sur Banque après des ajouts de comptes
       
    	this.b.addCompte(this.c1);
    	this.ajoutsComptes(this.b);
        this.b.addCompte(this.c2);
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c3);

        nomBAvant = this.b.getNomBanque();
        locBAvant = this.b.getLocBanque();
        
        this.b.removeCompte(this.numInexistant);
        
        TestCase.assertEquals("PROBLEME removeCompte () : modifie le nom de la Banque  ...",
                nomBAvant, this.b.getNomBanque());
        TestCase.assertEquals("PROBLEME removeCompte () : modifie la localisation de la Banque  ...",
                locBAvant, this.b.getLocBanque());
        
        nomBAvant = this.b.getNomBanque();
        locBAvant = this.b.getLocBanque();
        this.b.removeCompte(this.numC1);

        TestCase.assertEquals("PROBLEME removeCompte () : modifie le nom de la Banque  ...",
                nomBAvant, this.b.getNomBanque());
        TestCase.assertEquals("PROBLEME removeCompte () : modifie la localisation de la Banque  ...",
                locBAvant, this.b.getLocBanque());

        nomBAvant = this.b.getNomBanque();
        locBAvant = this.b.getLocBanque();
        this.b.removeCompte(this.numC3);
        
        TestCase.assertEquals("PROBLEME removeCompte () : modifie le nom de la Banque  ...",
                nomBAvant, this.b.getNomBanque());
        TestCase.assertEquals("PROBLEME removeCompte () : modifie la localisation de la Banque  ...",
                locBAvant, this.b.getLocBanque());

        nomBAvant = this.b.getNomBanque();
        locBAvant = this.b.getLocBanque();
        this.b.removeCompte(this.numC2);
        
        TestCase.assertEquals("PROBLEME removeCompte () : modifie le nom de la Banque  ...",
                nomBAvant, this.b.getNomBanque());
        TestCase.assertEquals("PROBLEME removeCompte () : modifie la localisation de la Banque  ...",
                locBAvant, this.b.getLocBanque());
    }
    
    public void testGetNbComptes () {
        /*
         * getNbComptes() : le nombre de Compte renvoyés par getNbComptes()
         */
    	int nbCptesAvant;
    	
    	// Test sur banque "vide"
    	TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes au départ ...",
                0, this.b.getNbComptes());
    	
    	this.b.addCompte(this.c1);
        
    	TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes ...",
                1, this.b.getNbComptes());

    	this.b.addCompte(this.c1);
        
    	TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes ...",
                1, this.b.getNbComptes());
    	
    	// Test sur banque "remplie"
    	this.ajoutsComptes(this.b);

        nbCptesAvant = this.b.getNbComptes();
        this.b.addCompte(this.c2);
        
        TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes ...",
                nbCptesAvant + 1, this.b.getNbComptes());
        
        nbCptesAvant = this.b.getNbComptes();
        this.b.addCompte(this.c2);
        
        TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes ...",
                nbCptesAvant, this.b.getNbComptes());
        
        // Test sur banque "remplie" et après retraits
        this.ajoutsComptes(this.b);
        this.retraitsComptes(this.b);

        nbCptesAvant = this.b.getNbComptes();
        this.b.addCompte(this.c3);
        
        TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes ...",
                nbCptesAvant + 1, this.b.getNbComptes());
        
        nbCptesAvant = this.b.getNbComptes();
        this.b.addCompte(this.c3);
        
        TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes ...",
                nbCptesAvant, this.b.getNbComptes());

        // Test sur banque "remplie" et après retraits
        
        nbCptesAvant = this.b.getNbComptes();
        this.b.removeCompte(this.numC3);
        
        TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes ...",
                nbCptesAvant - 1, this.b.getNbComptes());

        nbCptesAvant = this.b.getNbComptes();
        this.b.removeCompte(this.numC3);
        
        TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes ...",
                nbCptesAvant, this.b.getNbComptes());
        
        nbCptesAvant = this.b.getNbComptes();
        this.b.removeCompte(this.numC1);
        
        TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes ...",
                nbCptesAvant - 1, this.b.getNbComptes());

        nbCptesAvant = this.b.getNbComptes();
        this.b.removeCompte(this.numC2);
        
        TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes ...",
                nbCptesAvant - 1, this.b.getNbComptes());
        
        this.retraitsTousLesComptes(this.b);
        
        TestCase.assertEquals("PROBLEME getNbComptes () : mauvais nombre de comptes sur une banque 'vidée' ...",
                0, this.b.getNbComptes());

    }

    
    
    public void testGetCompte () {
        /*
         * getCompte() : le compte absent donc non trouvé ou présent donc trouvé
         */
    	
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numInexistant));
    	
    	this.b.addCompte(this.c1);
        
    	TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numInexistant));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC1));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c1, this.b.getCompte(this.numC1));

    	this.ajoutsComptes(this.b);
        this.b.addCompte(this.c2);
        
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numInexistant));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC1));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c1, this.b.getCompte(this.numC1));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC2));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c2, this.b.getCompte(this.numC2));
        
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c3);

        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numInexistant));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC1));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c1, this.b.getCompte(this.numC1));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC2));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c2, this.b.getCompte(this.numC2));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC3));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c3, this.b.getCompte(this.numC3));
        
        this.retraitsComptes(this.b);

        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numInexistant));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC1));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c1, this.b.getCompte(this.numC1));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC2));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c2, this.b.getCompte(this.numC2));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC3));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c3, this.b.getCompte(this.numC3));
        
        this.b.removeCompte(this.numC3);

        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numInexistant));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC1));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c1, this.b.getCompte(this.numC1));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC2));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c2, this.b.getCompte(this.numC2));
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numC3));
       
        this.b.removeCompte(this.numC1);

        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numInexistant));
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numC1));
        TestCase.assertNotNull("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.b.getCompte(this.numC2));
        TestCase.assertSame("PROBLEME getCompte () : ne trouve pas un compte présent ...",
                this.c2, this.b.getCompte(this.numC2));
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numC3));
        
        this.b.removeCompte(this.numC2);
 
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numInexistant));
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numC1));
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numC2));
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numC3));
        
        this.retraitsTousLesComptes(this.b);
        
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numInexistant));
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numC1));
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numC2));
        TestCase.assertNull("PROBLEME getCompte () : trouve un compte absent ...",
                this.b.getCompte(this.numC3));
    }  
    
    public void testGetComptesDe () {
        /*
         * getComptesDe() : les comptes sont trouvés si propriétaire présent, sinon non
         */
    	
        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propInexistant).length);
    	
    	this.b.addCompte(this.c1TestProp);
        
        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propInexistant).length);
        TestCase.assertEquals("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...",
                1, this.b.getComptesDe(this.propTprop).length);
        TestCase.assertSame("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...",
        		this.c1TestProp, this.b.getComptesDe(this.propTprop)[0]);
    	
    	this.ajoutsComptes(this.b);
        this.b.addCompte(this.c2TestProp);
        
        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propInexistant).length);
        TestCase.assertEquals("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...",
                2, this.b.getComptesDe(this.propTprop).length);
        
        for (Compte cTrouve : this.b.getComptesDe(this.propTprop))
        	if ((cTrouve != this.c1TestProp) && (cTrouve != this.c2TestProp))
        		TestCase.fail("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...");
        
        this.ajoutsComptes(this.b);
        this.b.addCompte(this.c3TestProp);

        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propInexistant).length);
        TestCase.assertEquals("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...",
                3, this.b.getComptesDe(this.propTprop).length);
        for (Compte cTrouve : this.b.getComptesDe(this.propTprop))
        	if ((cTrouve != this.c1TestProp) && (cTrouve != this.c2TestProp) && (cTrouve != this.c3TestProp))
        		TestCase.fail("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...");
        
        this.retraitsComptes(this.b);

        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propInexistant).length);
        TestCase.assertEquals("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...",
                3, this.b.getComptesDe(this.propTprop).length);
        for (Compte cTrouve : this.b.getComptesDe(this.propTprop))
        	if ((cTrouve != this.c1TestProp) && (cTrouve != this.c2TestProp) && (cTrouve != this.c3TestProp))
        		TestCase.fail("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...");

        this.b.removeCompte(this.numTC2prop);

        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propInexistant).length);
        TestCase.assertEquals("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...",
                2, this.b.getComptesDe(this.propTprop).length);
        for (Compte cTrouve : this.b.getComptesDe(this.propTprop))
        	if ((cTrouve != this.c1TestProp) && (cTrouve != this.c3TestProp))
        		TestCase.fail("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...");

        this.b.removeCompte(this.numTC1prop);

        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propInexistant).length);
        TestCase.assertEquals("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...",
                1, this.b.getComptesDe(this.propTprop).length);
        TestCase.assertSame("PROBLEME getComptesDe () : n'a pas trouve des comptes existants pour un propriétaire...",
        		this.c3TestProp, this.b.getComptesDe(this.propTprop)[0]); 
        
        this.b.removeCompte(this.numTC3prop);

        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propInexistant).length);
        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propTprop).length);
        
        this.retraitsTousLesComptes(this.b);
  
        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propInexistant).length);
        TestCase.assertEquals("PROBLEME getComptesDe () : trouve des comptes d'un propriétaire inexistant ...",
                0, this.b.getComptesDe(this.propTprop).length);
    }
    
    public static void main(String argv[]) {
        TestSuite suite = new TestSuite("Tests complets");
        suite.addTestSuite(TestBanque.class);
        junit.textui.TestRunner.run(suite);
    }
}






/* Test de la classe Banque
 *
 * APPROCHE PAR LES TYPES ABSTRAITS
*
* On supposera que les fonctions
*        constructeurs
*         addCompte()
*         removeCompte()
*     "renvoient un objet Banque" afin de pouvoir écrire les
*  expression ci-dessous.
*
* En tant que TAD, il est possible de spécifier :
*
* Préconditions : -
*
* getNomBanque( Banque( nomB, locB) ) == nomB
* getLocBanque( Banque( nomB, locB) ) == locB
* getNbComptes( Banque( nomB, locB) ) == 0
* getCompte( Banque( nomB, locB), numCpteQuelconque ) == null
* length( getComptesDe( Banque( nomB, locB), nomProp )) == 0
*
* getNomBanque( adCompte (b, c)) == getNomBanque(b)
* getLocBanque( addCompte (b, c)) == getLocBanque(b)
* getNbComptes( addCompte (b, c)) ==
*         Si c == null
*        Alors getNbComptes(b)
*        Sinon
*             Si getCompte(b, getNumCompte(c)) != null
*             Alors getNbComptes(b)
*             Sinon getNbComptes(b) + 1
* getCompte( addCompte (b, c), numCpte ) ==
*         Si getNumCompte(c) == numCpte
*      Alors c
*      Sinon getCompte( b, numCpte )
* getComptesDe( addCompte (b, c), nomProp ) ==
*         Si getProprietaire(c) != nomProp
*      Alors getComptesDe( b, nomProp )
*      Sinon getComptesDe( b, nomProp ) auquel est ajouté c
* addCompte (b, c) ==
*         Si c == null
*         Alors false
*         Sinon
*             Si getCompte(b, getNumCompte(c)) != null
*             Alors false
*             Sinon true
*
* getNomBanque( removeCompte (b, nc)) == getNomBanque(b)
* getLocBanque( removeCompte (b, nc)) == getLocBanque(b)
* getNbComptes( removeCompte (b, nc)) ==
*         Si getCompte(b, nc) == null
*         Alors getNbComptes(b)
*         Sinon getNbComptes(b) - 1
* getCompte( removeCompte (b, nc), numCpte ) ==
*         Si nc == numCpte
*      Alors null
*      Sinon getCompte( b, numCpte )
* getComptesDe( removeCompte (b, nc), nomProp ) ==
*         Si getCompte (b, nc) == null
*      Alors getComptesDe( b, nomProp )
*      Sinon
*          Si getProprietaire ( getCompte (b, nc) ) != nomProp
*          Alors getComptesDe( b, nomProp )
*          Sinon getComptesDe( b, nomProp ) auquel est retiré getCompte (b, nc)
* removeCompte (b, nc) ==
*         Si getCompte(b, getNumCompte(c)) == null
*         Alors false
*         Sinon true
*/
