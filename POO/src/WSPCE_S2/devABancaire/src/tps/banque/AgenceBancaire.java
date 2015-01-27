package tps.banque;

import java.util.ArrayList;

import tps.banque.exception.ABCompteDejaExistantException;
import tps.banque.exception.ABCompteInexistantException;
import tps.banque.exception.ABCompteNullException;

/************************************************************
 * La classe AgenceBancaire permet de gérer une agence bancaire comme un ensemble de Comptes.<BR>
 * Une AgenceBancaire a un nom, une localisation (ville) et gère un ensemble de Comptes.<BR>
 * Exemple : agence "Agence Caisse Epargne" à "Pibrac".<BR>
 * Chaque Compte de l'AgenceBancaire a un numéro unique (vérification faite lors de l'ajout d'un Compte).<BR>
 * 
 * @author André Péninou.
 * @version 7.02
 *****************************/

public class AgenceBancaire {
	// Attributs
	private String nom, loc;
	private Cellule debutDeListe;
	private int nbElements;

	/**
	 * Constructeur paramétré.<BR>
	 * Permet de créer une AgenceBancaire en donnant son nom et sa ville.<BR>
	 * L'AgenceBancaire est initialisée avec 0 comptes.<BR>
	 * 
	 * @param pNomAgence
	 *            Le nom de l'AgenceBancaire.
	 * @param pLocAgence
	 *            La ville de localisation de l'AgenceBancaire.
	 */

	public AgenceBancaire(String pNomAgence, String pLocAgence) {
		this.nom = pNomAgence;
		this.loc = pLocAgence;
		this.debutDeListe = null;  // Initialisation liste : pas d'éléments.
		this.nbElements = 0;
	}

	/**
	 * Permet de connaître le nom de l'AgenceBancaire.<BR>
	 * <BR>
	 * 
	 * @return Le nom de l'AgenceBancaire.
	 */

	public String getNomAgence() {
		return this.nom;
	}

	/**
	 * Permet de connaître la localisation de l'AgenceBancaire.<BR>
	 * <BR>
	 * 
	 * @return La ville de localisation de l'AgenceBancaire.
	 */

	public String getLocAgence() {
		return this.loc;
	}

	/**
	 * Permet de connaître le nombre de Comptes existant dans l'AgenceBancaire.<BR>
	 * <BR>
	 * 
	 * @return Le nombre de comptes de l'AgenceBancaire.
	 */

	public int getNbComptes() {
		return this.nbElements;
	}

	/**
	 * Permet de retrouver un Compte de l'AgenceBancaire à partir de son numéro de
	 * compte (unique).<BR>
	 * Renvoie null si le Compte de numéro de compte pNumCompte n'est pas
	 * trouvé.<BR>
	 * <BR>
	 * 
	 * @param pNumCompte
	 *            Le numéro du Compte recherché.
	 * @see AgenceBancaire#addCompte(Compte)
	 * @return Le Compte de numéro pNumCompte, null si le compte n'est pas
	 *         trouvé.
	 */

	public Compte getCompte(String pNumCompte) {
		// A titre d'exemple : utilise une méthode privée définie en fin de
		// classe
		Compte c;
		
		c = this.trouveCompte(pNumCompte);
		return c;
	}

	/**
	 * Permet de retrouver les Comptes de l'AgenceBancaire correspondant à un nom de
	 * propriétaire donné.<BR>
	 * Renvoie un tableau du nombre de Comptes ayant pour propriétaire
	 * pNomProprietaire (et contenant les dits Comptes...).<BR>
	 * Si aucun Compte n'est trouvé, renvoie un tableau de longueur 0.<BR>
	 * <BR>
	 * 
	 * @param pNomProprietaire
	 *            Le nom du propriétaire de Compte dont on veut les Comptes.
	 * @see AgenceBancaire#addCompte(Compte)
	 * @return Un tableau des Comptes ayant pour propriétaire pNomProprietaire,
	 *         un tableau de longueur 0 si aucun compte n'est trouvé.
	 */

	public Compte[] getComptesDe(String pNomProprietaire) {
		/*
		 * Méthode : créer une ArrayList de Compte temporaire : alTemp. 
		 * Parcourir this.alCptes.
		 * 	Si un compe appartient au proprietaire 
		 * 		=> le garder dans alTemp.
		 * Si alTemp non vide : recopier tous les comptes de alTemp dans
		 * un nouveau tableau qui sera renvoyé 
		 * Sinon créer un tableau de 0 éléments.
		 */

		Compte t[], cTemp;
		ArrayList<Compte> alTemp; // ArrayList de Compte temporaire
		int nbCTemp, i;
		Cellule temp; 

		t = null;

		// Recherche des comptes de pNomProprietaire dans l'AgenceBancaire
		alTemp = new ArrayList<Compte>();
		temp = this.debutDeListe;
		while (temp != null) {
			cTemp = temp.getContenu();
			if (cTemp.getProprietaire().equals(pNomProprietaire)) {
				alTemp.add(cTemp);
			}
			temp = temp.getSuivant();
		}

		// Si on a trouvé des comptes ...
		if (alTemp.size() != 0) {
			// ... on crée un tableau et on les recopie
			nbCTemp = alTemp.size();
			t = new Compte[nbCTemp];
			for (i = 0; i < nbCTemp; i++) {
				t[i] = alTemp.get(i);
			}
			/*
			 * Ou bien directement, sans les lignes ci-dessus :
			 *		t = alTemp.toArray(new Compte[0]); 
			 * cf. doc ArrayList / T[] toArray(T[])
			 */
		} else {
			// ... pas de compte dans un tableau vide
			t = new Compte[0];
		}
		return t;
	}

