import java.util.ArrayList;


public class Client {
	private String idClient, nomClient, adrClient, telClient;
	
	private ArrayList<Commande> lesCommandes ;
	
	public Client (String id, String nom, String adr, String tel) {
		this.idClient= id;
		this.nomClient = nom;
		this.adrClient = adr;
		this.telClient = tel;
		this.lesCommandes = new ArrayList<Commande>();
	}
	
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
	public void addCommande(Commande comm) { this.lesCommandes.add(comm); }
	public void removeCommande (Commande comm) { this.lesCommandes.remove(comm); }

	public void associerCommande (Commande comm) {
	    if (comm != null) {
	    	if(!this.lesCommandes.contains(comm)) {
		        if (comm.getClient() != null ) {
		        	comm.getClient().removeCommande(comm);
		        }
		        this.lesCommandes.add ( comm ); // Ou this.addCommande(comm);
		        comm.setClient ( this );
	    	}
	    }
	}
	public void defaireAssoCommande (Commande comm) {
	    if (comm != null) {
	    	if(this.lesCommandes.contains(comm)) {
		        this.lesCommandes.remove ( comm ); // Ou this.removeCommande(comm);
		        comm.setClient ( null );
	    	}
	    }
	}
	public void afficherCommandes() {}
}
