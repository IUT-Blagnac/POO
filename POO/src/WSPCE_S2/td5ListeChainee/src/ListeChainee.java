import java.util.List;


public class ListeChainee {
	
	private Cellule premiere, derniere;
	int nbValeurs;
	
	public ListeChainee () {
		this.premiere = null;
		this.derniere = null;
		this.nbValeurs = 0;
	}
	
	public int size () {
		return this.nbValeurs;
	}
	
	public void addFirst (double pVal) {
		Cellule temp = new Cellule(pVal, null);
		if (premiere == null) {
			this.premiere = temp;
			this.derniere = temp;
			this.nbValeurs++;
		} else {
			temp.setSuivant(this.premiere);
			this.premiere = temp;
			this.nbValeurs++;
		}
	}
	
	public void addLast (double pVal) {
		Cellule temp = new Cellule(pVal, null);
		if (premiere == null) {
			this.premiere = temp;
			this.derniere = temp;
			this.nbValeurs++;
		} else {
			temp.setSuivant(this.premiere);
			this.premiere = temp;
			this.nbValeurs++;
		}
	}

}
