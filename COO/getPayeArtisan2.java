public class Artisans {
	private Realiser[] mesReal;
	private Qualifications maQualif ;
	private String idSIRET ;
	private String nomArt;
	private String adresseArt;
	private String tphArt;

	public Integer getPayeArtisan (Chantier c) {
		int total = 0;
		for ( int i = 0; i < mesReal.length ; i++ ) {
			if (mesReal[i].getChantier() == c) 
				total += mesReal[i].getDuree();
			}
		return (total * maQualif.getTauxHoraire());
	}
}