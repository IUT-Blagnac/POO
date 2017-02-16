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

public class AgenceBancaireS {
	// Attributs
	private String nom, loc;
	private ArrayList<Compte> alCptes;

	/**
	 * Constructeur paramétré.<BR>
	 * Permet de créer une AgenceBancaire en donnant son nom et sa ville.<BR>
	 * L'AgenceBancaire est initialisée avec 0 comptes.<BR>
	 * 
	 * @param pfNomAgence
	 *            Le nom de l'AgenceBancaire.
	 * @param pfLocAgence
	 *            La ville de localisation de l'AgenceBancaire.
	 */

	public AgenceBancaire(String pfNomAgence, String pfLocAgence) {
		this.nom = pfNomAgence;
		this.loc = pfLocAgence;
		this.alCptes = new ArrayList<Compte>();
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
		return this.alCptes.size();
	}

	/**
	 * Permet de retrouver un Compte de l'AgenceBancaire à partir de son numéro de
	 * compte (unique).<BR>
	 * Renvoie null si le Compte de numéro de compte donné n'est pas
	 * trouvé.<BR>
	 * <BR>
	 * 
	 * @param pfNumCompte
	 *            Le numéro du Compte recherché.
	 * @see AgenceBancaire#addCompte(Compte)
	 * @return Le Compte de numéro pNumCompte, null si le compte n'est pas
	 *         trouvé.
	 */

	public Compte getCompte(String pfNumCompte) {
		// A titre d'exemple : utilise une méthode privée définie en fin de
		// classe
		int rang = this.trouveCompte(pfNumCompte);
		if (rang != -1) {
			return this.alCptes.get(rang);
		}
		return null;
	}

	/**
	 * Permet de retrouver les Comptes de l'AgenceBancaire correspondant à un nom de
	 * propriétaire donné.<BR>
	 * Renvoie un tableau du nombre de Comptes ayant pour propriétaire
	 * le nom de priopriétaire donné (et contenant les Comptes correspondants...).<BR>
	 * Si aucun Compte n'est trouvé, renvoie un tableau de longueur 0.<BR>
	 * <BR>
	 * 
	 * @param pfNomProprietaire
	 *            Le nom du propriétaire de Compte dont on veut les Comptes.
	 * @see AgenceBancaire#addCompte(Compte)
	 * @return Un tableau des Comptes ayant pour propriétaire pNomProprietaire,
	 *         un tableau de longueur 0 si aucun compte n'est trouvé.
	 */

