
public class Commande {
	private String idCde, dateCde;
	private boolean etatCde;

	private Client leClient;
	
	public Commande (String id, String d) {
		this.idCde = id;
		this.dateCde = d;
		this.etatCde = false;
		this.leClient = null;
	}
		
	public Client getClient () { return this.leClient; }
	public void setClient (Client cli) { this.leClient = cli; }
	
	public void associerClient (Client cli) {
	    if (cli == null ){ // Défaire l'association
	        if (this.leClient != null) {
	        	this.leClient.removeCommande(this);
	        }
	        this.setClient(null); // Ou this.leClient = null ;	    	
	    } else { // Créer l'association
	    	if (this.leClient != null) {
	    		this.leClient.removeCommande(this);
	    	}
	    	this.setClient(cli); // Ou this.leClient = cli;
	    	cli.addCommande(this);
	    }
	}
	void afficherInfos() {}
	boolean getEtat() { return this.etatCde; }
}
