
/************************************************************
 * Cette exception est levée par la Classe Compte lorsque un débit ou crédit
 * n'est pas possible. <BR>
 * 
 * @author André Péninou.
 * @version 3.0
 *****************************/

public class CompteException extends Exception {

	/**
	 * Constructeur par défaut.<BR>
	 */
	public CompteException() {
		super("Erreur sur un objet de la classe Compte");
	}

	/**
	 * Constructeur paramétré.<BR>
	 * 
	 * @param message
	 *            information qui sera affichée si l'exception est affichée à
	 *            l'écran
	 */
	public CompteException(String message) {
		super(message);
	}
}
