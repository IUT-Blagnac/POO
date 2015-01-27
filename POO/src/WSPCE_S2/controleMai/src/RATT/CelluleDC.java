package RATT;


public class CelluleDC {
	
    private double contenu;
    private CelluleDC suivant, precedent;

    public CelluleDC (double pVal, CelluleDC pSuiv, CelluleDC pPrec) {
            this.contenu = pVal;
            this.suivant = pSuiv;
            this.precedent = pPrec;
    }

	public double getContenu() {
		return contenu;
	}

	public void setContenu(double pContenu) {
		this.contenu = pContenu;
	}

	public CelluleDC getSuivant() {
		return suivant;
	}

	public void setSuivant(CelluleDC pSuivant) {
		this.suivant = pSuivant;
	}

	public CelluleDC getPrecedent() {
		return precedent;
	}

	public void setPrecedent(CelluleDC pPrecedent) {
		this.precedent = pPrecedent;
	}
}