
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TestCube extends TestCase {

	public void testConstructeurParDefaut() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		
		double surfaceHauteur, diagonale;
		
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
		surfaceHauteur = 0;
		diagonale = 0;

		// Assertions : les "vrais tests" (toute la méthode forme un seul test (arrêt première assertion fausse))
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec test Y", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test longueur", coteDeTest, c.getLongueur());
		
		TestCase.assertEquals("Echec test surface hauteur", surfaceHauteur, c.surfaceSurLaHauteur());
		TestCase.assertEquals("Echec test diagonale", diagonale, c.diagonaleCube());		
		TestCase.assertEquals("Echec test hauteur", coteDeTest, c.getHauteur());
	}
	
	public void testConstructeurParametre() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		
		double surfaceHauteur, diagonale;
		
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
		surfaceHauteur = 4 * coteDeTest*coteDeTest;
		diagonale = coteDeTest*Math.sqrt(3.0);

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec test Y", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test longueur", coteDeTest, c.getLongueur());
		
		TestCase.assertEquals("Echec test surface hauteur", surfaceHauteur, c.surfaceSurLaHauteur());
		TestCase.assertEquals("Echec test diagonale", diagonale, c.diagonaleCube());
		TestCase.assertEquals("Echec test hauteur", coteDeTest, c.getHauteur());
	}
	
	public void testSetOrigineX() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		
		double surfaceHauteur, diagonale;
		
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
		surfaceHauteur = 4 * coteDeTest*coteDeTest;
		diagonale = coteDeTest*Math.sqrt(3.0);

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec test Y", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test longueur", coteDeTest, c.getLongueur());
		
		TestCase.assertEquals("Echec test surface hauteur", surfaceHauteur, c.surfaceSurLaHauteur());
		TestCase.assertEquals("Echec test diagonale", diagonale, c.diagonaleCube());
		TestCase.assertEquals("Echec test hauteur", coteDeTest, c.getHauteur());
	}

	public void testSetOrigineY() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		
		double surfaceHauteur, diagonale;
		
		Cube c;
		
		// Initialisations
		
		xDeTest = 10;
		yDeTest = 20;
		coteDeTest = 30;
		
		// Situation testée
		
		c = new Cube (xDeTest, yDeTest, coteDeTest);
		yDeTest = yDeTest + 10;
		c.setOrigineY(yDeTest);
		
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = coteDeTest * coteDeTest * 6;
		volumeDeTest = coteDeTest * coteDeTest * coteDeTest;
		surfaceHauteur = 4 * coteDeTest*coteDeTest;
		diagonale = coteDeTest*Math.sqrt(3.0);

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec test Y", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test longueur", coteDeTest, c.getLongueur());
		
		TestCase.assertEquals("Echec test surface hauteur", surfaceHauteur, c.surfaceSurLaHauteur());
		TestCase.assertEquals("Echec test diagonale", diagonale, c.diagonaleCube());
		TestCase.assertEquals("Echec test hauteur", coteDeTest, c.getHauteur());
	}

	public void testSetCote() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		
		double surfaceHauteur, diagonale;
		
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
		surfaceHauteur = 4 * coteDeTest*coteDeTest;
		diagonale = coteDeTest*Math.sqrt(3.0);

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec test Y", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test longueur", coteDeTest, c.getLongueur());
		
		TestCase.assertEquals("Echec test surface hauteur", surfaceHauteur, c.surfaceSurLaHauteur());
		TestCase.assertEquals("Echec test diagonale", diagonale, c.diagonaleCube());	
		TestCase.assertEquals("Echec test hauteur", coteDeTest, c.getHauteur());
	}
	
	public void testSetLargeur() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		
		double surfaceHauteur, diagonale;
		
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
		surfaceHauteur = 4 * coteDeTest*coteDeTest;
		diagonale = coteDeTest*Math.sqrt(3.0);

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec test Y", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test longueur", coteDeTest, c.getLongueur());
		
		TestCase.assertEquals("Echec test surface hauteur", surfaceHauteur, c.surfaceSurLaHauteur());
		TestCase.assertEquals("Echec test diagonale", diagonale, c.diagonaleCube());
		TestCase.assertEquals("Echec test hauteur", coteDeTest, c.getHauteur());
	}
	
	public void testSetLongueur() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		
		double surfaceHauteur, diagonale;
		
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
		surfaceHauteur = 4 * coteDeTest*coteDeTest;
		diagonale = coteDeTest*Math.sqrt(3.0);

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec test Y", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test longueur", coteDeTest, c.getLongueur());
		
		TestCase.assertEquals("Echec test surface hauteur", surfaceHauteur, c.surfaceSurLaHauteur());
		TestCase.assertEquals("Echec test diagonale", diagonale, c.diagonaleCube());	
		TestCase.assertEquals("Echec test hauteur", coteDeTest, c.getHauteur());
	}
	
	public void testSetHauteur() {
		
		int xDeTest, yDeTest;
		int coteDeTest;
		double surfaceDeTest, volumeDeTest;
		
		double surfaceHauteur, diagonale;
		
		Cube c;
		
		// Initialisations
		
		xDeTest = 10;
		yDeTest = 20;
		coteDeTest = 30;
		
		// Situation testée
		
		c = new Cube (xDeTest, yDeTest, coteDeTest);
		coteDeTest = coteDeTest + 10;
		c.setHauteur(coteDeTest);
		
		// Calcul des résultats attendus
		// Les autres variables ne changent pas
		
		surfaceDeTest = coteDeTest * coteDeTest * 6;
		volumeDeTest = coteDeTest * coteDeTest * coteDeTest;
		surfaceHauteur = 4 * coteDeTest*coteDeTest;
		diagonale = coteDeTest*Math.sqrt(3.0);

		// Tests
		
		TestCase.assertEquals("Echec test X", xDeTest, c.getOrigineX());
		TestCase.assertEquals("Echec test Y", yDeTest, c.getOrigineY());
		TestCase.assertEquals("Echec test coté", coteDeTest, c.getCote());
		TestCase.assertEquals("Echec test surface", surfaceDeTest, c.surface());
		TestCase.assertEquals("Echec test volume", volumeDeTest, c.volume());
		
		TestCase.assertEquals("Echec test largeur", coteDeTest, c.getLargeur());
		TestCase.assertEquals("Echec test longueur", coteDeTest, c.getLongueur());
		
		TestCase.assertEquals("Echec test surface hauteur", surfaceHauteur, c.surfaceSurLaHauteur());
		TestCase.assertEquals("Echec test diagonale", diagonale, c.diagonaleCube());	
		TestCase.assertEquals("Echec test hauteur", coteDeTest, c.getHauteur());
	}
	
	public static void main(String[] argv) {
		TestSuite suite = new TestSuite("Tests complets");
		suite.addTestSuite(TestCube.class);
		junit.textui.TestRunner.run(suite);
	}
}
