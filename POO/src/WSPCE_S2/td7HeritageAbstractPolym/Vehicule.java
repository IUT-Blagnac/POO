

public abstract class  Vehicule extends  Object   // Héritage implicite
{
   // Attributs 
   private  String  marque;
   private  int  noSerie;
   private  int  km;

   // Constructeur
   public  Vehicule  ()
   {
       this ("", 0);   // Appel  de Vehicule (String, int)
   }
   public  Vehicule  (String  pMarque,  int  pSerie)
   {
       super () ;  // Implicite
       this.marque  =  pMarque; 
       this.noSerie  =  pSerie;
       this.km  =  0; // Implicite
   }

   // Méthodes

   public abstract double  coutReel  () ;  // METHODE ABSTRAITE

   public  String  getMarque()  {  return  this.marque;  }
   public  int  getNoSerie()  {  return  this.noSerie;  }
   public  int  getKm()  {  return  this.km;  }

   public  void  afficher  ()
   {
       System.out.println ("Vehicule " + this.marque + " " + this.noSerie);
       System.out.println ("    km : " + this.km);
   }

   public  void  setNoSerie(int  pSerie)  {  this.noSerie  =  pSerie;  }
   public  void  rouler  (int  nbKm)  {  this.km  =  this.km  +  nbKm; }
} // Fin Classe Vehicule


