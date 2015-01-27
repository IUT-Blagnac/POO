
package tps.jeux.exception ;

/************************************************************
 * Cette exception est levée par la Classe Devinette lorsqu'une partie terminée est "continuée".<BR>
 * 
 * @author André Péninou.
 * @version 3.0
 *****************************/
public class ErreurExecutionDevinette extends Exception 
{
   public ErreurExecutionDevinette( String message)
   {
      super(message);
   }
}

