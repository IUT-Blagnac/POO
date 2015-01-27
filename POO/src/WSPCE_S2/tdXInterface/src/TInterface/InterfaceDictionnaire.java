package igdictionnaire;

/************************************************************
    Interface InterfaceDictionnaire.
    Définit les opérations nécessaires pour un dictionnaire<BR>
    qui pourra être affiché 
    dans une interface graphique de dictionnaire IGInterface.<BR>
    
    @author	André Péninou.
	@version	1.2
	
	@see IGInterface
*****************************/
public interface InterfaceDictionnaire
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
   public abstract String  definitionMot (String pMot);
}
