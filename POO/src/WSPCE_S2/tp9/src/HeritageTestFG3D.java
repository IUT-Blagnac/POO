public class HeritageTestFG3D {
	public static void main(String[] args) {
		// Compléter les test ici.
		
		// Exemple de test FormeGraphique
		
		FormeGraphique fgUn;
		FormeGraphique fgDeux;
		
		fgUn = new FormeGraphique();
		System.out.println("Test FormeGraphique 1");
		fgUn.afficher();
		fgUn.setOrigineX(550);
		fgUn.setOrigineY(660);
		fgUn.afficher();
		System.out.println("X : " + fgUn.getOrigineX());
		System.out.println("Y : " + fgUn.getOrigineY());
		System.out.println("Surface : " + fgUn.surface());
		System.out.println("Volume : " + fgUn.volume());
				
		fgDeux = new FormeGraphique(100, 200);		
		System.out.println("Test FormeGraphique 2");
		fgDeux.afficher();
		fgDeux.setOrigineX(550);
		fgDeux.setOrigineY(660);
		fgDeux.afficher();
		System.out.println("X : " + fgDeux.getOrigineX());
		System.out.println("Y : " + fgDeux.getOrigineY());
		System.out.println("Surface : " + fgDeux.surface());
		System.out.println("Volume : " + fgDeux.volume());

		Cercle cercleUn; 
		Cercle cercleDeux;
		
		cercleUn = new Cercle();
		System.out.println("Test Cercle 1");
		cercleUn.afficher();
		cercleUn.setRayon(11.0);
		cercleUn.setOrigineX(550);
		cercleUn.setOrigineY(660);
		cercleUn.afficher();
		System.out.println("rayon : " + cercleUn.getRayon());
		System.out.println("Surface : " + cercleUn.surface());
		System.out.println("X : " + cercleUn.getOrigineX());
		System.out.println("Y : " + cercleUn.getOrigineY());
		System.out.println("Volume : " + cercleUn.volume());
				
		cercleDeux = new Cercle(100, 200, 27.0);		
		System.out.println("Test Cercle 2");
		cercleDeux.afficher();
		cercleDeux.setRayon(48.0);
		cercleDeux.setOrigineX(550);
		cercleDeux.setOrigineY(660);
		cercleDeux.afficher();
		System.out.println("rayon : " + cercleDeux.getRayon());
		System.out.println("Surface : " + cercleDeux.surface());
		System.out.println("X : " + cercleDeux.getOrigineX());
		System.out.println("Y : " + cercleDeux.getOrigineY());
		System.out.println("Volume : " + cercleDeux.volume());
		
		Cylindre cylindreUn;
		Cylindre cylindreDeux;
		
		cylindreUn = new Cylindre();
		System.out.println("Test Cylindre 1");
		cylindreUn.afficher();
		cylindreUn.setHauteur(100);
		cylindreUn.setRayon(11.0);
		cylindreUn.setOrigineX(550);
		cylindreUn.setOrigineY(660);
		cylindreUn.afficher();
		System.out.println("hauteur : " + cylindreUn.getHauteur());
		System.out.println("Surface : " + cylindreUn.surface());
		System.out.println("Volume : " + cylindreUn.volume());
		System.out.println("rayon : " + cylindreUn.getRayon());
		System.out.println("X : " + cylindreUn.getOrigineX());
		System.out.println("Y : " + cylindreUn.getOrigineY());
				
		cylindreDeux = new Cylindre(100, 200, 27.0, 159);		
		System.out.println("Test Cylindre 2");
		cylindreDeux.afficher();
		cylindreDeux.setHauteur(100);
		cylindreDeux.setRayon(48.0);
		cylindreDeux.setOrigineX(550);
		cylindreDeux.setOrigineY(660);
		cylindreDeux.afficher();
		System.out.println("hauteur : " + cylindreDeux.getHauteur());
		System.out.println("rayon : " + cylindreDeux.getRayon());
		System.out.println("Volume : " + cylindreDeux.volume());
		System.out.println("Surface : " + cylindreDeux.surface());
		System.out.println("X : " + cylindreDeux.getOrigineX());
		System.out.println("Y : " + cylindreDeux.getOrigineY());
		
		Sphere sphereUn;
		Sphere sphereDeux;
		
		sphereUn = new Sphere();
		System.out.println("Test Sphere 1");
		sphereUn.afficher();
		sphereUn.setRayon(11.0);
		sphereUn.setOrigineX(550);
		sphereUn.setOrigineY(660);
		sphereUn.afficher();
		System.out.println("Surface : " + sphereUn.surface());
		System.out.println("Volume : " + sphereUn.volume());
		System.out.println("rayon : " + sphereUn.getRayon());
		System.out.println("X : " + sphereUn.getOrigineX());
		System.out.println("Y : " + sphereUn.getOrigineY());
			
		sphereDeux = new Sphere(100, 200, 27.0);		
		System.out.println("Test Sphere 2");
		sphereDeux.afficher();
		sphereDeux.setRayon(48.0);
		sphereDeux.setOrigineX(550);
		sphereDeux.setOrigineY(660);
		sphereDeux.afficher();
		System.out.println("rayon : " + sphereDeux.getRayon());
		System.out.println("Volume : " + sphereDeux.volume());
		System.out.println("Surface : " + sphereDeux.surface());
		System.out.println("X : " + sphereDeux.getOrigineX());
		System.out.println("Y : " + sphereDeux.getOrigineY());
		
		// Pour aller plus loin 
		
		FormeGraphique tabFormes[];

		tabFormes = new FormeGraphique [8];

		tabFormes[0] = fgUn; // variable référençant la première FormeGraphique créée
		tabFormes[1] = fgDeux; // variable référençant la deuxième FormeGraphique créée
		tabFormes[2] = cercleUn; 
		tabFormes[3] = cercleDeux;
		tabFormes[4] = cylindreUn; 
		tabFormes[5] = cylindreDeux;
		tabFormes[6] = sphereUn; 
		tabFormes[7] = sphereDeux;
		
		for (int i=0; i<8; i++) {
			System.out.print("Rang "+ i + " : ");
			System.out.print("surface : " + tabFormes[i].surface() + " ");
			System.out.println("volume : " + tabFormes[i].volume() + " ");
			tabFormes[i].afficher();
			System.out.println(tabFormes[i].getClass());
		}
		
	}

}
