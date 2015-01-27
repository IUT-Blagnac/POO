
public class ClassEssai {
	public static void main(String[] args) {

		Compte cUn, cDeux, cTrois;
		
		cUn = new CompteBancaire("010101", "prop01", "jisa010101", 500);
		cDeux = new CompteEpargne("02020202", "prop020202", 10);
		cTrois = new CompteMoneo("03030303", "prop030303", "moneo030303");

		try {
			cUn.deposer(2000);
			cDeux.deposer(2000);
			cTrois.deposer(2000);
		} catch (CompteException e) {
			System.out.println("PBPB");
		}
		
		System.out.println("cUn");
		cUn.afficherAvecSolde();
		System.out.println("cDeux");
		cDeux.afficherAvecSolde();
		System.out.println("cTrois");
		cTrois.afficherAvecSolde();
		
		try {
			cUn.transferer(cDeux, 500);
			cUn.transferer(cTrois, 500);
		} catch (CompteException e) {
			System.out.println("PBPB");
		}

		System.out.println("cUn");
		cUn.afficherAvecSolde();
		System.out.println("cDeux");
		cDeux.afficherAvecSolde();
		System.out.println("cTrois");
		cTrois.afficherAvecSolde();
		
		Compte tabC[] = new Compte[3];
		
		tabC[0] = cUn;
		tabC[1] = cDeux;
		tabC[2] = cTrois;
		
		for (int i =0; i<tabC.length; i++) {
			System.out.println("Compte : "+i);
			tabC[i].afficherAvecSolde();
		}
		
		try {
			for (int i =0; i<tabC.length; i++) {
				tabC[i].deposer(3000);
			}
			tabC[0].transferer(tabC[1], 1000);
			tabC[0].transferer(tabC[2], 1000);
		} catch (CompteException e) {
			System.out.println("PBPB");
		}
		
		for (int i =0; i<tabC.length; i++) {
			System.out.println("Compte : "+i);
			tabC[i].afficherAvecSolde();
		}
	}
}
