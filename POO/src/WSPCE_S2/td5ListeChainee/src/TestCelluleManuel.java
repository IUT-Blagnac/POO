
public class TestCelluleManuel {
		public static void main (String argv[]) {
			
			// PARTIE 1 - PARTIE 1 - PARTIE 1 - PARTIE 1
			
			// déclarer la variable debutChaine et des variables Cellule : pCel1, pCel2, temp, nouvCel
			
			Cellule debutChaine;
			Cellule pCel1, pCel2, temp, nouvCel, temp2;

			// créer la cellule contenant 45.5 en utilisant la variable debutChaine
			
			debutChaine = new Cellule(45.5, null);
			
			// créer la cellule contenant 55.5 en utilisant la variable pCel1
			
			pCel1 = new Cellule (55.5, null);
			
			// relier les cellules contenant 45.5 et 55.5
			
			debutChaine.setSuivant(pCel1);
			
			// créer la cellule contenant 65.5 en utilisant la variable pCel2
			
			pCel2 = new Cellule (65.5, null);
			
			// relier les cellules contenant 55.5 et 65.5
			
			pCel1.setSuivant(pCel2);
			
			// initialiser correctement le champ suiv de la Cellule contenant 65.5 pour que la structure  chaînée soit correcte (c'est la dernière cellule de la structure )
			
			pCel2.setSuivant(null);
			
			// afficher les différentes valeurs contenues dans la structure  chaînée dans l'ordre des Cellules 
			// en utilisant debutChaine et les valeurs de pCel1 et pCel2,
			
			System.out.println();
			System.out.println(debutChaine.getContenu());
			System.out.println(pCel1.getContenu());
			System.out.println(pCel2.getContenu());

			// afficher les différentes valeurs contenues dans la structure  chaînée dans l'ordre des Cellules 
			// en utilisant debutChaine et éventuellement un autre pointeur de Cellule et en utilisant une boucle
			// NE PAS se servir des valeurs de pCel1 et pCel2
			
			System.out.println();
			temp = debutChaine ;
			while (temp != null) {
				System.out.println(temp.getContenu());
				temp = temp.getSuivant();
			}
			
			// PARTIE 2 - PARTIE 2 - PARTIE 2 - PARTIE 2

			// en utilisant les variables nécessaires : ajouter l'élément 35.5 avant la cellule contenant 45.5
			
			temp = new Cellule (35.5, null);
			temp.setSuivant(debutChaine);
			debutChaine = temp;
			
			// en utilisant les variables nécessaires : ajouter l'élément 75.5 à la fin de la structure 
			// SANS utiliser la valeur de pCel2
			
			nouvCel = new Cellule (75.5, null);
			temp = debutChaine ;
			while (temp.getSuivant() != null) {
				temp = temp.getSuivant();
			}
			temp.setSuivant(nouvCel);

			// afficher les différentes valeurs contenues dans la structure chaînée 
			
			System.out.println();
			temp = debutChaine ;
			while (temp != null) {
				System.out.println(temp.getContenu());
				temp = temp.getSuivant();
			}
			
			// PARTIE 3 - PARTIE 3 - PARTIE 3 - PARTIE 3

			// supprimer la cellule contenant 55.5.
			// on supposera ne pas "connaîtree" sa position. Il faut donc chercher la cellule.
			// on sait que ce n'est pas la première.
			
			temp = debutChaine ;
			while (temp.getSuivant().getContenu() != 55.5) {
				temp = temp.getSuivant();
			}
			temp2 = temp.getSuivant(); // Cellule contenant 55.5 
			temp2 = temp2.getSuivant(); // Cellule suivante de la cellule contenant 55.5
			temp.setSuivant(temp2);

			// supprimer la cellule contenant 75.5.
			// on supposera ne pas "connaîtree" sa position. Il faut donc chercher la cellule.
			// est ce si différent que ci-dessus ?
			
			temp = debutChaine ;
			while (temp.getSuivant().getContenu() != 75.5) {
				temp = temp.getSuivant();
			}
			temp2 = temp.getSuivant(); // Cellule contenant 75.5 
			temp2 = temp2.getSuivant(); // Cellule suivante de la cellule contenant 75.5 (null)
			temp.setSuivant(temp2);

			// supprimer la cellule contenant 35.5 (une ligne)
			
			debutChaine = debutChaine.getSuivant();
			
			// afficher les différentes valeurs contenues dans la structure chaînée 
			
			System.out.println();
			temp = debutChaine ;
			while (temp != null) {
				System.out.println(temp.getContenu());
				temp = temp.getSuivant();
			}
			
		}
}

