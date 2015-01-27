
public class TestVoitMonoSpace
{
	public static void main(String[] args)
	{
			Voiture v;
			MonoSpace ms;
			
			v = new Voiture ();
			
			v.setNumeroImmat("999 DD 31");
			v.setNoSerie(10);
			v.afficher();
			
			ms = new MonoSpace ();
			ms.setNoSerie(10);
			ms.afficher();			
			ms.afficher ();
			
		
	}
}
