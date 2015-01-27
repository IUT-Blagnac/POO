
public class Test {
	public static void main (String argv[]) {
		Commande co1 = new Commande("co1", "date1");
		Commande co2 = new Commande("co2", "date2");
		Client cl1 = new Client("cl1", "cl1", "cl1", "cl1");
		Client cl2 = new Client("cl2", "cl2", "cl2", "cl2");
		
		cl1.associerCommande(co1);
		cl1.associerCommande(co2);
		co2.associerClient(cl2);
		cl2.associerCommande(null);
		co1.associerClient(cl1);
		co1.associerClient(null);
	}
}
