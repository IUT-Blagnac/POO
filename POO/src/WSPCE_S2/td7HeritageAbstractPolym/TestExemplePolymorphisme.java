
public class TestExemplePolymorphisme
{
	public static void main (String argv[])
	{
		int i;
	
		Vehicule v ;
		// v = new Vehicule ();
		
		
		
		
		
		Vehicule garage [];
		
		garage = new Vehicule [4];
		
		MonoSpace ms;
		
		garage[0] = new Voiture ("Opel", 1203, "704 AQW 31");
		
		ms = new MonoSpace ();
		ms.setNumeroImmat ("MS 001");
		garage[1] = ms;

		garage[2] = new Voiture ("Citroen", 4589, "746 APN 31");
		
		ms = new MonoSpace ();
		ms.setNumeroImmat ("MS 222");
		garage[3] = ms;

		for (i=0; i<4; i++)
			garage[i].rouler (100); // Méthode de Vehicule

		for (i=0; i<4; i++)
		{
			System.out.println ("--- garage, rang : " + i);
			garage[i].afficher();  // Méthode de Vehicule
			System.out.println ("  Cout réel : : " + garage[i].coutReel());  // Méthode de Vehicule
			System.out.println ();
		}	
		
		//garage [0] = new Object();
		//garage [0] = new String("");
		
	}
}
