
public class Client {
	
	private String idClient, nomClient, adrClient, telClient;
	
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
	
	public void associerCommande (Commande comm) {
		if (comm == null) { // Défaire l'association
			if ( this.laCommande != null) {
				this.laCommande.setClient(null);
			}
			this.setCommande(null); // Ou this.laCommande = null; 
		} else { // Créer l'association
			if (comm.getClient() != null ) {
				comm.getClient().setCommande(null);
			}
			if ( this.laCommande != null) {
				this.laCommande.setClient(null);
			}
			this.setCommande(comm); // Ou this.laCommande = comm;
			comm.setClient ( this );
		}
	}
	public void afficherCommandes() {}
}