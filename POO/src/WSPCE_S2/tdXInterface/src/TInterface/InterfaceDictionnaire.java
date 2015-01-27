package igdictionnaire;

/************************************************************
    Interface InterfaceDictionnaire.
    D�finit les op�rations n�cessaires pour un dictionnaire<BR>
    qui pourra �tre affich� 
    dans une interface graphique de dictionnaire IGInterface.<BR>
    
    @author	Andr� P�ninou.
	@version	1.2
	
	@see IGInterface
*****************************/
public interface InterfaceDictionnaire
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
   public abstract String  definitionMot (String pMot);
}
