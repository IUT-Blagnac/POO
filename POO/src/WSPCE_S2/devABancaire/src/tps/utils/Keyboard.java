package tps.utils;

import java.io.*;

/************************************************************
 * Classe Keyboard offrant des services de saisie de donn�es au clavier de type
 * de base ainsi que String.<BR>
 * Saisie d'une valeur avec retour chariot en fin de saisie.<BR>
 * Propose un service de temporisation (attente d'une saisie sans retour de
 * valeur).<BR>
 * <BR>
 * Param�trage :<BR>
 * - arr�t ou continuation en cas d'erreur durant la saisie (pas de valeur
 * saisie ou valeur erron�e).<BR>
 * <BR>
 * D�faut :<BR>
 * - continuation en cas d'erreur durant la saisie.<BR>
 * - arr�t en cas d'erreur d'entr�e sur le flot d'entr�e (System.in).<BR>
 * <BR>
 * <U>Exemple :</U><BR>
 * <CODE>int i;<BR>
 * i = Keyboard.readInt();<BR>
 * </code><BR>
 * 
 * @see Keyboard#setContinueOnReadError() setContinueOnReadError
 * @see Keyboard#setStopOnReadError() setStopOnReadError
 *
 * @author Andr� P�ninou
 * @version 2.001
 *****************************/

final public class Keyboard {
	/*********************************
	 * Partie priv�e d'impl�mentation
	 **********************************/

	// Attributs
	private static BufferedReader streamReadIn = new BufferedReader(
			new InputStreamReader(System.in));

	private static boolean continueOnReadError = true;

	// M�thodes priv�es
	private static void testContinueOnReadError() {
		if (!(Keyboard.continueOnReadError)) {
			System.out
					.println("Arret sur erreur durant la saisie dans la classe Keyboard ...");
			System.exit(10001);
		}
	}

	private static void errorOnStream() {
		System.out
				.println("Arret car erreur sur flot d'entr�e dans la classe Keyboard ...");
		System.exit(10002);
	}

	// Constructuer par d�faut priv� pour �tre cach�

	private Keyboard() {
	}

	/*********************************
	 * Partie publique
	 **********************************/

	/**
	 * Saisie d'un caract�re (char).<BR>
	 * Attend la frappe d'une chaine et ne renvoie que le premier caract�re.<BR>
	 * En cas d'erreur de saisie, suivant le param�trage de la classe, attend
	 * une nouvelle saisie ou arr�te l'application.<BR>
	 * 
	 * @return Le caract�re saisi (char).
	 * @see Keyboard#setContinueOnReadError() setContinueOnReadError
	 * @see Keyboard#setStopOnReadError() setStopOnReadError
	 */
	public static char readChar() {
		String readString;
		char readValue = (char) 0;
		boolean continueWhileNotOk;
		try {
			continueWhileNotOk = true;
			while (continueWhileNotOk) {
				readString = Keyboard.streamReadIn.readLine();
				try {
					readValue = readString.charAt(0);
					continueWhileNotOk = false;
				} catch (IndexOutOfBoundsException e) {
					Keyboard.testContinueOnReadError();
				}
			}
		} catch (IOException e) {
			Keyboard.errorOnStream();
		}
		return readValue;
	}

	/**
	 * Saisie d'un entier (int).<BR>
	 * Attend la frappe d'une chaine et la convertit en entier.<BR>
	 * En cas d'erreur de saisie, suivant le param�trage de la classe, attend
	 * une nouvelle saisie ou arr�te l'application.<BR>
	 * 
	 * @return La valeur de l'entier saisi (int).
	 * @see Keyboard#setContinueOnReadError() setContinueOnReadError
	 * @see Keyboard#setStopOnReadError() setStopOnReadError
	 */

	public static int readInt() {
		String readString;
		int readValue = 0;
		boolean continueWhileNotOk;
		try {
			continueWhileNotOk = true;
			while (continueWhileNotOk) {
				readString = Keyboard.streamReadIn.readLine();
				try {
					readValue = Integer.parseInt(readString);
					continueWhileNotOk = false;
				} catch (NumberFormatException e) {
					Keyboard.testContinueOnReadError();
				}
			}
		} catch (IOException e) {
			Keyboard.errorOnStream();
		}
		return readValue;
	}

	/**
	 * Saisie d'un entier long (long).<BR>
	 * Attend la frappe d'une chaine et la convertit en entier long.<BR>
	 * En cas d'erreur de saisie, suivant le param�trage de la classe, attend
	 * une nouvelle saisie ou arr�te l'application.<BR>
	 * 
	 * @return La valeur de l'entier long saisi (long).
	 * @see Keyboard#setContinueOnReadError() setContinueOnReadError
	 * @see Keyboard#setStopOnReadError() setStopOnReadError
	 */

