import java.util.Scanner;

class Magasin {
  public static void main(String[] arguments){
    Article[] tabStock = new Article[1000];
    Scanner lecteur = new Scanner(System.in);
    boolean fini = false ;
    int indice = 0 ;
    while ((! fini) && ( indice < 1000)) {
        System.out.println("Nom et Numéro de l'article ?");
        String nom = lecteur.next();
        int numero = lecteur.nextInt();
        tabStock[indice] = new Article(nom,numero);
        indice = indice + 1 ;
        System.out.println("Encore ? (O/N)");
        String reponse = lecteur.next();
        if ( reponse.equals("N") || reponse.equals("n")) { fini = true ; }
    }
  }
  public static int[] stockCategories(Article[] pfTab){
    int[] resultat = new int[5] ;
    for (int indice = 0; indice < pfTab.length; indice = indice + 1){
        resultat[0] = resultat[0] + pfTab[indice].quantite ;
        resultat[pfTab[indice].categorie] = resultat[pfTab[indice].categorie] + pfTab[indice].quantite ;
    }
    return(resultat);
  }
} // fin class
