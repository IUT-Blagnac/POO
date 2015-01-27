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
	 * @param ag	AgenceBancaire pour r�cup�rer le nom et la localisation
	 */
	public static void afficherMenu(AgenceBancaire ag) {
		System.out.println("Menu de " + ag.getNomAgence() + " (" + ag.getLocAgence() + ")");
		System.out.println("c - Cr�er un nouveau compte dans l'agence");
		System.out.println("s - Supprimer un compte de l'agence (par son num�ro)");
		System.out.println("l - Liste des comptes de l'agence");
		System.out.println("v - Voir un compte (par son num�ro)");
		System.out.println("p - voir les comptes d'un Propri�taire (par son nom)");
		System.out.println("d - D�poser de l'argent sur un compte");
		System.out.println("r - Retirer de l'argent sur un compte");
		System.out.println("q - Quitter");
		System.out.print("Choix -> ");
	}
	
	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
	 */
	public static void tempo () {
		Scanner lect ;
		String s;
		
		lect = new Scanner (System.in );
		
		System.out.print("Tapper un car + return pour continuer ... ");
		s = lect.next(); // Inutile � stocker mais ... 
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
					System.out.print("Num compte -> ");
					numero = lect.next();
					System.out.print("Propri�taire -> ");
					nom = lect.next();
					c = new Compte(numero, nom);
					try {
						monAg.addCompte(c);
						System.out.println("Ajout effectu�\n");
					} catch (ABCompteNullException e) {
						System.out.println("Num�ro de compte existant");
						System.out.println(e.getMessage());
					}
					catch (ABCompteDejaExistantException e) {
						System.out.println("Num�ro de compte existant");
						System.out.println(e.getMessage());
					}
					ClasseApplicationAgenceBancaire.tempo();
					break;
				case "s" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					try {
						monAg.removeCompte(numero);
						System.out.println("Suppression effectu�e\n");
					} catch (ABCompteInexistantException e) {
						System.out.println("Num�ro de compte inexistant");
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
					System.out.print("Propri�taire -> ");
					nom = lect.next();
					ClasseApplicationAgenceBancaire.comptesDUnPropretaire (monAg, nom);
					ClasseApplicationAgenceBancaire.tempo();
					break;		
				case "d" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					System.out.print("Montant � d�poser -> ");
					montant = lect.nextDouble();
					ClasseApplicationAgenceBancaire.deposerSurUnCompte(monAg, numero, montant);
					ClasseApplicationAgenceBancaire.tempo();
					break;
				case "r" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					System.out.print("Montant � retirer -> ");
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
	
	public static void comptesDUnPropretaire (AgenceBancaire ag, String nomProprietaire) {
		Compte []  t; 
		
		t = ag.getComptesDe(nomProprietaire);
		if (t.length == 0) {
			System.out.println("pas de compte � ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour " + nomProprietaire);
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
	}

	public static void deposerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant d�p�t: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant d�pos�, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void retirerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retir�, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}

	}
}