	/**
	 * Permet d'afficher une AgenceBancaire -<B> SPECIAL TP.</B><BR>
	 * <BR>
	 * Affiche le nom de l'AgenceBancaire, sa localisation, le nombre de Comptes,
	 * chaque Compte avec son solde.<BR>
	 * <BR>
	 * <B>ATTENTION : Méthode spéciale pour les TP.</B><BR>
	 * <BR>
	 */

	public void afficher() {
		Compte cTemp;
		Cellule temp;

		System.out.println();
		System.out.println("Nom : " + this.nom + " (" + this.loc + ")");
		System.out.println("" + this.nbElements + " Comptes :");
		temp = this.debutDeListe;
		while (temp != null) {
			cTemp = temp.getContenu();
			cTemp.afficher();
			System.out.println("   Solde : " + cTemp.soldeCompte());
			temp = temp.getSuivant();
		}
		System.out.println();
	}

	/**
	 * Permet d'obtenir la représentation String d'une AgenceBancaire.<BR>
	 * <BR>
	 * Donne le nom de l'AgenceBancaire, la localisation, le nombre de Comptes.<BR>
	 * <BR>
	 */

	public String toString() {
		return "Nom Agence : " + this.nom + " (" + this.loc + ") : "+this.nbElements+" cptes";
	}
	
	/**
	 * Permet d'ajouter un Compte à l'AgenceBancaire.<BR>
	 * Le Compte pCompteAAjouter est ajouté à l'AgenceBancaire s'il n'existe pas déjà un Compte
	 * ayant le même numéro de compte que pCompteAAjouter 
	 * (identique en numéro de compte à pCompteAAjouter.getNumCompte()).<BR>
	 * Si on appelle la méthode avec null en paramètre, la méthode lève une exception.<BR>
	 * 
	 * @param pCompteAAjouter
	 *            Le Compte à ajouter à l'AgenceBancaire.
	 * @throws ABCompteNullException  lorsque pCompteAAjouter == null	
	 * @throws ABCompteDejaExistantException  lorsque un compte de numéro pCompteAAjouter.getNumCompte() existe déjà dans l'AgenceBancaire.
	 * @see AgenceBancaire#removeCompte(String)
	 */

