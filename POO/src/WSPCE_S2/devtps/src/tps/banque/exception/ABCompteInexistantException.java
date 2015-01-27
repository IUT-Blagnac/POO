package tps.banque.exception;

/************************************************************
 * Cette exception est levée par la Classe AgenceBancaire lorsque un compte n'existe pas dans l'agence.<BR>
 * 
 * @author André Péninou.
 * @version 3.0
 *****************************/

public class ABCompteInexistantException  extends Exception  {

	/**
	 * Constructeur par défaut.<BR>
	 */
	public ABCompteInexistantException() {
		this("Erreur sur un objet de la classe AgenceBancaire");
	}

	/**
	 * Constructeur paramétré.<BR>
	 * 
	 * @param message
	 *            information qui sera affichée si l'exception est affichée à
	 *            l'écran
	 */
	public ABCompteInexistantException(String message) {
		super(message);
	}

}
