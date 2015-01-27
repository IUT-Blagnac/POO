import java.util.Locale;
import java.util.Scanner;

import tps.banque.AgenceBancaire;
import tps.banque.Compte;
import tps.banque.exception.ABCompteDejaExistantException;
import tps.banque.exception.ABCompteInexistantException;
import tps.banque.exception.ABCompteNullException;
import tps.banque.exception.CompteException;

public class ClasseApplicationAgenceBancaire {
	
	/**
	 * Affichage du menu de l'application
	 * @param ag	AgenceBancaire pour récupérer le nom et la localisation
	 */
	public static void afficherMenu(AgenceBancaire ag) {
		System.out.println("Menu de " + ag.getNomAgence() + " (" + ag.getLocAgence() + ")");
		System.out.println("c - Créer un nouveau compte dans l'agence");
		System.out.println("s - Supprimer un compte de l'agence (par son numéro)");
		System.out.println("l - Liste des comptes de l'agence");
		System.out.println("v - Voir un compte (par son numéro)");
		System.out.println("p - voir les comptes d'un Propriétaire (par son nom)");
		System.out.println("d - Déposer de l'argent sur un compte");
		System.out.println("r - Retirer de l'argent sur un compte");
		System.out.println("q - Quitter");
		System.out.print("Choix -> ");
	}
	
	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caractère.
	 */
	public static void tempo () {
		Scanner lect ;
		String s;
		
		lect = new Scanner (System.in );
		
		System.out.print("Tapper un car + return pour continuer ... ");
		s = lect.next(); // Inutile à stocker mais ... 
	}

	public static void main(String argv[]) {
		
		String choix;

		boolean continuer ;
		Scanner lect;
		AgenceBancaire monAg ;
		
		String nom, numero;		
		Compte c;
		double montant;
		
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		
		monAg = new AgenceBancaire("Caisse Ep", "Pibrac");
		
		continuer = true;
		while (continuer) {
			ClasseApplicationAgenceBancaire.afficherMenu(monAg);
			choix = lect.next();
			choix = choix.toLowerCase();
			switch (choix) {
				case "q" :
					System.out.println("ByeBye");
					ClasseApplicationAgenceBancaire.tempo();
					continuer = false;
					break;
				case "c" :
					ClasseApplicationAgenceBancaire.creerUnCompte(monAg);
					ClasseApplicationAgenceBancaire.tempo();
					break;
				case "s" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					try {
						monAg.removeCompte(numero);
						System.out.println("Suppression effectuée\n");
					} catch (ABCompteInexistantException e) {
						System.out.println("Numéro de compte inexistant");
						System.out.println(e.getMessage());
					}
					ClasseApplicationAgenceBancaire.tempo();
					break;
				case "l" :
					monAg.afficher();
					ClasseApplicationAgenceBancaire.tempo();
					break;	
				case "v" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					c = monAg.getCompte(numero);
					if (c==null) {
						System.out.println("Compte inexistant ...");
					} else {
						c.afficher();
					}
					ClasseApplicationAgenceBancaire.tempo();
					break;
				case "p" :
					System.out.print("Propriétaire -> ");
					nom = lect.next();
					ClasseApplicationAgenceBancaire.comptesDUnPropretaire (monAg, nom);
					ClasseApplicationAgenceBancaire.tempo();
					break;		
				case "d" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					System.out.print("Montant à déposer -> ");
					montant = lect.nextDouble();
					ClasseApplicationAgenceBancaire.deposerSurUnCompte(monAg, numero, montant);
					ClasseApplicationAgenceBancaire.tempo();
					break;
				case "r" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					System.out.print("Montant à retirer -> ");
					montant = lect.nextDouble();
					ClasseApplicationAgenceBancaire.retirerSurUnCompte(monAg, numero, montant);
					ClasseApplicationAgenceBancaire.tempo();
					break;
				default :
					System.out.println("Erreur de saisie ...");
					ClasseApplicationAgenceBancaire.tempo();
					break;
			}
		}
		
	}

	public static void creerUnCompte (AgenceBancaire ag) {
		String numero, nom;
		Scanner lect = new Scanner ( System.in );
		Compte c;
		
		lect.useLocale(Locale.US);
		
		System.out.print("Num compte -> ");
		numero = lect.next();
		System.out.print("Propriétaire -> ");
		nom = lect.next();
		c = new Compte(numero, nom);
		try {
			ag.addCompte(c);
			System.out.println("Ajout effectué\n");
		} catch (ABCompteNullException e) {
			System.out.println("Numéro de compte existant");
			System.out.println(e.getMessage());
		}
		catch (ABCompteDejaExistantException e) {
			System.out.println("Numéro de compte existant");
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Permet d'afficher tous les comptes d'un propriétaire dans une agence. <BR>
	 * Affiche à l'écran les comptes trouvés, un message si saucun compte n'existe pour le propriétaire.<BR>
	 * 
	 * @param ag               agence dans laquelle les comptes sont cherchés.  
	 * @param nomProprietaire  nom du propriétaire dont on cherche les comptes.
	 */
	public static void comptesDUnPropretaire (AgenceBancaire ag, String nomProprietaire) {
		Compte []  t; 
		
		t = ag.getComptesDe(nomProprietaire);
		if (t.length == 0) {
			System.out.println("pas de compte à ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour " + nomProprietaire);
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
	}

	/**
	 * Réalise un dépot sur le compte d'une agence. <BR>
	 * Recherche le compte dans l'agence à partir de son numéro et réalise le dépôt.<BR>
	 * Affiche un message si dépôt réussi, si dépôt impossible ou si compte non trouvé.
	 * 
	 * @param ag            agence dans laquelle le comptes est cherché. 
	 * @param numeroCompte  numéro du compte sur lequel est fait le dépôt. 
	 * @param montant       montant du dépôt à effectuer.
	 */
	public static void deposerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant dépôt: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant déposé, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * Réalise un retrait sur le compte d'une agence. <BR>
	 * Recherche le compte dans l'agence à partir de son numéro et réalise le retrait.<BR>
	 * Affiche un message si retrait réussi, si retrait impossible ou si compte non trouvé.
	 *
	 * @param montant
	 * @param ag            agence dans laquelle le comptes est cherché. 
	 * @param numeroCompte  numéro du compte sur lequel est fait le retrait. 
	 * @param montant       montant du retrait à effectuer.
	 */
	public static void retirerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retiré, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}

	}
}
