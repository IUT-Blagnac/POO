package tps.utils;

/************************************************************
 * Classe Conversion permettant d'effectuer des tests et des conversions de String vers int 
 * ou float et inversement.<BR>
 * <BR>
 * <BR><U>Exemple :</U><BR>
 * <CODE>int i;<BR>
 * String s;<BR>
 * i = Keyboard.readInt();<BR>
 * s = Conversion.intToString(i);<BR>
 * System.out.println (s);<BR>
 * s = Keyboard.readString();<BR>
 * if (Conversion.isIntConvertible(s)) {<BR>
 * &nbsp;&nbsp;i = Conversion.intConvert(s);<BR>
 * &nbsp;&nbsp;System.out.println ("Valeur saisie en int : " + i);<BR>
 * } else {<BR>
 * &nbsp;&nbsp;System.out.println ("Valeur saisie invalide (" + s +")" );<BR>
 * }<BR>
 * </CODE></BR>
 * @author André Péninou 
 * @version 3.001
*****************************/

final public class Conversion
{

	private Conversion ()
	{}

    /*********************************
        Partie publique
    **********************************/

/**
 * Test de conversion chaine -> int.<BR>
 * Détermine si la chaîne en entrée est convertible en int.<BR>
 * Exemple : <BR>
 * <code>Conversion.isIntConvertible("10") donnera true <BR>
 * Conversion.isIntConvertible("10A") donnera false</code><BR>
 * <BR>
 * @param		value	La chaîne de caractère à tester (String).
 * @return		<code>true</code> si value convertible en int, <code>false</code> sinon.
 * @see         Conversion#intConvert	intConvert
 */
    public static boolean isIntConvertible(String value)
    {
		int val = 0 ;
		boolean ok ;
		
		try 
		{
			val = Integer.parseInt (value) ;
			ok = true ;
		}
		catch (NumberFormatException ne)
		{
			ok=false;
		}
		return ok;
	}

/**
 * Conversion chaine -> int.<BR>
 * Convertit la chaîne en entrée en int.<BR>
 * <BR>ATTENTION : PRECONDITION : <CODE>Conversion.isIntConvertible (value)</CODE> doit valoir <code>true</code>.<BR>
 * Arrête le programme dans le cas contraire (exception).<BR>
 * @param		value	La chaîne de caractère à convertir (String).
 * @return		la valeur int convertie de value.
 * @see         Conversion#isIntConvertible	isIntConvertible
 */
    public static int intConvert(String value)
    {
		int val = 0 ;
		
		val = Integer.parseInt (value) ;
		return val;
	}	

/**
 * Conversion int -> chaine.<BR>
 * @param		valInt	La valeur int à convertir en chaîne.
 * @return		la valeur chaîne (String) convertie de valInt.
 */
    public static String intToString(int valInt)
    {
		Integer i = new Integer (valInt);
		return i.toString();
	}	


/**
 * Test de conversion chaine -> float.<BR>
 * Détermine si la chaîne en entrée est convertible en float.<BR>
 * Exemple : <BR>
 * <code>Conversion.isFloatConvertible("10") donnera true <BR>
 * Conversion.isFloatConvertible("10.025") donnera true <BR>
 * Conversion.isFloatConvertible("10.01A") donnera false</code><BR>
 * <BR>
 * @param		value	La chaîne de caractère à tester (String).
 * @return		<code>true</code> si value convertible en float, <code>false</code> sinon.
 * @see         Conversion#floatConvert	floatConvert
 */
    public static boolean isFloatConvertible(String value)
    {
		float val = 0 ;
		boolean ok ;
		
		try 
		{
			val = Float.parseFloat (value) ;
			ok = true ;
		}
		catch (NumberFormatException ne)
		{
			ok=false;
		}
		return ok;
	}

/**
 * Conversion chaine -> float.<BR>
 * Convertit la chaîne en entrée en float.<BR>
 * <BR>ATTENTION : PRECONDITION : <CODE>Conversion.isFloatConvertible (value)</CODE> doit valoir <code>true</code>.<BR>
 * Arrête le programme dans le cas contraire (exception).
 * @param		value	La chaîne de caractère à convertir (String).
 * @return		la valeur float convertie de value.
 * @see         Conversion#isFloatConvertible	isFloatConvertible
 */
    public static float floatConvert(String value)
    {
		float val = 0 ;
		
		val = Float.parseFloat (value) ;
		return val;
	}	

/**
 * Conversion float -> chaine.<BR>
 * @param		valFloat	La valeur float à convertir en chaîne.
 * @return		la valeur chaîne (String) convertie de valFloat.
 */
    public static String floatToString(float valFloat)
    {
		Float f = new Float(valFloat);
		return f.toString();
	}	


/**
 * Test de conversion chaine -> double.<BR>
 * Détermine si la chaîne en entrée est convertible en double.<BR>
 * Exemple : <BR>
 * <code>Conversion.isDoubleConvertible("10") donnera true <BR>
 * Conversion.isDoubleConvertible("10.025") donnera true <BR>
 * Conversion.isDoubleConvertible("10.01A") donnera false</code><BR>
 * <BR>
 * @param		value	La chaîne de caractère à tester (String).
 * @return		<code>true</code> si value convertible en double, <code>false</code> sinon.
 * @see         Conversion#doubleConvert	doubleConvert
 */
    public static boolean isDoubleConvertible(String value)
    {
		double val = 0 ;
		boolean ok ;
		
		try 
		{
			val = Double.parseDouble (value) ;
			ok = true ;
		}
		catch (NumberFormatException ne)
		{
			ok=false;
		}
		return ok;
	}

/**
 * Conversion chaine -> double.<BR>
 * Convertit la chaîne en entrée en double.<BR>
 * <BR>ATTENTION : PRECONDITION : <CODE>Conversion.isDoubleConvertible (value)</CODE> doit valoir <code>true</code>.<BR>
 * Arrête le programme dans le cas contraire(exception).
 * @param		value	La chaîne de caractère à convertir (String).
 * @return		la valeur double convertie de value.
 * @see         Conversion#isDoubleConvertible	isDoubleConvertible
 */
    public static double doubleConvert(String value)
    {
		double val = 0 ;
		
		val = Double.parseDouble (value) ;
		return val;
	}	

/**
 * Conversion double -> chaine.<BR>
 * @param		valDouble	La valeur double à convertir en chaîne.
 * @return		la valeur chaîne (String) convertie de valDouble.
 */
    public static String doubleToString(double valDouble)
    {
		Double f = new Double(valDouble);
		return f.toString();
	}	

}
