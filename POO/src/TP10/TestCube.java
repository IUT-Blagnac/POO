
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TestCube extends TestCase {

	public void testConstructeurParDefaut() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		Cube c;
		
		// Initialisations
		
		xDeTest = 0;
		yDeTest = 0;
		coteDeTest = 0;
		
		// Situation testée
		
		c = new Cube ();
		// autres instructions éventuelles
		
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = 0;
		volumeDeTest = 0;

		// Assertions : les "vrais tests" (toute la méthode forme un seul test (arrêt première assertion fausse))
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLongueur());
	}
	
	public void testConstructeurParametre() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		Cube c;
		
		// Initialisations
		
		xDeTest = 10;
		yDeTest = 20;
		coteDeTest = 30;
		
		// Situation testée
		
		c = new Cube (xDeTest, yDeTest, coteDeTest);
		
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = coteDeTest * coteDeTest * 6;
		volumeDeTest = coteDeTest * coteDeTest * coteDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLongueur());
	}
	
	public void testSetOrigineX() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		Cube c;
		
		// Initialisations
		
		xDeTest = 10;
		yDeTest = 20;
		coteDeTest = 30;
		
		// Situation testée
		
		c = new Cube (xDeTest, yDeTest, coteDeTest);
		xDeTest = xDeTest + 10;
		c.setOrigineX(xDeTest);
		
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = coteDeTest * coteDeTest * 6;
		volumeDeTest = coteDeTest * coteDeTest * coteDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLongueur());
	}

	public void testSetOrigineY() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		Cube c;
		
		// Initialisations
		
		xDeTest = 10;
		yDeTest = 20;
		coteDeTest = 30;
		
		// Situation testée
		
		c = new Cube (xDeTest, yDeTest, coteDeTest);
		yDeTest = yDeTest + 10;
		c.setOrigineY(yDeTest);
		c.
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = coteDeTest * coteDeTest * 6;
		volumeDeTest = coteDeTest * coteDeTest * coteDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLongueur());
	}

	public void testSetCote() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		Cube c;
		
		// Initialisations
		
		xDeTest = 10;
		yDeTest = 20;
		coteDeTest = 30;
		
		// Situation testée
		
		c = new Cube (xDeTest, yDeTest, coteDeTest);
		coteDeTest = coteDeTest + 10;
		c.setCote(coteDeTest);
		
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = coteDeTest * coteDeTest * 6;
		volumeDeTest = coteDeTest * coteDeTest * coteDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLongueur());
	}
	
	public void testSetLargeur() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		Cube c;
		
		// Initialisations
		
		xDeTest = 10;
		yDeTest = 20;
		coteDeTest = 30;
		
		// Situation testée
		
		c = new Cube (xDeTest, yDeTest, coteDeTest);
		coteDeTest = coteDeTest + 10;
		c.setLargeur(coteDeTest);
		
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = coteDeTest * coteDeTest * 6;
		volumeDeTest = coteDeTest * coteDeTest * coteDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLongueur());
	}
	
	public void testSetLongueur() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		Cube c;
		
		// Initialisations
		
		xDeTest = 10;
		yDeTest = 20;
		coteDeTest = 30;
		
		// Situation testée
		
		c = new Cube (xDeTest, yDeTest, coteDeTest);
		coteDeTest = coteDeTest + 10;
		c.setLongueur(coteDeTest);
		
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = coteDeTest * coteDeTest * 6;
		volumeDeTest = coteDeTest * coteDeTest * coteDeTest;

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec testY", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLongueur());
	}
	
	
	public static void main(String[] argv) {
		TestSuite suite = new TestSuite("Tests complets");
		suite.addTestSuite(TestCube.class);
		junit.textui.TestRunner.run(suite);
	}
}
