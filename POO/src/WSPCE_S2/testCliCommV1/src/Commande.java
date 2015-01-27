
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
	
	public void setClient (Client cli) { this.leClient = cli; }
	public Client getClient () { return this.leClient; }
	
	public void associerClient (Client cli) {
	    if (cli == null ){ // Défaire l'association
	        if (this.leClient != null) {
	        	this.leClient.setCommande(null);
	        }
	        this.setClient(null); // Ou  this.leClient = null ;	    	
	    } else { // Créer l'association
	        if (cli.getCommande() != null ) {
	        	cli.getCommande().setClient(null);
	        }
	        if (this.leClient != null) {
	        	this.leClient.setCommande(null);
	        }
	        this.setClient(cli); // Ou this.leClient = cli ;
	        cli.setCommande ( this );
	    }
	}
	void afficherInfos() {}
	boolean getEtat() { return this.etatCde; }
}