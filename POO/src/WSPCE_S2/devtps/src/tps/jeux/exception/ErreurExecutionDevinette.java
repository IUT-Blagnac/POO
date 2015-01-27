
package tps.jeux.exception ;

/************************************************************
 * Cette exception est lev�e par la Classe Devinette lorsqu'une partie termin�e est "continu�e".<BR>
 * 
 * @author Andr� P�ninou.
 * @version 3.0
 *****************************/
public class ErreurExecutionDevinette extends Exception 
{
   public ErreurExecutionDevinette( String message)
   {
      super(message);
   }
}

