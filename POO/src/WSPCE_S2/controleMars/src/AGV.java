import java.util.ArrayList;


class Billet 
{
	private  String nomVoyageur, villeDepart, villeArrivee ;
	private  int distanceParcourue;

	public Billet (String pNom, String  pDepart, String pArrivee, int pDist)
	{
		this.nomVoyageur = pNom;
		this.villeDepart = pDepart;
		this.villeArrivee = pArrivee;
		this.distanceParcourue = pDist;
	}
	public String  getDepart () { return  this.villeDepart; }
	public String  getArrivee () { return  this.villeArrivee; }
	public String  getNom () { return  this.nomVoyageur; }
	public int getDistance () { return  this.distanceParcourue ; }
}



public class AGV  
{
	private ArrayList<Billet>  alBillets ;  
	private String  nomAgv ; // Nom de l’agence
	
	public AGV (String pNom )
	{
		this.nomAgv = pNom;
		this.alBillets = new ArrayList<Billet> ();
	}
	public void ajouterBillet (Billet pB) throws Exception
	{
		if (pB == null)
			throw new Exception();
		alBillets.add (pB);
	}
	public Billet rechercherBillet (String pNom)
	{
		int s = this.alBillets.size();
		for (int i=0; i<s; i++)
			if (this.alBillets.get(i).getNom().equals(pNom))
				return this.alBillets.get(i);
		return null;
	}
	public int retirerBillet (String pNom) 
	{
		int nb;
		Billet trouve;
		nb=0;
		trouve = this.rechercherBillet(pNom); 
		while (trouve != null) {
			this.alBillets.remove(trouve);
			nb++;
			trouve = this.rechercherBillet(pNom); 
		}
		return nb;
	}
	public int retirerBillet2 (String pNom) 
	{
		int i, nb;
		i=0;
		nb=0;
		while (i<this.alBillets.size()) {
			if (this.alBillets.get(i).getNom().equals(pNom)) {
				this.alBillets.remove(i);
				nb++;
			} else {
				i++;
			}
		}
		return nb;
	}

	public static void main (String argv[])
	{
		Billet b;
		AGV a;
		a = new AGV("Test");
		try {
			a.ajouterBillet(new Billet("c", "c", "c", 300));
			a.ajouterBillet(new Billet("a", "a", "a", 100));
			a.ajouterBillet(new Billet("a", "a", "a", 200));
		} catch (Exception e) {
			System.out.println("Pb ....");
		}
		System.out.println (a.rechercherBillet("a").getDistance());
		System.out.println (a.rechercherBillet("a").getNom());
		System.out.println (a.rechercherBillet("b"));
		System.out.println(a.retirerBillet("a"));
		System.out.println (a.rechercherBillet("a"));
		System.out.println (a.rechercherBillet("c").getNom());
	}
}
