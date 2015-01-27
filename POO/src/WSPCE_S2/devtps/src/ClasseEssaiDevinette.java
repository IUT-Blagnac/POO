
import java.util.Scanner;
import tps.jeux.Devinette;
import tps.jeux.exception.ErreurExecutionDevinette;

public class ClasseEssaiDevinette {

	private static void jouer (Devinette d) throws ErreurExecutionDevinette
	{
		int val;
		Scanner in;
		
		in = new Scanner(System.in);
		
		System.out.print("Coup : ("+d.getBas()+"-"+d.getHaut()+") : ");
		val = in.nextInt();
		d.soumettreCoup (val);
		while (!d.isDernierCoupGagnant())
		{
			if (d.isDernierCoupTropBas()) 
				System.out.print("Plus Haut ... ");
			else
				System.out.print("Plus Bas ... ");
				
			System.out.print("Coup : ("+d.getBas()+"-"+d.getHaut()+") : ");
			val = in.nextInt();
			d.soumettreCoup (val);
		}
		System.out.println("Bravo, en "+d.getNbCoupsJoues()+" coups.");
	}
	public static void main2 () throws ErreurExecutionDevinette
	{
		Devinette d;
		int i;
		
		for (i=0; i<3; i++)
		{
			d = new Devinette() ;
			ClasseEssaiDevinette.jouer (d);
		}
	}
	public static void main1 () throws ErreurExecutionDevinette
	{
		Devinette d;
	
		d = new Devinette() ;
		ClasseEssaiDevinette.jouer (d);
			
		d.soumettreCoup (20); // Plantage car partie finie ...
	}
	public static void main (String argv[]) throws ErreurExecutionDevinette
	{
		System.out.println("Exo 1");
		ClasseEssaiDevinette.main1();
		
		System.out.println("Exo 2");
		ClasseEssaiDevinette.main2();
	}
}