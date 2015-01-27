package tps.banque;

/**
 * La classe Cellule permet de gérer les "mailons" d'une liste châinée de Compte.<BR>
 * Chaque Cellule contient : <BR>
 * - un contenu : un objet de la classe Compte,<BR>
 * - un suivant : la référence vers la Cellule suivante.<BR>
 *  
 * @author André PENINOU
 */
public class Cellule {
    private Compte contenu;    // Compte contenu dans la Cellule
    private Cellule suivant;   // Lien vers la Cellule suivante.

    /**
     * Constructeur de Cellule. 
     * Initialise une Cellule avec le contenu pVal et la Cellule suivante pSuiv.<BR>
     *  
     * @param pVal	contenu de la Cellule créée.
     * @param pSuiv	Cellule suivante de la Cellule créée. null est une valeur possible.
     */
    public Cellule (Compte pVal, Cellule pSuiv) {
            this.contenu = pVal;
            this.suivant = pSuiv;
    }
    
    // Accesseurs
    
    /**
     * Obtenir le contenu de la Cellule.<BR>  
     * @return	Compte contenu dans la Cellule
     */
    public Compte getContenu () {
            return this.contenu;
    }
    /**
     * Obtenir la Cellule suivante de la Cellule.<BR>  
     * @return	Cellule suivante, null si fin de liste chaînée.
     */
    public Cellule getSuivant () {
            return this.suivant;
    }
    
    // Modifieurs
    
    /**
     * Modifier le contenu de la Cellule.<BR> 
     * @param pVal	contenu de la Cellule.
     */
    public void setContenu (Compte pVal) {
            this.contenu = pVal;
    }
    /**
     * Modifier la Cellule suivante de la Cellule.<BR>  
     * pSuiv	Cellule suivante de la Cellule. null est une valeur possible.
     */
    public void setSuivant (Cellule pSuiv) {
            this.suivant = pSuiv;
    }
}