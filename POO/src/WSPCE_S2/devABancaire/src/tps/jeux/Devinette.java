package tps.jeux;

import tps.jeux.exception.ErreurExecutionDevinette;

/************************************************************
 * Classe Devinette permettant de faire des jeux de "devinette de nombres".<BR>
 * A la cr�ation, un objet Devinette est configur� avec les 2 bornes du jeu
 * (haute : [40, 50], basse : [10, 20]) et la valeur � rechercher. Ces valeurs
 * ne sont pas modifiables par la suite.<BR>
 * On peut soumettre un coup � une Devinette ("jouer") et tester ensuite si le
 * dernier coup jou� est gagnant, trop haut ou trop bas. <BR>
 * Lorsque la valeur � chercher a �t� trouv�e, la partie est consid�r�e
 * "termin�e" et on ne devra plus soumettre de coup. Les autres op�rations de
 * tests restent disponibles.<BR>
 * <BR>
 * <BR>
 * <U>Exemple :</U><BR>
 * <code>Devinette d;<BR>
 * d = new Devinette();<BR>
 * d.soumettreCoup(35);<BR>
 * if (d.isDernierCoupGagnant())<BR>
 *  System.out.println ("Gagn�");<BR>
 * <BR></code>
 * 
 * @author Andr� P�ninou
 * @version 2.09
 **/

public class Devinette {
	private int bas; // Borne basse
	private int haut; // Borne haute
	private int nbCoups; // Nb Coups joues
	private int aDeviner; // Nombre a deviner
	private boolean existeDCJ;
	// Indicateur de jeu : true si soumettreCoup a �t� appel�e une fois
	// Permet de savoir si on est au premier coup ou pas
	private int dernierCoupJoue; // Dernier coup jou� par soumettreCoup

	/**
	 * Constructeur de Devinette qui initialise un objet Devinette pr�t � �tre
	 * utilis�. Permet de :<BR>
	 * - Tirer au sort la borne sup�rieure ([40, 50]) et la borne inf�rieure
	 * ([10, 20]) du jeu.<BR>
	 * - Tirer au sort la valeur � rechercher entre les bornes chosies
	 * ci-dessus.<BR>
	 * Exemple : borne inf 12, bone sup 47, valeur � chercher 22.<BR>
	 */
	public Devinette() {
		this.bas = Devinette.tireAuSortVal(ParametresDevinette.BAS1,
				ParametresDevinette.BAS2);
		this.haut = Devinette.tireAuSortVal(ParametresDevinette.HAUT1,
				ParametresDevinette.HAUT2);
		this.aDeviner = Devinette.tireAuSortVal(this.bas, this.haut);
		this.nbCoups = 0;
		this.existeDCJ = false;
		this.dernierCoupJoue = -1;
	}

	private static int tireAuSortVal(int pBInf, int pBSup) {
		double alea;
		int res;

		alea = Math.random();
		res = (int) Math.round(alea * (pBSup - pBInf) + pBInf);
		return res;
	}

	/**
	 * Soumettre un coup ("jouer" une valeur) � une devinette.<BR>
	 * Permet de soumettre un coup dans le cas o� :<BR>
	 * - Soit aucun coup n'a encore �t� jou� (d�but de partie).<BR>
	 * - Soit le dernier coup jou� n'�tait pas gagnant (partie en cours, non
	 * finie). <BR>
	 * <BR>
	 * <B>ATTENTION : </B>L�ve une exception si le coup pr�c�dent �tait gagnant.<BR>
	 * C'est dire que si <code>isDernierCoupGagnant()</code> vaut
	 * <code>true</code>, car la partie est consid�r�e termin�e.<BR>
	 * 
	 * @param valeurJouee
	 *            coup (valeur) que l'on souhaite soummettre � la devinette.
	 * @throws ErreurExecutionDevinette
	 *             lorsque on joue un coup ET que la partie �tait termin�e
	 *             (valeur trouv�e au soumettreCoup() pr�c�dent)
	 * 
	 * @see Devinette#isDernierCoupGagnant() isDernierCoupGagnant()
	 * @see Devinette#isDernierCoupTropHaut() isDernierCoupTropHaut()
	 * @see Devinette#isDernierCoupTropBas() isDernierCoupTropBas()
	 */
	public void soumettreCoup(int valeurJouee) throws ErreurExecutionDevinette {
		if (!this.existeDCJ
				|| (this.existeDCJ && (this.dernierCoupJoue != this.aDeviner))) {
			this.nbCoups++;
			this.existeDCJ = true;
			this.dernierCoupJoue = valeurJouee;
		} else {
			throw new ErreurExecutionDevinette(
					"Erreur, Coup joue sur Devinette finie ...\nArret du programme\n");
		}
	}

