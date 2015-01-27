package tps.banque;

import java.util.ArrayList;

import tps.banque.exception.ABCompteDejaExistantException;
import tps.banque.exception.ABCompteInexistantException;
import tps.banque.exception.ABCompteNullException;

// V TAB DYN +1 -1

/************************************************************
 * La classe AgenceBancaire permet de g�rer une agence bancaire comme un ensemble de Comptes.<BR>
 * Une AgenceBancaire a un nom, une localisation (ville) et g�re un ensemble de Comptes.<BR>
 * Exemple : agence "Agence Caisse Epargne" � "Pibrac".<BR>
 * Chaque Compte de l'AgenceBancaire a un num�ro unique (v�rification faite lors de l'ajout d'un Compte).<BR>
 * 
 * @author Andr� P�ninou.
 * @version 7.02
 *****************************/

public class AgenceBancaireX {
	// Attributs
	private String nom, loc;
	private Compte tableauDesComptes[]; // Tableau des comptes

	/**
	 * Constructeur param�tr�.<BR>
	 * Permet de cr�er une AgenceBancaire en donnant son nom et sa ville.<BR>
	 * L'AgenceBancaire est initialis�e avec 0 comptes.<BR>
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
	 * Permet de conna�tre le nom de l'AgenceBancaire.<BR>
	 * <BR>
	 * 
	 * @return Le nom de l'AgenceBancaire.
	 */

	public String getNomAgence() {
		return this.nom;
	}

	/**
	 * Permet de conna�tre la localisation de l'AgenceBancaire.<BR>
	 * <BR>
	 * 
	 * @return La ville de localisation de l'AgenceBancaire.
	 */

	public String getLocAgence() {
		return this.loc;
	}

	/**
	 * Permet de conna�tre le nombre de Comptes existant dans l'AgenceBancaire.<BR>
	 * <BR>
	 * 
	 * @return Le nombre de comptes de l'AgenceBancaire.
	 */

	public int getNbComptes() {
		return this.tableauDesComptes.length;
	}

	/**
	 * Permet de retrouver un Compte de l'AgenceBancaire � partir de son num�ro de
	 * compte (unique).<BR>
	 * Renvoie null si le Compte de num�ro de compte pNumCompte n'est pas
	 * trouv�.<BR>
	 * <BR>
	 * 
	 * @param pNumCompte
	 *            Le num�ro du Compte recherch�.
	 * @see AgenceBancaire#addCompte(Compte)
	 * @return Le Compte de num�ro pNumCompte, null si le compte n'est pas
	 *         trouv�.
	 */

	public Compte getCompte(String pNumCompte) {
		// A titre d'exemple : utilise une m�thode priv�e d�finie en fin de
		// classe
		Compte c;
		c = this.trouveCompte(pNumCompte);
		return c;
	}

	/**
	 * Permet de retrouver les Comptes de l'AgenceBancaire correspondant � un nom de
	 * propri�taire donn�.<BR>
	 * Renvoie un tableau du nombre de Comptes ayant pour propri�taire
	 * pNomProprietaire (et contenant les dits Comptes...).<BR>
	 * Si aucun Compte n'est trouv�, renvoie un tableau de longueur 0.<BR>
	 * <BR>
	 * 
	 * @param pNomProprietaire
	 *            Le nom du propri�taire de Compte dont on veut les Comptes.
	 * @see AgenceBancaire#addCompte(Compte)
	 * @return Un tableau des Comptes ayant pour propri�taire pNomProprietaire,
	 *         un tableau de longueur 0 si aucun compte n'est trouv�.
	 */