	public void addCompte(Compte pCompteAAjouter) throws ABCompteNullException, ABCompteDejaExistantException {
		Cellule newCel, temp, pred;
		boolean positionTrouvee, erreurExiste;
		
		// Si null => refusé
		if (pCompteAAjouter == null) {
			throw new ABCompteNullException("Erreur ajout Compte 'null' dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		}

		// ... on parcours pour soit trouver le Compte, soit l'ajouter 
		
		erreurExiste = false;
		
		if (debutDeListe == null) {
			// premier compte de la liste
			debutDeListe = new Cellule (pCompteAAjouter, null);
			this.nbElements = this.nbElements + 1;
		} else {
			if (pCompteAAjouter.getNumCompte().compareToIgnoreCase(debutDeListe.getContenu().getNumCompte())<0) {
				// en première position
				newCel = new Cellule (pCompteAAjouter, null);
				newCel.setSuivant(debutDeListe);
				debutDeListe = newCel;
				this.nbElements = this.nbElements + 1;
			} else {
				if (pCompteAAjouter.getNumCompte().compareToIgnoreCase(debutDeListe.getContenu().getNumCompte()) == 0) {
					// Pb, le compte existe
					erreurExiste = true;
				} else {
					pred = debutDeListe;
					temp = debutDeListe.getSuivant();
					positionTrouvee = false;
					while (temp != null && !positionTrouvee && !erreurExiste) {
						if (temp.getContenu().getNumCompte().compareToIgnoreCase(pCompteAAjouter.getNumCompte())<0) {
							pred = temp;
							temp = temp.getSuivant();
						} else {
							if (temp.getContenu().getNumCompte().compareToIgnoreCase(pCompteAAjouter.getNumCompte()) == 0) {
								// Pb, le compte existe
								erreurExiste = true; 
							} else {
								positionTrouvee = true;
							}
						}
					}
					if (! erreurExiste) {
						newCel = new Cellule (pCompteAAjouter, null);
						newCel.setSuivant(pred.getSuivant());
						pred.setSuivant(newCel);
						this.nbElements = this.nbElements + 1;
					}
				}
			}
		}
		if (erreurExiste) {
			throw new ABCompteDejaExistantException(
					"Erreur ajout Compte déja existant ("
					+ pCompteAAjouter.getNumCompte() + ") dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		}

	}
	
	/* Autre méthode BIEN MOINS optimisée car deux parcours de la liste
	public void addCompte(Compte pCompteAAjouter) throws ABCompteNullException, ABCompteDejaExistantException {
		Cellule newCel, temp, pred;
		boolean positionTrouvee;
		
		Compte c;
		
		// Si null => refusé
		if (pCompteAAjouter == null) {
			throw new ABCompteNullException("Erreur ajout Compte 'null' dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		}

		// On cherche un Compte de même numéro
		c = this.trouveCompte(pCompteAAjouter.getNumCompte());

		// Si trouvé
		if (c != null) {
			throw new ABCompteDejaExistantException(
					"Erreur ajout Compte déja existant ("
					+ pCompteAAjouter.getNumCompte() + ") dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		}

		// ... on ajoute le Compte 
		
		newCel = new Cellule (pCompteAAjouter, null);
		if (debutDeListe == null) {
			// premier compte de la liste
			debutDeListe = newCel;
		} else {
			if (pCompteAAjouter.getNumCompte().compareToIgnoreCase(debutDeListe.getContenu().getNumCompte())<=0) {
				// en première position
				newCel.setSuivant(debutDeListe);
				debutDeListe = newCel;
			} else {
				pred = debutDeListe;
				temp = debutDeListe.getSuivant();
				positionTrouvee = false;
				while (temp != null && !positionTrouvee) {
					if (temp.getContenu().getNumCompte().compareToIgnoreCase(pCompteAAjouter.getNumCompte())<=0) {
						pred = temp;
						temp = temp.getSuivant();
					} else {
						positionTrouvee = true;
					}
				}
				newCel.setSuivant(pred.getSuivant());
				pred.setSuivant(newCel);
			}
		}
		this.nbElements = this.nbElements + 1;
	}
	*/

	/**
	 * Permet de supprimer un Compte de l'AgenceBancaire, à partir de son numéro.<BR>
	 * Le Compte (unique) de numéro pNumCompte est retiré de l'AgenceBancaire s'il est
	 * trouvé.<BR>
	 * Une exception est levée si le compte n'est pas trouvé.<BR>
	 * 
	 * @param pNumCompte
	 *            Le numéro du Compte à supprimer de l'AgenceBancaire.
	 * @throws ABCompteInexistantException	Lorsque aucun compte de numéro pNumCompte ne peut être trouvé.
	 * @see AgenceBancaire#addCompte(Compte)
	 */
	public void removeCompte(String pNumCompte) throws ABCompteInexistantException {
		Cellule temp, pred ;
		boolean trouve;
	
		
		// On cherche un Compte de même numéro
		// Il y a plusieurs algos possibles
		temp = this.debutDeListe;
		pred = null;
		trouve = false;
		while (temp != null && ! trouve) {
			if (temp.getContenu().getNumCompte().equals(pNumCompte)) {
				trouve = true;
			} else {
				pred = temp;
				temp = temp.getSuivant();
			}
		}

		// Si pas trouvé ...
		if (! trouve) {
			throw new ABCompteInexistantException(
					"Erreur suppression Compte inexistant ("
					+ pNumCompte+ ") dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		}
		
		// ... on, enlève 
		if (pred == null) { // premier élément de la liste
			this.debutDeListe = this.debutDeListe.getSuivant();
		} else { // au milieu ou à la fin
			pred.setSuivant(temp.getSuivant());
		}
		this.nbElements = this.nbElements - 1;
	}
	
	/**
	 * Méthode privée de recherche du Compte e la Cellule contenant un compte.
	 * Cherche la cellule contenant un compte ayant pour numéro de compte pNC.
	 * Renvoie null si aucun compte n'est trouvé.
	 *
	 * @param      pNC  numéro du compte recherché
	 * @return     la cellule contenant l'objet Compte trouvé ayant pour numéro pNC ou null si non trouvé. 
	 */
	private Compte trouveCompte(String pNC) {
		Compte cTemp, solution;
		Cellule temp ;
		boolean fini;
		
		solution = null;
		temp = this.debutDeListe;
		fini = false;
		while (temp != null && solution == null && !fini) { // solution== null : est superflue
			cTemp = temp.getContenu();
			// Si un Compte a le même numéro que pNC
			if (cTemp.getNumCompte().equals(pNC)) {
				// ... on le garde
				solution = temp.getContenu();
				fini = true;
			} else {
				if (cTemp.getNumCompte().compareToIgnoreCase(pNC) <= 0 ) {
					// il faut regarder le suivant
					temp = temp.getSuivant();
				} else {
					// il ne peut pas être après
					fini = true;
				}
			}
		}
		return solution;
	}
}