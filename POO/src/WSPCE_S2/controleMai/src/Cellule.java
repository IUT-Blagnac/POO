public class Cellule {
	
    private double cont;
    private Cellule suiv;

    public Cellule (double pVal, Cellule pSuiv) {
            this.cont = pVal;
            this.suiv = pSuiv;
    }
    
    public double getContenu () {
            return this.cont;
    }
    
    public Cellule getSuivant () {
            return this.suiv;
    }
    
    public void setContenu (double pVal) {
            this.cont = pVal;
    }
    
    public void setSuivant (Cellule pSuiv) {
            this.suiv = pSuiv;
    }
}

