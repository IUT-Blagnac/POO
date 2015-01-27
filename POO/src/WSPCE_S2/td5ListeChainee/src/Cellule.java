
public class Cellule {
	private double contenu; 
	private Cellule suivant;
	
	public Cellule (double pVal, Cellule pSuiv) {
		this.contenu = pVal;
		this.suivant = pSuiv;
	}
	public double getContenu () {
		return this.contenu;
	}
	public Cellule getSuivant () {
		return this.suivant;
	}
	public void setContenu (double pVal) {
		this.contenu = pVal;
	}
	public void setSuivant (Cellule pSuiv) {
		this.suivant = pSuiv;
	}
}
