import java.util.ArrayList;

public class Facture {
	private ArrayList<String> alcom;
	private double totalTtc;
		
	public Facture () {
		this.alcom = new ArrayList<String>() ;
		this.calculPrixTtc();
	}
	
	public double prixTtc () {
		return this.totalTtc;
	}
	
	public void addProduit (String lc) {
		this.alcom.add (lc);
		this.calculPrixTtc();
	}
	
	private void calculPrixTtc() {
		double total=0;;
		// calcul total ttc depuis alCom dans total
		this.totalTtc = total;
	}
}

/*
import java.util.ArrayList;

public class Facture {
	private ArrayList<String> alcom;
	private double totalTtc;
	private boolean isTtcAJour;
	
	public Facture () {
		this.alcom = new ArrayList<String>() ;
		this.isTtcAJour= false;
	}
	
	public double prixTtc () {
		if (! this.isTtcAJour) {
			this.calculPrixTtc();
		}
		return this.totalTtc;
	}
	
	public void addProduit (String lc) {
		this.alcom.add (lc);
		this.isTtcAJour = false;
	}
	
	private void calculPrixTtc() {
		double total=0;;
		// calcul total ttc depuis alCom dans total
		this.totalTtc = total;
		this.isTtcAJour = true;
	}
}

*/