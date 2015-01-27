package igdictionnaire ;


/************************************************************
    Classe AbstractDictionnaire permettant de gérer un dictionnaire.<BR>
    Un dictionnaire AbstractDictionnaire pourra être affiché 
    dans une interface graphique de dictionnaire IGClasseAbstraite.<BR>
    Cette classe définit les méthodes attendues sur le dictionnaire, 
    méthodes que IGClasseAbstraite appelera.
    
    @author	André Péninou.
	@version	1.2
	
	@see IGClasseAbstraite
*****************************/

public abstract class AbstractDictionnaire
{
	/**
	 	Obtenir la lite de tous les mots du dictionnaire.<BR>
	 	<BR>
	 	Permet d'obtenir un tableau contenant toutes les chaines
	 	de caractères de tous les mots du dictionnaire.<BR>
	 	<BR>

	 	@return		Le tableau de tous les mots du dictionnaire.
	*/
	public abstract String[] listeMots ();
	
	
	/**
	 	Obtenir la définition d'un mot du dictionnaire.<BR>
	 	<BR>
	 	Permet d'obtenir la définition du mot pMot.<BR>
	 	<BR>

		@param		pMot	Le mot dont on veut la définition
	 	@return		La chaine de caractères de définition du mot pMot.<BR>Renvoie une chaine vide ("") si le mot est absent du dictionnaire.
	*/
	public abstract String definitionMot (String pMot);
}
