package igdictionnaire ;


/************************************************************
    Classe AbstractDictionnaire permettant de g�rer un dictionnaire.<BR>
    Un dictionnaire AbstractDictionnaire pourra �tre affich� 
    dans une interface graphique de dictionnaire IGClasseAbstraite.<BR>
    Cette classe d�finit les m�thodes attendues sur le dictionnaire, 
    m�thodes que IGClasseAbstraite appelera.
    
    @author	Andr� P�ninou.
	@version	1.2
	
	@see IGClasseAbstraite
*****************************/

public abstract class AbstractDictionnaire
{
	/**
	 	Obtenir la lite de tous les mots du dictionnaire.<BR>
	 	<BR>
	 	Permet d'obtenir un tableau contenant toutes les chaines
	 	de caract�res de tous les mots du dictionnaire.<BR>
	 	<BR>

	 	@return		Le tableau de tous les mots du dictionnaire.
	*/
	public abstract String[] listeMots ();
	
	
	/**
	 	Obtenir la d�finition d'un mot du dictionnaire.<BR>
	 	<BR>
	 	Permet d'obtenir la d�finition du mot pMot.<BR>
	 	<BR>

		@param		pMot	Le mot dont on veut la d�finition
	 	@return		La chaine de caract�res de d�finition du mot pMot.<BR>Renvoie une chaine vide ("") si le mot est absent du dictionnaire.
	*/
	public abstract String definitionMot (String pMot);
}
