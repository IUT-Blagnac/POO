public class Artisans {
	// Attributes-------------------------------------------
	private Realiser[] mesReal;
	// le tableau ci-dessus contient l'ensemble des références d'objet Realiser lié à l'artisan
	private Qualifications maQualif ;
	// l'attribut ci-dessus contient la référence de l'objet Qualifications lié à l'artisan
	private String idSIRET ;
	private String nomArt;
	private String adresseArt;
	private String tphArt;

	// Methods-------------------------------------------
	public Artisans () {
	// constructor	
	}

	public String getNomArt () { 
		return nomArt; 
	}

	public Integer getPayeArtisan (Chantier c) {
		int total = 0;
		for ( int i = 0; i < mesReal.length ; i++ ) {
			if (mesReal[i].getChantier() == c) 
				total += mesReal[i].getDuree();
			// si le chantier de l'objet Realiser est le même que le chantier passé
			// en paramètre alors je cumule la durée de la Réalisation dans la variable total
			}
		return (total * maQualif.getTauxHoraire());
		// on retourne la paye de l'artisan pour ce chantier (soit le nb d'heures
		// travaillés sur ce chantier multipliés par le taux horaire liée à la qualification de l'artisan
	}

}