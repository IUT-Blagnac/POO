import java.util.ArrayList;
import java.util.Iterator;
public class ClasseEssaiArrayList {
	private static int MAX = 5;
	public static void main(String[] arguments) {
		int i, taille;
		
		ArrayList <String> alChaines;
		
		alChaines = new ArrayList<String> ();
		
		alChaines.add ("Chaine 1");
		alChaines.add ("Chaine 2");
		alChaines.add ("Chaine 3");
		alChaines.add ("Chaine 4");
		alChaines.add ("Chaine 5");
		
		System.out.println ("Size : "+alChaines.size());
		// size : nb éléments présents dans l'ArrayList.

		taille = alChaines.size();
		for (i=0 ; i<taille; i++)
			System.out.println ("chaine en "+i+" : "+alChaines.get(i));
		
		alChaines.add (0, "Toto");
		System.out.println ("Size : "+alChaines.size());
		
		alChaines.add (1, "Tata")	;
		System.out.println ("Size : "+alChaines.size());

		alChaines.add (alChaines.size(), "Tutu")	;
		System.out.println ("Size : "+alChaines.size());

		alChaines.add (alChaines.size()/2, "Titi")	;
		System.out.println ("Size : "+alChaines.size());

		taille = alChaines.size();
		for (i=0 ; i<taille; i++)
			System.out.println ("chaine en "+i+" : "+alChaines.get(i));

		for (i=0; i<ClasseEssaiArrayList.MAX; i++) {
			alChaines.add ("Chaine " + i);
		}
		
		System.out.println ("Size : "+alChaines.size());
		taille = alChaines.size();
		for (i=0 ; i<taille; i++)
			System.out.println ("chaine en "+i+" : "+alChaines.get(i));
		
		alChaines.set(0,"BLABLA");
		alChaines.set(alChaines.size()-1,"BLABLA");
		alChaines.set(alChaines.size()/2 - alChaines.size()/4,"BLABLA");
		alChaines.set(alChaines.size()/2 + alChaines.size()/4,"BLABLA");
		
		System.out.println ("Size : "+alChaines.size());
		taille = alChaines.size();
		for (i=0 ; i<taille; i++)
			System.out.println ("chaine en "+i+" : "+alChaines.get(i));
		
		System.out.println(alChaines.toString());
		
		alChaines.remove(alChaines.size()-1);
		System.out.println ("Size : "+alChaines.size());
		alChaines.remove(0);
		System.out.println ("Size : "+alChaines.size());
		alChaines.remove(alChaines.size()/2 - alChaines.size()/4);
		System.out.println ("Size : "+alChaines.size());
		alChaines.remove(alChaines.size()/2 + alChaines.size()/4);
		System.out.println ("Size : "+alChaines.size());
		
		System.out.println ("Size : "+alChaines.size());
		taille = alChaines.size();
		for (i=0 ; i<taille; i++)
			System.out.println ("chaine en "+i+" : "+alChaines.get(i));
		
		// Tests finaux optionnels
		
		System.out.println("AFFICHAGE PAR ITERATEUR");
		Iterator<String> it ;
		it = alChaines.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		for (String s : alChaines) {
			System.out.println ( s.toUpperCase() + " lg : " + s.length() );
		}
		
		System.out.println(alChaines.iterator().getClass());
	}
}
