
public class Pile {
	private String[] values;
	
	public Pile() {
		 this.values = new String[0];
	}
	public boolean estVide () {
		return this.values.length == 0 ;
	}
	public String sommet () throws PileException {
		if (this.estVide()) {
			throw new PileException();
		}
		return this.values[this.values.length-1];
	}

	public void empiler (String elt) {
		String[] nouvTab;
		int i;
		nouvTab = new String[this.values.length + 1];
		for (i=0; i<this.values.length; i++) {
			nouvTab[i] = this.values[i];
		}
		nouvTab[nouvTab.length-1] = elt;
		this.values = nouvTab;
	}

	public void depiler () throws PileException {
		if (this.estVide()) {
			throw new PileException();
		}
		String[] nouvTab;
		int i;
		nouvTab = new String[this.values.length - 1];
		for (i=0; i<this.values.length-1; i++) {
			nouvTab[i] = this.values[i];
		}
		this.values = nouvTab;
	}

}

class PileException extends Exception {}