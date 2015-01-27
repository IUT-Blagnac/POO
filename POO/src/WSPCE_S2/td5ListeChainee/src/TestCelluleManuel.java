
public class TestCelluleManuel {
		public static void main (String argv[]) {
			
			// PARTIE 1 - PARTIE 1 - PARTIE 1 - PARTIE 1
			
			// d�clarer la variable debutChaine et des variables Cellule : pCel1, pCel2, temp, nouvCel
			
			Cellule debutChaine;
			Cellule pCel1, pCel2, temp, nouvCel, temp2;

			// cr�er la cellule contenant 45.5 en utilisant la variable debutChaine
			
			debutChaine = new Cellule(45.5, null);
			
			// cr�er la cellule contenant 55.5 en utilisant la variable pCel1
			
			pCel1 = new Cellule (55.5, null);
			
			// relier les cellules contenant 45.5 et 55.5
			
			debutChaine.setSuivant(pCel1);
			
			// cr�er la cellule contenant 65.5 en utilisant la variable pCel2
			
			pCel2 = new Cellule (65.5, null);
			
			// relier les cellules contenant 55.5 et 65.5
			
			pCel1.setSuivant(pCel2);
			
			// initialiser correctement le champ suiv de la Cellule contenant 65.5 pour que la structure  cha�n�e soit correcte (c'est la derni�re cellule de la structure )
			
			pCel2.setSuivant(null);
			
			// afficher les diff�rentes valeurs contenues dans la structure  cha�n�e dans l'ordre des Cellules 
			// en utilisant debutChaine et les valeurs de pCel1 et pCel2,
			
			System.out.println();
			System.out.println(debutChaine.getContenu());
			System.out.println(pCel1.getContenu());
			System.out.println(pCel2.getContenu());

			// afficher les diff�rentes valeurs contenues dans la structure  cha�n�e dans l'ordre des Cellules 
			// en utilisant debutChaine et �ventuellement un autre pointeur de Cellule et en utilisant une boucle
			// NE PAS se servir des valeurs de pCel1 et pCel2
			
			System.out.println();
			temp = debutChaine ;
			while (temp != null) {
				System.out.println(temp.getContenu());
				temp = temp.getSuivant();
			}
			
			// PARTIE 2 - PARTIE 2 - PARTIE 2 - PARTIE 2

			// en utilisant les variables n�cessaires : ajouter l'�l�ment 35.5 avant la cellule contenant 45.5
			
			temp = new Cellule (35.5, null);
			temp.setSuivant(debutChaine);
			debutChaine = temp;
			
			// en utilisant les variables n�cessaires : ajouter l'�l�ment 75.5 � la fin de la structure 
			// SANS utiliser la valeur de pCel2
			
			nouvCel = new Cellule (75.5, null);
			temp = debutChaine ;
			while (temp.getSuivant() != null) {
				temp = temp.getSuivant();
			}
			temp.setSuivant(nouvCel);

			// afficher les diff�rentes valeurs contenues dans la structure cha�n�e 
			
			System.out.println();
			temp = debutChaine ;
			while (temp != null) {
				System.out.println(temp.getContenu());
				temp = temp.getSuivant();
			}
			
			// PARTIE 3 - PARTIE 3 - PARTIE 3 - PARTIE 3

			// supprimer la cellule contenant 55.5.
			// on supposera ne pas "conna�tree" sa position. Il faut donc chercher la cellule.
			// on sait que ce n'est pas la premi�re.
			
			temp = debutChaine ;
			while (temp.getSuivant().getContenu() != 55.5) {
				temp = temp.getSuivant();
			}
			temp2 = temp.getSuivant(); // Cellule contenant 55.5 
			temp2 = temp2.getSuivant(); // Cellule suivante de la cellule contenant 55.5
			temp.setSuivant(temp2);

			// supprimer la cellule contenant 75.5.
			// on supposera ne pas "conna�tree" sa position. Il faut donc chercher la cellule.
			// est ce si diff�rent que ci-dessus ?
			
			temp = debutChaine ;
			while (temp.getSuivant().getContenu() != 75.5) {
				temp = temp.getSuivant();
			}
			temp2 = temp.getSuivant(); // Cellule contenant 75.5 
			temp2 = temp2.getSuivant(); // Cellule suivante de la cellule contenant 75.5 (null)
			temp.setSuivant(temp2);

			// supprimer la cellule contenant 35.5 (une ligne)
			
			debutChaine = debutChaine.getSuivant();
			
			// afficher les diff�rentes valeurs contenues dans la structure cha�n�e 
			
			System.out.println();
			temp = debutChaine ;
			while (temp != null) {
				System.out.println(temp.getContenu());
				temp = temp.getSuivant();
			}
			
		}
}

