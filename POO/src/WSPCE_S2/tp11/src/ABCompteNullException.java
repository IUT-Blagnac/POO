

/************************************************************
 * Cette exception est levée par la Classe AgenceBancaire lorsque un compte avec valeur null est ajouté à l'agence.<BR>
 * 
 * @author André Péninou.
 * @version 3.0
 *****************************/

public class ABCompteNullException extends Exception {

	/**
	 * Constructeur par défaut.<BR>
	 */
	public ABCompteNullException() {
		this("Erreur sur un objet de la classe AgenceBancaire");
	}

	/**
	 * Constructeur paramétré.<BR>
	 * 
	 * @param message
	 *            information qui sera affichée si l'exception est affichée à
	 *            l'écran
	 */
	public ABCompteNullException(String message) {
		super(message);
	}
}



