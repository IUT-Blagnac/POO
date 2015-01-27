
import java.lang.*;


//    Classe des comptes standards

public 
class Compte 
{
    /*********************************
        Partie privée d'implémentation
    **********************************/

    // Attributs

    // Nom du propriétaire
	private String proprietaire;

    // Numero de Compte
	private String numCompte;

    // Attributs debit et credit
    // Permettent de comptabiliser depots et retraits
    private double debit, credit;


    // Constructeurs


    public Compte()
    {
        this("Pas de numéro", "Pas de propriétaire", 0, 0);
    }


    public Compte(String pNumCompte, String pNomProp)
    {
        this(pNumCompte, pNomProp, 0, 0);
    }


    public Compte(String pNumCompte, String pNomProp, double pDebit, double pCredit)
    {
		this.numCompte = pNumCompte;
		this.proprietaire = pNomProp;
        this.debit = pDebit;
        this.credit = pCredit;
    }

    // Methodes de consultation


    public double soldeCompte ()
    {
        return this.credit - this.debit;
    }

    public String getProprietaire ()
    {
        return this.proprietaire;
    }

    public String getNumCompte ()
    {
        return this.numCompte;
    }


    public void afficher ()
    {
		System.out.print ("  Num. : " + this.numCompte+" - Prop. : " + this.proprietaire);
        System.out.println(" - Debit " + this.debit + " E / Credit " + this.credit + " E");
    }


    // Methodes de mise a jour


    public void retirer (double pSomme)
    {
        this.debit = this.debit + pSomme;
    }


    public void deposer (double pSomme)
    {
         this.credit = this.credit + pSomme;
    }


    public void setProprietaire (String pNomProp)
    {
		this.proprietaire = pNomProp;
    }




    public void afficherAvecSolde ()
    {
        this.afficher () ;
        System.out.println ( "   Solde : " + this.soldeCompte() );
    }

}


