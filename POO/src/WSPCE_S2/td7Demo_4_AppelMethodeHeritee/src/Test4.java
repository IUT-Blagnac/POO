
 
public class Test4
{
	public static void main(String[] args)
	{  
		MonoSpace ms = new MonoSpace();
		
		ms.setNoSerie(100);
		ms.setNumeroImmat("XP 789 YT");
		ms.rouler(250);
		ms.afficher();
		ms.afficher(10);
	}
}


class  Vehicule extends  Object   // Héritage implicite
{
	
   public  void  afficher  ()  {
       System.out.println ("Vehicule " + this.marque + " " + this.noSerie);
   }
	   
   // Attributs 
   private  String  marque;
   private  int  noSerie;
   private  int  km;

   // Constructeur
   public  Vehicule  ()  {
       this ("", 0);   // Appel  de Vehicule (String, int)
   }
   public  Vehicule  (String  pMarque,  int  pSerie)  {
       super () ;  // Implicite
       this.marque  =  pMarque; 
       this.noSerie  =  pSerie;
       this.km  =  0; // Implicite
   }

   // Méthodes
   public  String  getMarque()  {  return  this.marque;  }
   public  int  getNoSerie()  {  return  this.noSerie;  }
   public  int  getKm()  {  return  this.km;  }
   
   public  void  setNoSerie(int  pSerie)  {  this.noSerie  =  pSerie;  }
   public  void  rouler  (int  nbKm)  {  this.km  =  this.km  +  nbKm; }
} // Fin Classe Vehicule

class  Voiture  extends  Vehicule {

   public  void  afficher  () {
       System.out.println  ("Immatriculation "  +  this.noImmat);
       super.afficher();
   }
	   
   // Attributs 
   private  String  noImmat;
   
   // Constructeurs
   public  Voiture() {
       this  ("",  0,  "");
   }
   
   public  Voiture(String  pMarque,  int  pSerie,  String  pImmat) {
       super  (pMarque,  pSerie);
       this.noImmat  =  pImmat;
   }
   
   // Méthodes
   public  String  getNumeroImmat  ()  {  return  this.noImmat; }
   public  void  setNumeroImmat  (String pImmat)  { this.noImmat = pImmat; }
} // Fin Classe Voiture

class  MonoSpace  extends  Voiture {
   public  void  afficher  () {
       super.afficher();
       System.out.println  ("MonoSpace ");
   }
   public  void  afficher  (int decalage) {
	   int  i;
	   for  (i=0;  i<decalage;  i++)  System.out.print(" ");
	   System.out.print("->");
	   this.afficher();
   }
   public MonoSpace () {
	   super();
   }
} // Fin Classe MonoSpace