	public static long readLong() {
		String readString;
		long readValue = 0L;
		boolean continueWhileNotOk;
		try {
			continueWhileNotOk = true;
			while (continueWhileNotOk) {
				readString = Keyboard.streamReadIn.readLine();
				try {
					readValue = Long.parseLong(readString);
					continueWhileNotOk = false;
				} catch (NumberFormatException e) {
					Keyboard.testContinueOnReadError();
				}
			}
		} catch (IOException e) {
			Keyboard.errorOnStream();
		}
		return readValue;
	}

	/**
	 * Saisie d'un r�el (float).<BR>
	 * Attend la frappe d'une chaine et la convertit en r�el.<BR>
	 * En cas d'erreur de saisie, suivant le param�trage de la classe, attend
	 * une nouvelle saisie ou arr�te l'application.<BR>
	 * 
	 * @return La valeur du r�el saisi (float).
	 * @see Keyboard#setContinueOnReadError() setContinueOnReadError
	 * @see Keyboard#setStopOnReadError() setStopOnReadError
	 */

	public static float readFloat() {
		String readString;
		float readValue = 0F;
		boolean continueWhileNotOk;
		try {
			continueWhileNotOk = true;
			while (continueWhileNotOk) {
				readString = Keyboard.streamReadIn.readLine();
				try {
					readValue = Float.parseFloat(readString);
					continueWhileNotOk = false;
				} catch (NumberFormatException e) {
					Keyboard.testContinueOnReadError();
				}
			}
		} catch (IOException e) {
			Keyboard.errorOnStream();
		}
		return readValue;
	}

	/**
	 * Saisie d'un r�el double (double).<BR>
	 * Attend la frappe d'une chaine et la convertit en r�el double.<BR>
	 * En cas d'erreur de saisie, suivant le param�trage de la classe, attend
	 * une nouvelle saisie ou arr�te l'application.<BR>
	 * 
	 * @return La valeur du r�el double saisi (double).
	 * @see Keyboard#setContinueOnReadError() setContinueOnReadError
	 * @see Keyboard#setStopOnReadError() setStopOnReadError
	 */

	public static double readDouble() {
		String readString;
		double readValue = 0;
		boolean continueWhileNotOk;
		try {
			continueWhileNotOk = true;
			while (continueWhileNotOk) {
				readString = Keyboard.streamReadIn.readLine();
				try {
					readValue = Double.parseDouble(readString);
					continueWhileNotOk = false;
				} catch (NumberFormatException e) {
					Keyboard.testContinueOnReadError();
				}
			}
		} catch (IOException e) {
			Keyboard.errorOnStream();
		}
		return readValue;
	}

	/**
	 * Saisie d'une cha�ne de caract�re (String).<BR>
	 * Attend la frappe d'une chaine.<BR>
	 * En cas d'erreur de saisie, suivant le param�trage de la classe, attend
	 * une nouvelle saisie ou arr�te l'application.<BR>
	 * 
	 * @return Un nouvel objet String repr�sentant la cha�ne saisie (String).
	 * @see Keyboard#setContinueOnReadError() setContinueOnReadError
	 * @see Keyboard#setStopOnReadError() setStopOnReadError
	 */

	public static String readString() {
		String readValue = new String("");
		;
		try {
			readValue = Keyboard.streamReadIn.readLine();
		} catch (IOException e) {
			Keyboard.errorOnStream();
		}
		return readValue;
	}

	/**
	 * Permet de temporiser l'affichage en attendant la frappe de la touche
	 * return.<BR>
	 */

	public static void readForWait() {
		Keyboard.readForWait("");
	}

	/**
	 * Permet de temporiser l'affichage en attendant la frappe de la touche
	 * return.<BR>
	 * Affiche la chaine <CODE>message</CODE> avant d'attendre la frappe de la
	 * touche return.<BR>
	 * 
	 * @param message
	 *            La cha�ne de caract�re � afficher pour l'attente.
	 */

	public static void readForWait(String message) {
		System.out.print(message);
		try {
			String readString = Keyboard.streamReadIn.readLine();
		} catch (IOException e) {
			Keyboard.errorOnStream();
		}
	}

	/**
	 * Permet de param�trer la classe pour continuer � attendre une valeur
	 * correcte en cas d'erreur de saisie (m�me r�p�t�e).<BR>
	 * Ex d'erreur : on attend un int et la saisie r�alis�e est "abc".<BR>
	 * 
	 * @see Keyboard#setStopOnReadError() setStopOnReadError
	 */

	public static void setContinueOnReadError() {
		Keyboard.continueOnReadError = true;
	}

	/**
	 * Permet de param�trer la classe pour arr�ter l'application en cas d'erreur
	 * de saisie.<BR>
	 * Ex d'erreur : on attend un int et la saisie r�alis�e est "abc".<BR>
	 *
	 * @see Keyboard#setContinueOnReadError() setContinueOnReadError
	 */

	public static void setStopOnReadError() {
		Keyboard.continueOnReadError = false;
	}
}
