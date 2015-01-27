
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client cl1 = new Client("1 Client");
		Client cl2 = new Client("2 Client");
		Commande co1 = new Commande("1 commande");
		Commande co2 = new Commande("2 commande");
		
		cl2.addCommande(co2);
		cl1.addCommande(co1);
		cl1.addCommande(co2);
		co1.setClient(cl1);
		co2.setClient(cl1);
	}

}
