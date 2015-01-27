
/*
class Temps 
{
	private int min, sec ;

	public Temps (int pM, int pS)  { this.min = pM ; this.sec = pS ; }
	public Temps (double pM) { this.min = (int) pM ;
		this.sec = (int) ((pM- this.min)*60) ; }
	public int getMin () {return this.min ;}
	public int getSec () {return this.sec ;}
	public void affiche () {System.out.println (this.min + " " + this.sec + " " + (this.min+ this.sec/60.0));}
	public void ajoute (Temps pT)
	{ 	this.sec += pT.getSec() ;
		if (this.sec >= 60)
		{
			this.min += 1 ;
			this.sec -= 60 ;
		}
		this.min += pT.getMin () ;
	}
}
*/


// /*
class Temps
{
	private double d ;

	public Temps (int pM, int pS)  { this.d = pM + pS/60.0; }
	public Temps (double pM) { this.d= pM ; }
	int getMin () {return (int) (this.d) ;}
	int getSec () {return (int) ((this.d- this.getMin())*60) ;}
	void affiche () {System.out.println (this.getMin() + " " +  this.getSec() + " " + (this.d));}
	void ajoute (Temps pT)
	{ 	d = this.d + pT.getMin() + pT.getSec()/60.0;  }
}

// */

public class TestTemps {
	
   public static void main(String argv[])
   {
	   Temps t1 = new Temps ( 2.5 ) ;
	   Temps t2 = new Temps ( 3,   45 ) ;

       t1.affiche () ;// Affiche : temps 2 min 30 secondes soit 2.5 minutes
       t2.affiche () ; // Affiche : temps 3 min 45 secondes soit 3.75 minutes
       System.out.println ("Min : " + t1.getMin() + " Sec : " + t1.getSec() ) ;
       t1.ajoute (t2) ;
       t1.affiche () ; // Affiche : temps 6 min 15 secondes soit 6.25 minutes
       t2.affiche () ; // Affiche : temps 3 min 45 secondes soit 3.75 minutes
   }

}
