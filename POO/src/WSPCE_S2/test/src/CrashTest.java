import java.util.Locale;
import java.util.Scanner;

public class CrashTest {
	public static void main(String[] args) {
		
		Scanner lect ;					// TD 4 - Classe Pile
		int i, nbValSuppl;

		int [] tabCourant ;

		lect = new Scanner (System.in) ;
		lect.useLocale(Locale.US);

		tabCourant = new int [5];

		for ( i=0 ; i< tabCourant.length ; i++) {
		    tabCourant[i] = lect.nextInt();  // <1> Remplissage
		}


		
		System.out.println("   Nb Valeurs en plus ? : -> ");
		nbValSuppl = lect.nextInt();
		// A faire ici
		
		int[] nouvTab = new int [tabCourant.length+nbValSuppl];
		for (i=0;i< tabCourant.length; i++) {
			nouvTab[i] = tabCourant[i];
		}
		tabCourant = nouvTab;

		
		
		for ( i=5 ; i< tabCourant.length ; i++) { // de 5 au nb de valeurs saisies
			   tabCourant[i] = lect.nextInt();   // <2> Remplissage compl�mentaire
			}

			for ( i=0; i< tabCourant.length ; i++) {
			    System.out.println(tabCourant[i]); 
			    // Affichera les 5 valeurs saisies au d�part <1> 
			    // + les valeurs ajout�es en <2>
			}

	}
}
