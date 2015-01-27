package tps.utils;

import java.io.*;

/************************************************************
 * Classe Keyboard offrant des services de saisie de données au clavier de type
 * de base ainsi que String.<BR>
 * Saisie d'une valeur avec retour chariot en fin de saisie.<BR>
 * Propose un service de temporisation (attente d'une saisie sans retour de
 * valeur).<BR>
 * <BR>
 * Paramétrage :<BR>
 * - arrêt ou continuation en cas d'erreur durant la saisie (pas de valeur
 * saisie ou valeur erronée).<BR>
 * <BR>
 * Défaut :<BR>
 * - continuation en cas d'erreur durant la saisie.<BR>
 * - arrêt en cas d'erreur d'entrée sur le flot d'entrée (System.in).<BR>
 * <BR>
 * <U>Exemple :</U><BR>
 * <CODE>int i;<BR>
 * i = Keyboard.readInt();<BR>
 * </code><BR>
 * 
 * @see Keyboard#setContinueOnReadError() setContinueOnReadError
 * @see Keyboard#setStopOnReadError() setStopOnReadError
 *
 * @author André Péninou
 * @version 2.001
 *****************************/

final public class Keyboard {
	/*********************************
	 * Partie privée d'implémentation
	 **********************************/

	// Attributs
	private static BufferedReader streamReadIn = new BufferedReader(
			new InputStreamReader(System.in));

	private static boolean continueOnReadError = true;

	// Méthodes privées
	private static void testContinueOnReadError() {
		if (!(Keyboard.continueOnReadError)) {
			System.out
					.println("Arret sur erreur durant la saisie dans la classe Keyboard ...");
			System.exit(10001);
		}
	}

	private static void errorOnStream() {
		System.out
				.println("Arret car erreur sur flot d'entrée dans la classe Keyboard ...");
		System.exit(10002);
	}

	// Constructuer par défaut privé pour être caché

	private Keyboard() {
	}

	/*********************************
	 * Partie publique
	 **********************************/

	/**
	 * Saisie d'un caractère (char).<BR>
	 * Attend la frappe d'une chaine et ne renvoie que le premier caractère.<BR>
	 * En cas d'erreur de saisie, suivant le paramètrage de la classe, attend
	 * une nouvelle saisie ou arrête l'application.<BR>
	 * 
	 * @return Le caractère saisi (char).
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
	 * En cas d'erreur de saisie, suivant le paramètrage de la classe, attend
	 * une nouvelle saisie ou arrête l'application.<BR>
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
	 * En cas d'erreur de saisie, suivant le paramètrage de la classe, attend
	 * une nouvelle saisie ou arrête l'application.<BR>
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
	 * Saisie d'un réel (float).<BR>
	 * Attend la frappe d'une chaine et la convertit en réel.<BR>
	 * En cas d'erreur de saisie, suivant le paramètrage de la classe, attend
	 * une nouvelle saisie ou arrête l'application.<BR>
	 * 
	 * @return La valeur du réel saisi (float).
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
	 * Saisie d'un réel double (double).<BR>
	 * Attend la frappe d'une chaine et la convertit en réel double.<BR>
	 * En cas d'erreur de saisie, suivant le paramètrage de la classe, attend
	 * une nouvelle saisie ou arrête l'application.<BR>
	 * 
	 * @return La valeur du réel double saisi (double).
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
	 * Saisie d'une chaîne de caractère (String).<BR>
	 * Attend la frappe d'une chaine.<BR>
	 * En cas d'erreur de saisie, suivant le paramètrage de la classe, attend
	 * une nouvelle saisie ou arrête l'application.<BR>
	 * 
	 * @return Un nouvel objet String représentant la chaîne saisie (String).
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
	 *            La chaîne de caractère à afficher pour l'attente.
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
	 * Permet de paramétrer la classe pour continuer à attendre une valeur
	 * correcte en cas d'erreur de saisie (même répétée).<BR>
	 * Ex d'erreur : on attend un int et la saisie réalisée est "abc".<BR>
	 * 
	 * @see Keyboard#setStopOnReadError() setStopOnReadError
	 */

	public static void setContinueOnReadError() {
		Keyboard.continueOnReadError = true;
	}

	/**
	 * Permet de paramétrer la classe pour arrêter l'application en cas d'erreur
	 * de saisie.<BR>
	 * Ex d'erreur : on attend un int et la saisie réalisée est "abc".<BR>
	 *
	 * @see Keyboard#setContinueOnReadError() setContinueOnReadError
	 */

	public static void setStopOnReadError() {
		Keyboard.continueOnReadError = false;
	}
}
