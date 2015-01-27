import java.util.ArrayList;
import java.util.Scanner;

import tps.banque.Compte;

public class ClasseEssaiArrayListCompte {
	
	public static Compte[] tab = {
		new Compte ("01010101", "Lepoisson-Benoit"),
		new Compte ("02020202", "Tabaniol-Alphonse"),
		new Compte ("03030303", "Aidelaine-Gilles"),
		new Compte ("04040404", "Sanfraper-André"),
		new Compte ("05050505", "Tabaniol-Alphonse"),
		new Compte ("06060606", "Bondeparme-Jean"),
		new Compte ("07070707", "Sailair-Jacques"),
		new Compte ("08080808", "Saidimanche-Damien"),
		new Compte ("09090909", "Tabaniol-Alphonse")
	};
	
	
	/**
	 * Recherche les comptes du propriétaire pNomProprietaire 
	 * dans la liste de comptes pComptes.
	 * @param pNomProprietaire	Propriétaire recherché
	 * @param pComptes	Liste dans laquelle les comptes sont recherchés
	 * @return	Liste des compte de pComtes ayant pour propriétaire pNomProprietaire. Liste vide si aucun compte trouvé.
	 */
	public static ArrayList<Compte> getComptesDe (String pNomProprietaire, ArrayList<Compte> pComptes) {
		int i, taille;
		ArrayList<Compte> result;
		
		result = new ArrayList<Compte>();
		taille = pComptes.size();
		for (i=0; i<taille; i++) {
			if (pComptes.get(i).getProprietaire().equals(pNomProprietaire)) {
				result.add(pComptes.get(i));
			}
		}
		
		return result;
	}
	public static void main(String[] arguments) {
		int i, taille;
		ArrayList<Compte> listeComptes;
		ArrayList<Compte> resultatsProprietaire;
		String nomProp;
		Scanner lect = new Scanner(System.in);
		
		listeComptes = new ArrayList<Compte>();
		
		for(i=0; i<ClasseEssaiArrayListCompte.tab.length; i++) {
			listeComptes.add(ClasseEssaiArrayListCompte.tab[i]);
		}
		
		System.out.println("Les comptes existants");
		taille = listeComptes.size();
		System.out.println("  " + taille + " comptes");
		for (i=0; i<taille; i++) {
			System.out.print("  ");
			listeComptes.get(i).afficher();
		}	
		
		while (true) {
			System.out.print("Nom de propriétaire -> ");
			nomProp = lect.next();
			
			System.out.println("Ses comptes : ");
			resultatsProprietaire = ClasseEssaiArrayListCompte.getComptesDe(nomProp, listeComptes);
			taille = resultatsProprietaire.size();
			System.out.println("  " + taille + " comptes");
			for (i=0; i<taille; i++) {
				System.out.print("  ");
				resultatsProprietaire.get(i).afficher();
				// ou bien System.out.println("  " + resultatsProprietaire.get(i));
			}
		}
	}
}
