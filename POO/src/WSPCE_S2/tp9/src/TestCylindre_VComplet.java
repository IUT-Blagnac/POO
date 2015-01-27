import junit.framework.TestCase;
import junit.framework.TestSuite;



public class TestCylindresdsdsdsdd extends TestCase {

	public void testConstructeurParDefaut() {
		
		int xDeTest, yDeTest;
		double hauteurDeTest, rayonDeTest;
		double surfaceDeTest, volumeDeTest, surfaceCylSeul;
		Cylindre c;
		
		// Initialisations
		
		xDeTest = 0;
		yDeTest = 0;
		hauteurDeTest = 0;
		rayonDeTest = 0;
		
		// Situation testée
		
		c = new Cylindre();
		
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = 0;
		volumeDeTest = 0;
		surfaceCylSeul = 0;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test hauteur", hauteurDeTest, c.getHauteur());
		TestCase.assertEquals("Echec test rayon", rayonDeTest, c.getRayon());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test surface cylindre seul", surfaceCylSeul, c.surfaceCylindreSeul());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());		
	}
	
	public void testConstructeurParametre() {
		
		int xDeTest, yDeTest;
		double hauteurDeTest, rayonDeTest;
		double surfaceDeTest, volumeDeTest, surfaceCylSeul;
		Cylindre c;
		
		// Initialisations
		
		xDeTest = 100;
		yDeTest = 200;
		hauteurDeTest = 300;
		rayonDeTest = 400;
		
		// Situation testée
		
		c = new Cylindre(xDeTest, yDeTest, rayonDeTest, hauteurDeTest);
		
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = 2 * Math.PI * rayonDeTest * hauteurDeTest
				+ 2 * Math.PI * rayonDeTest * rayonDeTest;
		surfaceCylSeul = 2 * Math.PI * rayonDeTest * hauteurDeTest;
		volumeDeTest =  Math.PI * rayonDeTest * rayonDeTest * hauteurDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test hauteur", hauteurDeTest, c.getHauteur());
		TestCase.assertEquals("Echec test rayon", rayonDeTest, c.getRayon());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test surface cylindre seul", surfaceCylSeul, c.surfaceCylindreSeul());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
	}
	
	public void testSetOrigineX() {
		
		int xDeTest, yDeTest;
		double hauteurDeTest, rayonDeTest;
		double surfaceDeTest, volumeDeTest, surfaceCylSeul;
		Cylindre c;
		
		// Initialisations
		
		xDeTest = 100;
		yDeTest = 200;
		hauteurDeTest = 300;
		rayonDeTest = 400;
		
		// Situation testée
		
		c = new Cylindre(xDeTest, yDeTest, rayonDeTest, hauteurDeTest);
		
		xDeTest = xDeTest + 100;
		c.setOrigineX(xDeTest);

		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = 2 * Math.PI * rayonDeTest * hauteurDeTest
				+ 2 * Math.PI * rayonDeTest * rayonDeTest;
		surfaceCylSeul = 2 * Math.PI * rayonDeTest * hauteurDeTest;
		volumeDeTest =  Math.PI * rayonDeTest * rayonDeTest * hauteurDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test hauteur", hauteurDeTest, c.getHauteur());
		TestCase.assertEquals("Echec test rayon", rayonDeTest, c.getRayon());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test surface cylindre seul", surfaceCylSeul, c.surfaceCylindreSeul());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
	}

	public void testSetOrigineY() {
		
		int xDeTest, yDeTest;
		double hauteurDeTest, rayonDeTest;
		double surfaceDeTest, volumeDeTest, surfaceCylSeul;
		Cylindre c;
		
		// Initialisations
		
		xDeTest = 100;
		yDeTest = 200;
		hauteurDeTest = 300;
		rayonDeTest = 400;
		
		// Situation testée
		
		c = new Cylindre(xDeTest, yDeTest, rayonDeTest, hauteurDeTest);
		
		yDeTest = yDeTest + 100;
		c.setOrigineY(yDeTest);

		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = 2 * Math.PI * rayonDeTest * hauteurDeTest
				+ 2 * Math.PI * rayonDeTest * rayonDeTest;
		surfaceCylSeul = 2 * Math.PI * rayonDeTest * hauteurDeTest;
		volumeDeTest =  Math.PI * rayonDeTest * rayonDeTest * hauteurDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test hauteur", hauteurDeTest, c.getHauteur());
		TestCase.assertEquals("Echec test rayon", rayonDeTest, c.getRayon());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test surface cylindre seul", surfaceCylSeul, c.surfaceCylindreSeul());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
	}

	public void testSetHauteur() {
		
		int xDeTest, yDeTest;
		double hauteurDeTest, rayonDeTest;
		double surfaceDeTest, volumeDeTest, surfaceCylSeul;
		Cylindre c;
		
		// Initialisations
		
		xDeTest = 100;
		yDeTest = 200;
		hauteurDeTest = 300;
		rayonDeTest = 400;
		
		// Situation testée
		
		c = new Cylindre(xDeTest, yDeTest, rayonDeTest, hauteurDeTest);
		
		hauteurDeTest = hauteurDeTest + 500;
		c.setHauteur(hauteurDeTest);

		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = 2 * Math.PI * rayonDeTest * hauteurDeTest
				+ 2 * Math.PI * rayonDeTest * rayonDeTest;
		surfaceCylSeul = 2 * Math.PI * rayonDeTest * hauteurDeTest;
		volumeDeTest =  Math.PI * rayonDeTest * rayonDeTest * hauteurDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test hauteur", hauteurDeTest, c.getHauteur());
		TestCase.assertEquals("Echec test rayon", rayonDeTest, c.getRayon());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test surface cylindre seul", surfaceCylSeul, c.surfaceCylindreSeul());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
	}
	
	public void testSetRayon() {
		
		int xDeTest, yDeTest;
		double hauteurDeTest, rayonDeTest;
		double surfaceDeTest, volumeDeTest, surfaceCylSeul;
		Cylindre c;
		
		// Initialisations
		
		xDeTest = 100;
		yDeTest = 200;
		hauteurDeTest = 300;
		rayonDeTest = 400;
		
		// Situation testée
		
		c = new Cylindre(xDeTest, yDeTest, rayonDeTest, hauteurDeTest);
		
		rayonDeTest = rayonDeTest + 500;
		c.setRayon(rayonDeTest);

		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = 2 * Math.PI * rayonDeTest * hauteurDeTest
				+ 2 * Math.PI * rayonDeTest * rayonDeTest;
		surfaceCylSeul = 2 * Math.PI * rayonDeTest * hauteurDeTest;
		volumeDeTest =  Math.PI * rayonDeTest * rayonDeTest * hauteurDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test hauteur", hauteurDeTest, c.getHauteur());
		TestCase.assertEquals("Echec test rayon", rayonDeTest, c.getRayon());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test surface cylindre seul", surfaceCylSeul, c.surfaceCylindreSeul());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
	}
	
	public static void main(String argv[]) {
		TestSuite suite = new TestSuite("Tests complets");
		suite.addTestSuite(TestCylindre.class);
		junit.textui.TestRunner.run(suite);
	}
}