	public Compte[] getComptesDe(String pfNomProprietaire) {
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
		nbC = this.alCptes.size();
		for (i = 0; i < nbC; i++) {
			cTemp = alCptes.get(i);
			if (cTemp.getProprietaire().equals(pfNomProprietaire)) {
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

		/*
		// Autre solution possible : sans ArrayList temporaire
	 	public Compte[] getComptesDeZ (String pfNomProprietaire)
		{
			Compte t[], cTemp;
			int nbC, nbCCourants, i, j;
			
			t=null;
			
			// On compte les comptes de pNomProprietaire
			nbC = 0;
			nbCCourants = this.vCpt.size();
			for (i=0; i<nbCCourants; i++)
			{
				cTemp = alCptes.get(i);
				if (cTemp.getProprietaire().equals(pfNomProprietaire)) {
					nbC++;
				}
			}
			
			// Si on a trouvé des comptes ...
			if (nbC != 0)
			{
				// ...  on crée un tableau et on les recherche à nouveau
				// pour les recopier
				t = new Compte[nbC];
				j=0;
				nbCCourants = this.alCptes.size();
				for (i=0; i<nbCCourants; i++)
				{
					cTemp = alCptes.get(i);
					if (cTemp.getProprietaire().equals(pfNomProprietaire)) {
						t[j++] = cTemp;
					}
				}
			}
			else {
				t=new Compte[0];
			}
	
			return t;
		}
		*/
	 

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
		System.out.println("" + this.alCptes.size() + " Comptes :");
		nbC = this.alCptes.size();
		for (i = 0; i < nbC; i++) {
			cTemp = alCptes.get(i);
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
		return "Nom Agence : " + this.nom + " (" + this.loc + ") : "+this.alCptes.size()+" cptes";
	}
	
	/**
	 * Permet d'ajouter un Compte à l'AgenceBancaire.<BR>
	 * Le Compte est ajouté à l'AgenceBancaire s'il n'existe pas déjà un Compte
	 * ayant le même numéro de compte  
	 * (identique en numéro de compte, cf. méthode getNumCompte() de la classe Compte).<BR>
	 * Si on appelle la méthode avec null en paramètre, la méthode lève une exception.<BR>
	 * 
	 * @param pfCompteAAjouter
	 *            Le Compte à ajouter à l'AgenceBancaire.
	 * @throws ABCompteNullException  lorsque pCompteAAjouter == null	
	 * @throws ABCompteDejaExistantException  lorsque un compte de numéro pCompteAAjouter.getNumCompte() existe déjà dans l'AgenceBancaire.
	 * @see AgenceBancaire#removeCompte(String)
	 */

	public void addCompte(Compte pfCompteAAjouter) throws ABCompteNullException, ABCompteDejaExistantException {
		int rang; 
		
		// Si null => refusé
		if (pfCompteAAjouter == null) {
			throw new ABCompteNullException("Erreur ajout Compte 'null' dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		}

		// On cherche un Compte de même numéro
		rang = this.trouveCompte(pfCompteAAjouter.getNumCompte());

		// Si trouvé
		if (rang != -1) {
			// => refusé
			throw new ABCompteDejaExistantException(
					"Erreur ajout Compte déja existant ("
					+ pfCompteAAjouter.getNumCompte() + ") dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		} else {
			// sinon ... on ajoute le Compte
			this.alCptes.add(pfCompteAAjouter);

		}
	}

	/**
	 * Permet de supprimer un Compte de l'AgenceBancaire, à partir de son numéro.<BR>
	 * Le Compte (unique) du numéro donné est retiré de l'AgenceBancaire s'il est
	 * trouvé.<BR>
	 * Une exception est levée si le compte n'est pas trouvé.<BR>
	 * 
	 * @param pfNumCompte
	 *            Le numéro du Compte à supprimer de l'AgenceBancaire.
	 * @throws ABCompteInexistantException	Lorsque aucun compte de numéro pNumCompte ne peut être trouvé.
	 * @see AgenceBancaire#addCompte(Compte)
	 */
	
	public void removeCompte(String pfNumCompte) throws ABCompteInexistantException{
		int rang;

		// On cherche un Compte de même numéro
		rang = this.trouveCompte(pfNumCompte);

		// Si pas trouvé ...
		if (rang == -1) {
			// ... erreur
			throw new ABCompteInexistantException(
					"Erreur suppression Compte inexistant ("
					+ pfNumCompte+ ") dans l'agence " 
					+ this.nom + " (" + this.loc + ")");
		} else {
			// ... on enlève ce Compte
			this.alCptes.remove(rang);
		}
	}


	/**
	 * Méthode privée de recherche du Compte de la Cellule contenant un compte.
	 * Cherche la cellule contenant un compte ayant pour numéro le numéro en paramètre.
	 * Renvoie null si aucun compte n'est trouvé.
	 *
	 * @param      pfNC  numéro du compte recherché
	 * @return     la cellule contenant l'objet Compte trouvé ayant pour numéro pNC ou null si non trouvé. 
	 */
	
	private int trouveCompte(String pfNC) {
		Compte cTemp;
		int i, nbC;
		int rang; 
		// On parcours l'ArrayList de l'AgenceBancaire
		nbC = this.alCptes.size();
		rang = -1;
		for (i = 0; i < nbC && rang == -1; i++) {
			cTemp = alCptes.get(i);
			// Si un Compte a le même numéro que pNC
			if (cTemp.getNumCompte().equals(pfNC)) {
				// ... on garde son rang
				rang = i;
			}
		}
		return rang;
	}
}