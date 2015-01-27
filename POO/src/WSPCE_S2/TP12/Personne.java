

public class Personne {
		// Attributs 
		private  String nom;
		private  int age;

	// Constructeurs
	public  Personne () {
		this ("", 0);
	}
	
	public  Personne (String pNom) {
		this (pNom, 0);
	}
	
	public  Personne (String pNom, int pAge) {
		this.nom = pNom;
		this.age = pAge;
	}
   
		// Méthodes
		public  String getNom () { return this.nom; }
		public  int getAge ()   { return this.age; }
		public  void setNom (String nouvNom) { this.nom = nouvNom; }
		public  void setAge (int nouvAge)  { this.age = nouvAge; }
			
} // Fin Classe Personne