	/**
	 * Permet de tester si une valeur est situ�e entre les bornes du jeu
	 * (incluses).<BR>
	 * 
	 * @param val
	 *            valeur que l'on souhaite tester.
	 * @return <code>true</code> ou <code>false</code> selon le cas.
	 */

	public boolean isValeurDansBornes(int val) {
		if (val < this.bas || val > this.haut)
			return false;
		else
			return true;
	}

	/**
	 * Permet de tester si le dernier coup jou� est gagnant ou pas.<BR>
	 * Permet de tester si le dernier coup jou� par la m�thode
	 * <code>soumettreCoup</code> a �t� gagnant ou pas. <BR>
	 * Retourne <code>false</code> si aucun coup n'a encore �t� jou�.
	 * 
	 * @return <code>true</code> ou <code>false</code> selon le cas.
	 * @see Devinette#soumettreCoup(int) soumettreCoup(int)
	 */

	public boolean isDernierCoupGagnant() {
		if (this.existeDCJ)
			return this.dernierCoupJoue == this.aDeviner;
		else
			return false;
	}

	/**
	 * Permet de tester si le dernier coup jou� est trop haut.<BR>
	 * Permet de savoir si le dernier coup jou� par la m�thode
	 * <code>soumettreCoup</code> a �t� trop haut (bonne valeur plus petite).<BR>
	 * Retourne <code>false</code> si aucun coup n'a encore �t� jou�.
	 * 
	 * @return <code>true</code> ou <code>false</code> selon le cas.
	 * @see Devinette#soumettreCoup(int) soumettreCoup(int)
	 */

	public boolean isDernierCoupTropHaut() {
		if (this.existeDCJ)
			return this.dernierCoupJoue > this.aDeviner;
		else
			return false;
	}

	/**
	 * Permet de tester si le dernier coup jou� est trop bas.<BR>
	 * Permet de savoir si le dernier coup jou� par la m�thode
	 * <code>soumettreCoup</code> a �t� trop bas (bonne valeur plus grande).<BR>
	 * Retourne <code>false</code> si aucun coup n'a encore �t� jou�.
	 * 
	 * @return <code>true</code> ou <code>false</code> selon le cas.
	 * @see Devinette#soumettreCoup(int) soumettreCoup(int)
	 */
	public boolean isDernierCoupTropBas() {
		if (this.existeDCJ)
			return this.dernierCoupJoue < this.aDeviner;
		else
			return false;
	}

	/**
	 * Permet d'obtenir le nombre de coups d�j� jou�s � une devinette.<BR>
	 * 
	 * @return nombre de coups jou�s.
	 */
	public int getNbCoupsJoues() {
		return this.nbCoups;
	}

	/**
	 * Permet d'obtenir la borne haute du jeu tir�e au sort � la cr�ation de
	 * l'objet.<BR>
	 * 
	 * @return borne haute du jeu.
	 */
	public int getHaut() {
		return this.haut;
	}

	/**
	 * Permet d'obtenir la borne basse du jeu tir�e au sort � la cr�ation de
	 * l'objet.<BR>
	 * 
	 * @return borne basse du jeu.
	 */
	public int getBas() {
		return this.bas;
	}
}
