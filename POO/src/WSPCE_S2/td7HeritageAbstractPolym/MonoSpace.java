
public class  MonoSpace  extends  Voiture
{
   public  void  afficher  ()
   {
       System.out.println  ("MonoSpace ");
       super.afficher();
   }
   public  void  afficher  (int decalage)
	{
	   int  i;
	   for  (i=0;  i<decalage;  i++)  System.out.print(" ");
	   this.afficher();
   }
   public double  coutReel  () 
   {
		return super.coutReel ()  * 2 ;
   }
} // Fin Classe MonoSpace
