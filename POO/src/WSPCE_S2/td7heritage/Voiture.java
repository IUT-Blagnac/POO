
public 
class  Voiture  extends  Vehicule 
{
   // Attributs 
   private  String  noImmat;
   
   // Constructeurs
   public  Voiture()
   {
       this  ("",  0,  "");
   }
   
   public  Voiture(String  pMarque,  int  pSerie,  String  pImmat)
   {
       super  (pMarque,  pSerie);
       this.noImmat  =  pImmat;
   }
   
   // Méthodes
   public  String  getNumeroImmat  ()  {  return  this.noImmat; }
   public  void  setNumeroImmat  (String pImmat)  { this.noImmat = pImmat; }

   public  void  afficher  ()
   {
       System.out.println  ("Immatriculation "  +  this.noImmat);
       super.afficher();
   }
} // Fin Classe Voiture