	public Compte[] getComptesDe(String pNomProprietaire) {
		/*
		 * M�thode : cr�er une ArrayList de Compte temporaire : alTemp. 
		 * Parcourir this.alCptes.
		 * 	Si un compe appartient au proprietaire 
		 * 		=> le garder dans alTemp.
		 * Si alTemp non vide : recopier tous les comptes de alTemp dans
		 * un nouveau tableau qui sera renvoy� 
		 * Sinon cr�er un tableau de 0 �l�ments.
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

		// Si on a trouv� des comptes ...
		if (alTemp.size() != 0) {
			// ... on cr�e un tableau et on les recopie
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
	 * <B>ATTENTION : M�thode sp�ciale pour les TP.</B><BR>
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
	 * Permet d'obtenir la repr�sentation String d'une AgenceBancaire.<BR>
	 * <BR>
	 * Donne le nom de l'AgenceBancaire, la localisation, le nombre de Comptes.<BR>
	 * <BR>
	 */

	public String toString() {
		return "Nom Agence : " + this.nom + " (" + this.loc + ") : "+this.tableauDesComptes.length+" cptes";
	}
	
	/**
	 * Permet d'ajouter un Compte � l'AgenceBancaire.<BR>
	 * Le Compte pCompteAAjouter est ajout� � l'AgenceBancaire s'il n'existe pas d�j� un Compte
	 * ayant le m�me num�ro de compte que pCompteAAjouter 
	 * (identique en num�ro de compte � pCompteAAjouter.getNumCompte()).<BR>
	 * Si on appelle la m�thode avec null en param�tre, la m�thode l�ve une exception.<BR>
	 * 
	 * @param pCompteAAjouter
	 *            Le Compte � ajouter � l'AgenceBancaire.
	 * @throws ABCompteNullException  lorsque pCompteAAjouter == null	
	 * @throws ABCompteDejaExistantException  lorsque un compte de num�ro pCompteAAjouter.getNumCompte() existe d�j� dans l'AgenceBancaire.
	 * @see AgenceBancaire#removeCompte(String)
	 */

	public void addCompte(Compte pCompteAAjouter) throws ABCompteNullException, ABCompteDejaExistantException {
		int taille, i;
		Compte t[];
		Compte c;
		
		// Si null => refus�
		if (pCompteAAjouter == null) {
			throw new ABCompteNullException("Erreur ajout Compte 'null' dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		}

		// On cherche un Compte de m�me num�ro
		c = this.trouveCompte(pCompteAAjouter.getNumCompte());

		// Si trouv�
		if (c != null) {
			throw new ABCompteDejaExistantException(
					"Erreur ajout Compte d�ja existant ("
					+ pCompteAAjouter.getNumCompte() + ") dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		}
		// ... on ajoute le Compte � la fin du tableau que l'on "agrandit"
		taille = this.tableauDesComptes.length;
		t = new Compte[taille + 1];
		for (i=0; i<taille; i++) {
			t[i] = this.tableauDesComptes[i];
		}
		t[taille] = pCompteAAjouter;
		this.tableauDesComptes = t;
	}

	/**
	 * Permet de supprimer un Compte de l'AgenceBancaire, � partir de son num�ro.<BR>
	 * Le Compte (unique) de num�ro pNumCompte est retir� de l'AgenceBancaire s'il est
	 * trouv�.<BR>
	 * Une exception est lev�e si le compte n'est pas trouv�.<BR>
	 * 
	 * @param pNumCompte
	 *            Le num�ro du Compte � supprimer de l'AgenceBancaire.
	 * @throws ABCompteInexistantException	Lorsque aucun compte de num�ro pNumCompte ne peut �tre trouv�.
	 * @see AgenceBancaire#addCompte(Compte)
	 */
	public void removeCompte(String pNumCompte) throws ABCompteInexistantException{
		int rangCompte ;
		int taille, i, j;
		Compte t[];
		
		// On cherche un Compte de m�me num�ro
		rangCompte = this.trouveRangDeCompte(pNumCompte);

		// Si pas trouv� ...
		if (rangCompte == -1) {
			throw new ABCompteInexistantException(
					"Erreur suppression Compte inexistant ("
					+ pNumCompte+ ") dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		}
		// ... on enl�ve ce Compte dans un tableau "r�tr�ci"
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
	 * M�thode priv�e de recherche du rang d'un compte.
	 * Cherche un compte dans le tableau de comptes ayant pour num�ro de compte pNC.
	 * Renvoie -1 si aucun compte n'est trouv�.
	 *
	 * @param      pNC  num�ro du compte recherch�
	 * @return     l'indice de l'objet compte trouv� ou -1 si non trouv�. 
	 */
	private int trouveRangDeCompte(String pNC) {
		Compte cTemp;
		int i, nbC, rang;

		// On parcours le tableau des comptes de l'AgenceBancaire
		nbC = this.tableauDesComptes.length;
		rang = -1;
		for (i = 0; i < nbC && rang == -1; i++) {
			cTemp = this.tableauDesComptes[i];
			// Si un Compte a le m�me num�ro que pNC
			if (cTemp.getNumCompte().equals(pNC)) {
				// ... on le garde
				rang = i;
			}
		}
		return rang;
	}
	
	/**
	 * M�thode priv�e de recherche d'un compte.
	 * Cherche un compte dans alCptes ayant pour num�ro de compte pNC.
	 * Renvoie null si aucun compte n'est trouv�.
	 *
	 * @param      pNC  num�ro du compte recherch�
	 * @return     l'objet compte (la r�f�rence de) trouv� ou null si non trouv�. 
	 */
	private Compte trouveCompte(String pNC) {
		Compte c, cTemp;
		int i, nbC;

		// On parcours le tableau des comptes de l'AgenceBancaire
		nbC = this.tableauDesComptes.length;
		c = null;
		for (i = 0; i < nbC && c == null; i++) {
			cTemp = this.tableauDesComptes[i];
			// Si un Compte a le m�me num�ro que pNC
			if (cTemp.getNumCompte().equals(pNC)) {
				// ... on le garde
				c = cTemp;
			}
		}
		return c;
	}
}