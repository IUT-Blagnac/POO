package m;

import ...;

public class Facture implements Serializable {
	private static final long serialVersionUID...;
	private String lieu;
	private Date date;
	private int numJournee;
	private Client client;
	private ArrayList<BonCommande> bc;

...
}
