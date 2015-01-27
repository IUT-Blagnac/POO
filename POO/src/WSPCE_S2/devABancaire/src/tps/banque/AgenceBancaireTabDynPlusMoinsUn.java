package tps.banque;

import java.util.ArrayList;

import tps.banque.exception.ABCompteDejaExistantException;
import tps.banque.exception.ABCompteInexistantException;
import tps.banque.exception.ABCompteNullException;

// V TAB DYN +1 -1

/************************************************************
 * La classe AgenceBancaire permet de gérer une agence bancaire comme un ensemble de Comptes.<BR>
 * Une AgenceBancaire a un nom, une localisation (ville) et gère un ensemble de Comptes.<BR>
 * Exemple : agence "Agence Caisse Epargne" à "Pibrac".<BR>
 * Chaque Compte de l'AgenceBancaire a un numéro unique (vérification faite lors de l'ajout d'un Compte).<BR>
 * 
 * @author André Péninou.
 * @version 7.02
 *****************************/

public class AgenceBancaireX {
	// Attributs
	private String nom, loc;
	private Compte tableauDesComptes[]; // Tableau des comptes

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
		this.tableauDesComptes = new Compte[0];
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
		return this.tableauDesComptes.length;
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
		int nbC, nbCTemp, i;

		t = null;

		// Recherche des comptes de pNomProprietaire dans l'AgenceBancaire
		alTemp = new ArrayList<Compte>();
		nbC = this.tableauDesComptes.length;
		for (i = 0; i < nbC; i++) {
			cTemp = this.tableauDesComptes[i];
			if (cTemp.getProprietaire().equals(pNomProprietaire)) {
				alTemp.add(cTemp);
			}
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
		int i, nbC;
		Compte cTemp;

		System.out.println();
		System.out.println("Nom : " + this.nom + " (" + this.loc + ")");
		System.out.println("" + this.tableauDesComptes.length + " Comptes :");
		nbC = this.tableauDesComptes.length;
		for (i = 0; i < nbC; i++) {
			cTemp = this.tableauDesComptes[i];
			cTemp.afficher();
			System.out.println("   Solde : " + cTemp.soldeCompte());
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
		return "Nom Agence : " + this.nom + " (" + this.loc + ") : "+this.tableauDesComptes.length+" cptes";
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
		int taille, i;
		Compte t[];
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
		// ... on ajoute le Compte à la fin du tableau que l'on "agrandit"
		taille = this.tableauDesComptes.length;
		t = new Compte[taille + 1];
		for (i=0; i<taille; i++) {
			t[i] = this.tableauDesComptes[i];
		}
		t[taille] = pCompteAAjouter;
		this.tableauDesComptes = t;
	}

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
	public void removeCompte(String pNumCompte) throws ABCompteInexistantException{
		int rangCompte ;
		int taille, i, j;
		Compte t[];
		
		// On cherche un Compte de même numéro
		rangCompte = this.trouveRangDeCompte(pNumCompte);

		// Si pas trouvé ...
		if (rangCompte == -1) {
			throw new ABCompteInexistantException(
					"Erreur suppression Compte inexistant ("
					+ pNumCompte+ ") dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		}
		// ... on enlève ce Compte dans un tableau "rétréci"
		taille = this.tableauDesComptes.length - 1;
		t = new Compte[taille];
		j=0;
		for (i=0; i<rangCompte; i++) {
			t[j] = this.tableauDesComptes[i];
			j++;
		}
		for (i=rangCompte+1; i<taille+1; i++) {
			t[j] = this.tableauDesComptes[i];
			j++;
		}
		this.tableauDesComptes = t;
	}

	/**
	 * Méthode privée de recherche du rang d'un compte.
	 * Cherche un compte dans le tableau de comptes ayant pour numéro de compte pNC.
	 * Renvoie -1 si aucun compte n'est trouvé.
	 *
	 * @param      pNC  numéro du compte recherché
	 * @return     l'indice de l'objet compte trouvé ou -1 si non trouvé. 
	 */
	private int trouveRangDeCompte(String pNC) {
		Compte cTemp;
		int i, nbC, rang;

		// On parcours le tableau des comptes de l'AgenceBancaire
		nbC = this.tableauDesComptes.length;
		rang = -1;
		for (i = 0; i < nbC && rang == -1; i++) {
			cTemp = this.tableauDesComptes[i];
			// Si un Compte a le même numéro que pNC
			if (cTemp.getNumCompte().equals(pNC)) {
				// ... on le garde
				rang = i;
			}
		}
		return rang;
	}
	
	/**
	 * Méthode privée de recherche d'un compte.
	 * Cherche un compte dans alCptes ayant pour numéro de compte pNC.
	 * Renvoie null si aucun compte n'est trouvé.
	 *
	 * @param      pNC  numéro du compte recherché
	 * @return     l'objet compte (la référence de) trouvé ou null si non trouvé. 
	 */
	private Compte trouveCompte(String pNC) {
		Compte c, cTemp;
		int i, nbC;

		// On parcours le tableau des comptes de l'AgenceBancaire
		nbC = this.tableauDesComptes.length;
		c = null;
		for (i = 0; i < nbC && c == null; i++) {
			cTemp = this.tableauDesComptes[i];
			// Si un Compte a le même numéro que pNC
			if (cTemp.getNumCompte().equals(pNC)) {
				// ... on le garde
				c = cTemp;
			}
		}
		return c;
	}
}