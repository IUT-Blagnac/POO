// Asso 0..1 - 0..1





class Commande {
	
	private String idCde;
	private String dateCde;
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
	
	public void definirClient (Client cli) {
	    if( cli != null ){
	        if (cli.getCommande() != null ) {
	        	cli.getCommande().setClient(null);
	        }
	        if (this.leClient != null) {
	        	this.leClient.setCommande(null);
	        }
	        this.leClient = cli ;
	        cli.setCommande ( this );
	    }
	}
	void afficherInfos() {}
	boolean getEtat() { return this.etatCde; }
}

class Client {
	
	private String idClient;
	private String nomClient;
	private String adrClient;
	private String telClient;
	
	private Commande laCommande ;
	
	public Client (String id, String nom, String adr, String tel) {
		this.idClient= id;
		this.nomClient = nom;
		this.adrClient = adr;
		this.telClient = tel;
		this.laCommande = null;
	}
	
	public void setCommande (Commande comm) { this.laCommande = comm; }
	public Commande getCommande () {return this.laCommande ;	}
	
	public void definirCommande (Commande comm) {
	    if( comm != null ) {
	        if (comm.getClient() != null ) {
	        	comm.getClient().setCommande(null);
	        }
	        if ( this.laCommande != null) {
	        	this.laCommande.setClient(null);
	        }
	        this.laCommande = comm;
	        comm.setClient ( this );
	      }
	}
	public void afficherCommandes() {}
}




// Solution 0..1 - 0..*


import java.util.ArrayList;

class Commande {
	
	private String idCde;
	private String dateCde;
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
	
	public void definirClient (Client cli) {
	    if( cli != null ){
	        if (! cli.existeCommande(this)) {
	        	if (this.leClient != null) {
	        		this.leClient.removeCommande(this);
	        	}
	        	this.leClient = cli;
	        	cli.addCommande(this);
	        }
	    }
	}
	void afficherInfos() {}
	boolean getEtat() { return this.etatCde; }
}

class Client {
	
	private String idClient;
	private String nomClient;
	private String adrClient;
	private String telClient;
	
	private ArrayList<Commande> lesCommandes ;
	
	public Client (String id, String nom, String adr, String tel) {
		this.idClient= id;
		this.nomClient = nom;
		this.adrClient = adr;
		this.telClient = tel;
		this.lesCommandes = new ArrayList<Commande>();
	}
	
	public void addCommande(Commande comm) { this.lesCommandes.add(comm); }
	public void removeCommande (Commande comm) { this.lesCommandes.add(comm); }
	public boolean existeCommande(Commande comm) {
		boolean trouve;
		trouve = false;
		for (int i = 0; i<this.lesCommandes.size() && !trouve ; i++) {
			if (comm == this.lesCommandes.get(i))
				trouve = true;
		}
		//return  this.lesCommandes.contains(comm);
		return trouve; 
	}
	
	public void ajouterUneCommande (Commande comm) {
	    if (comm != null) {
	    	if( ! this.lesCommandes.contains(comm)) {
		        if (comm.getClient() != null ) {
		        	comm.getClient().removeCommande(comm);
		        }
		        this.lesCommandes.add ( comm );
		        comm.setClient ( this );
	    	}
	    }
	}
	public void afficherCommandes() {}
}
