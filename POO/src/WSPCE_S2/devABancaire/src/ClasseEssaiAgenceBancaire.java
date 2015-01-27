
import tps.banque.AgenceBancaire;
import tps.banque.Compte;
import tps.banque.exception.ABCompteDejaExistantException;
import tps.banque.exception.ABCompteInexistantException;
import tps.banque.exception.ABCompteNullException;
import tps.banque.exception.CompteException;

public class ClasseEssaiAgenceBancaire {
	public static void main(String argv[]) {
		
		AgenceBancaire monAg ;
		
		Compte c;
		Compte []  t; 
		
		monAg = new AgenceBancaire("Caisse Ep", "Pibrac");
		monAg.afficher();
		System.out.println(monAg.getNbComptes());		
		
		try {
			c = new Compte ("0101", "prop1");
			monAg.addCompte(c);
			c = new Compte ("0202", "prop2");
			monAg.addCompte(c);
			c = new Compte ("0303", "prop2");
			monAg.addCompte(c);
		} catch (ABCompteNullException e) {
			System.out.println (e.getMessage());
		} catch (ABCompteDejaExistantException e) {
			System.out.println (e.getMessage());
		}

		monAg.afficher();
		
		c = monAg.getCompte("0101");
		c.afficher();
		
		try {
			c.deposer(1000);
		} catch (CompteException e) {
			System.out.println (e.getMessage());
		}
		
		c = monAg.getCompte("0101");
		c.afficher();
		
		c = monAg.getCompte("9999");
		if (c==null) {
			System.out.println("9999 ABSENT Normal");
		} else { 
			c.afficher();
		}
		
		t = monAg.getComptesDe("prop2");
		if (t.length == 0) {
			System.out.println("pas de compte à ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour prop 2");
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
		
		try {
			t[0].deposer(2000);
			t[1].deposer(3000);
		} catch (CompteException e) {
			System.out.println (e.getMessage());
		}
		
		t = monAg.getComptesDe("prop2");
		if (t.length == 0) {
			System.out.println("pas de compte à ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour prop 2");
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
		
		t = monAg.getComptesDe("ABSENT");
		if (t.length == 0) {
			System.out.println("pas de compte à ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour prop 2");
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
		
		try {
			c = null;
			monAg.addCompte(c);
		} catch (ABCompteNullException | ABCompteDejaExistantException e) {
			System.out.println("Erreur");
			System.out.println (e.getMessage());
		}
		
		try {
			monAg.removeCompte("0202");
		} catch (ABCompteInexistantException e) {
			System.out.println (e.getMessage());
		}
		try {
			monAg.removeCompte("9999");
		} catch (ABCompteInexistantException e) {
			System.out.println("Erreur");
			System.out.println (e.getMessage());
		}
		try {
			c = new Compte ("0101", "prop99");
			monAg.addCompte(c);
		} catch (ABCompteNullException | ABCompteDejaExistantException e) {
			System.out.println("Erreur");
			System.out.println (e.getMessage());
		}
	}
}
