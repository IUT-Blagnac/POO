import java.util.Locale;
import java.util.Scanner;

public class ClasseApplicationAgenceBancaire {

	// Scanner partag� par toutes les m�thodes : un seul suffit pour toute l'application.
	private Scanner lect;
	
	// L'agence bancaire g�r�e par l'application en cours.
	private AgenceBancaire monAg;

	// Constructeur
	public ClasseApplicationAgenceBancaire(AgenceBancaire ag) {
		this.lect = new Scanner(System.in);
		this.lect.useLocale(Locale.US);
		this.monAg = ag;
	}

	// Lancer l'applciation : le menu + r�ponses du syst�me
	public void runApplication() {

		String choix;
		boolean continuer;

		continuer = true;
		while (continuer) {
			this.afficherMenu();
			choix = this.lect.next();
			choix = choix.toLowerCase();
			switch (choix) {
			case "q":
				System.out.println("ByeBye");
				this.tempo();
				continuer = false;
				break;
			case "cb":
				this.creerCompteBancaire();
				this.tempo();
				break;
			case "ce":
				this.creerCompteEpargne();
				this.tempo();
				break;
			case "cj":
				this.creerCompteJeune();
				this.tempo();
				break;
			case "cm":
				this.creerCompteMoneo();
				this.tempo();
				break;
			case "s":
				this.supprimerUnCompte();
				this.tempo();
				break;
			case "l":
				this.monAg.afficher();
				this.tempo();
				break;
			case "v":
				this.voirUnCompte();
				this.tempo();
				break;
			case "p":
				this.comptesDUnPropretaire();
				this.tempo();
				break;
			case "d":
				this.deposerSurUnCompte();
				this.tempo();
				break;
			case "r":
				this.retirerSurUnCompte();
				this.tempo();
				break;
			case "t":
				this.transfertEntreDeuxComptes();
				this.tempo();
				break;				
			default:
				System.out.println("Erreur de saisie ...");
				this.tempo();
				break;
			}
		}
	}


	// Saisir les infos pour un CompteMoneo
	// Cr�er l'objet CompteMoneo
	// Ajouter cet objet � l'agence g�r�e
	private void creerCompteMoneo () {
		CompteMoneo cm ;
		System.out.println("Cr�er un compte moneo ");
		System.out.println("Not Yet Implemented");
	}
	
	// Saisir les infos pour un CompteBancaire
	// Cr�er l'objet CompteBancaire
	// Ajouter cet objet � l'agence g�r�e
	private void creerCompteBancaire () {
		CompteBancaire cb;
		System.out.println("Cr�er un compte bancaire ");
		System.out.println("Not Yet Implemented");
	}
	
	// Saisir les infos pour un CompteEpargne
	// Cr�er l'objet CompteEpargne
	// Ajouter cet objet � l'agence g�r�e
	private void creerCompteEpargne () {
		CompteEpargne cep ;
		System.out.println("Cr�er un compte �pargne ");
		System.out.println("Not Yet Implemented");
	}

	// Saisir les infos pour un CompteJeune
	// Cr�er l'objet CompteJeune
	// Ajouter cet objet � l'agence g�r�e
	private void creerCompteJeune () {
		CompteJeune cj;
		System.out.println("Cr�er un compte jeune ");
		System.out.println("Not Yet Implemented");
	}

	// Transfert entre deux comptes
	// Saisir les num�ros de deux comptes, 
	// Saisir le montant � transf�rer
	// R�aliser le transfert
	private void transfertEntreDeuxComptes () {
		System.out.println("Transfert entre deux comptes");
		System.out.println("Not Yet Implemented");
	}
	
	
	// Affichage des options du menu
	private void afficherMenu() {
		System.out.println("Menu de " + this.monAg.getNomAgence() + " ("
				+ this.monAg.getLocAgence() + ")");
		System.out.println("cb - Cr�er un nouveau compte bancaire dans l'agence");
		System.out.println("ce - Cr�er un nouveau compte epargne dans l'agence");
		System.out.println("cj - Cr�er un nouveau compte jeune dans l'agence");
		System.out.println("cm - Cr�er un nouveau Compte moneo dans l'agence");
		System.out.println("s - Supprimer un compte de l'agence (par son num�ro)");
		System.out.println("l - Liste des comptes de l'agence");
		System.out.println("v - Voir un compte (par son num�ro)");
		System.out.println("p - voir les comptes d'un Propri�taire (par son nom)");
		System.out.println("d - D�poser de l'argent sur un compte");
		System.out.println("r - Retirer de l'argent sur un compte");
		System.out.println("t - Transf�rer une somme entre deux comptes");
		System.out.println("q - Quitter");
		System.out.print("Choix -> ");
	}

	// Temporisation : attend la frappe de caract�res par l'utilisateur
	private void tempo() {
		String s;

		System.out.print("Tapper un car + return pour continuer ... ");
		s = this.lect.next(); // Inutile � stocker mais ...
	}

	// Afficher avce son solde un copmpte � l'�cran
	private void voirUnCompte () {
		String numero;
		Compte c;
		
		System.out.print("Num compte -> ");
		numero = this.lect.next();
		c = this.monAg.getCompte(numero);
		if (c == null) {
			System.out.println("Compte inexistant ...");
		} else {
			c.afficher();
		}
	}
	
	// Supprimer un compte � partir de la saisie de son num�ro
	private void supprimerUnCompte() {
		String numero;
		System.out.print("Num compte -> ");
		numero = this.lect.next();
		try {
			this.monAg.removeCompte(numero);
			System.out.println("Suppression effectu�e\n");
		} catch (ABCompteInexistantException e) {
			System.out.println("Num�ro de compte inexistant");
			System.out.println(e.getMessage());
		}
	}

	// Affichage de tous les comptes d'un propri�taire 
	private void comptesDUnPropretaire() {
		Compte[] t;
		String nom;
		
		System.out.print("Propri�taire -> ");
		nom = this.lect.next();
		
		t = this.monAg.getComptesDe(nom);
		if (t.length == 0) {
			System.out.println("pas de compte � ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour " + nom);
			for (int i = 0; i < t.length; i++)
				t[i].afficher();
		}
	}

	// D�poser de l'argent sur un compte par saisie du num�ro de compte et du montant
	private void deposerSurUnCompte() {
		Compte c;
		String numero;
		double montant;
		
		System.out.print("Num compte -> ");
		numero = this.lect.next();
		System.out.print("Montant � d�poser -> ");
		montant = this.lect.nextDouble();
		c = this.monAg.getCompte(numero);
		if (c == null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant d�p�t: " + c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant d�pos�, solde : " + c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
	}

	// Retrait d'argent sur un compte par saisie du num�ro de compte et du montant
	private void retirerSurUnCompte() {
		String numero;
		double montant;
		Compte c;

		System.out.print("Num compte -> ");
		numero = this.lect.next();
		System.out.print("Montant � retirer -> ");
		montant = this.lect.nextDouble();
		c = this.monAg.getCompte(numero);
		if (c == null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retir�, solde : " + c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}

	}
}
