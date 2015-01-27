package tps.jeux;

import tps.jeux.exception.ErreurExecutionDevinette;

/************************************************************
 * Classe Devinette permettant de faire des jeux de "devinette de nombres".<BR>
 * A la création, un objet Devinette est configuré avec les 2 bornes du jeu
 * (haute : [40, 50], basse : [10, 20]) et la valeur à rechercher. Ces valeurs
 * ne sont pas modifiables par la suite.<BR>
 * On peut soumettre un coup à une Devinette ("jouer") et tester ensuite si le
 * dernier coup joué est gagnant, trop haut ou trop bas. <BR>
 * Lorsque la valeur à chercher a été trouvée, la partie est considérée
 * "terminée" et on ne devra plus soumettre de coup. Les autres opérations de
 * tests restent disponibles.<BR>
 * <BR>
 * <BR>
 * <U>Exemple :</U><BR>
 * <code>Devinette d;<BR>
 * d = new Devinette();<BR>
 * d.soumettreCoup(35);<BR>
 * if (d.isDernierCoupGagnant())<BR>
 *  System.out.println ("Gagné");<BR>
 * <BR></code>
 * 
 * @author André Péninou
 * @version 2.09
 **/

public class Devinette {
	private int bas; // Borne basse
	private int haut; // Borne haute
	private int nbCoups; // Nb Coups joues
	private int aDeviner; // Nombre a deviner
	private boolean existeDCJ;
	// Indicateur de jeu : true si soumettreCoup a été appelée une fois
	// Permet de savoir si on est au premier coup ou pas
	private int dernierCoupJoue; // Dernier coup joué par soumettreCoup

	/**
	 * Constructeur de Devinette qui initialise un objet Devinette prêt à être
	 * utilisé. Permet de :<BR>
	 * - Tirer au sort la borne supérieure ([40, 50]) et la borne inférieure
	 * ([10, 20]) du jeu.<BR>
	 * - Tirer au sort la valeur à rechercher entre les bornes chosies
	 * ci-dessus.<BR>
	 * Exemple : borne inf 12, bone sup 47, valeur à chercher 22.<BR>
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
	 * Soumettre un coup ("jouer" une valeur) à une devinette.<BR>
	 * Permet de soumettre un coup dans le cas où :<BR>
	 * - Soit aucun coup n'a encore été joué (début de partie).<BR>
	 * - Soit le dernier coup joué n'était pas gagnant (partie en cours, non
	 * finie). <BR>
	 * <BR>
	 * <B>ATTENTION : </B>Lève une exception si le coup précédent était gagnant.<BR>
	 * C'est dire que si <code>isDernierCoupGagnant()</code> vaut
	 * <code>true</code>, car la partie est considérée terminée.<BR>
	 * 
	 * @param valeurJouee
	 *            coup (valeur) que l'on souhaite soummettre à la devinette.
	 * @throws ErreurExecutionDevinette
	 *             lorsque on joue un coup ET que la partie était terminée
	 *             (valeur trouvée au soumettreCoup() précédent)
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
	 * Permet de tester si une valeur est située entre les bornes du jeu
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
	 * Permet de tester si le dernier coup joué est gagnant ou pas.<BR>
	 * Permet de tester si le dernier coup joué par la méthode
	 * <code>soumettreCoup</code> a été gagnant ou pas. <BR>
	 * Retourne <code>false</code> si aucun coup n'a encore été joué.
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
	 * Permet de tester si le dernier coup joué est trop haut.<BR>
	 * Permet de savoir si le dernier coup joué par la méthode
	 * <code>soumettreCoup</code> a été trop haut (bonne valeur plus petite).<BR>
	 * Retourne <code>false</code> si aucun coup n'a encore été joué.
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
	 * Permet de tester si le dernier coup joué est trop bas.<BR>
	 * Permet de savoir si le dernier coup joué par la méthode
	 * <code>soumettreCoup</code> a été trop bas (bonne valeur plus grande).<BR>
	 * Retourne <code>false</code> si aucun coup n'a encore été joué.
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
	 * Permet d'obtenir le nombre de coups déjà joués à une devinette.<BR>
	 * 
	 * @return nombre de coups joués.
	 */
	public int getNbCoupsJoues() {
		return this.nbCoups;
	}

	/**
	 * Permet d'obtenir la borne haute du jeu tirée au sort à la création de
	 * l'objet.<BR>
	 * 
	 * @return borne haute du jeu.
	 */
	public int getHaut() {
		return this.haut;
	}

	/**
	 * Permet d'obtenir la borne basse du jeu tirée au sort à la création de
	 * l'objet.<BR>
	 * 
	 * @return borne basse du jeu.
	 */
	public int getBas() {
		return this.bas;
	}
}
