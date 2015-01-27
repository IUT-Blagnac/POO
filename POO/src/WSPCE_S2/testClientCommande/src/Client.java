/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3767 modeling language!*/


import java.util.*;

// line 5 "model.ump"
public class Client
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  private String idCli;

  //Client Associations
  private List<Commande> commandes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Client(String aIdCli)
  {
    idCli = aIdCli;
    commandes = new ArrayList<Commande>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdCli(String aIdCli)
  {
    boolean wasSet = false;
    idCli = aIdCli;
    wasSet = true;
    return wasSet;
  }

  /**
   * Attribute, string by default
   */
  public String getIdCli()
  {
    return idCli;
  }

  public Commande getCommande(int index)
  {
    Commande aCommande = commandes.get(index);
    return aCommande;
  }

  public List<Commande> getCommandes()
  {
    List<Commande> newCommandes = Collections.unmodifiableList(commandes);
    return newCommandes;
  }

  public int numberOfCommandes()
  {
    int number = commandes.size();
    return number;
  }

  public boolean hasCommandes()
  {
    boolean has = commandes.size() > 0;
    return has;
  }

  public int indexOfCommande(Commande aCommande)
  {
    int index = commandes.indexOf(aCommande);
    return index;
  }

  public static int minimumNumberOfCommandes()
  {
    return 0;
  }

  public boolean addCommande(Commande aCommande)
  {
    boolean wasAdded = false;
    if (commandes.contains(aCommande)) { return false; }
    Client existingClient = aCommande.getClient();
    if (existingClient == null)
    {
      aCommande.setClient(this);
    }
    else if (!this.equals(existingClient))
    {
      existingClient.removeCommande(aCommande);
      addCommande(aCommande);
    }
    else
    {
      commandes.add(aCommande);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCommande(Commande aCommande)
  {
    boolean wasRemoved = false;
    if (commandes.contains(aCommande))
    {
      commandes.remove(aCommande);
      aCommande.setClient(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCommandeAt(Commande aCommande, int index)
  {  
    boolean wasAdded = false;
    if(addCommande(aCommande))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCommandes()) { index = numberOfCommandes() - 1; }
      commandes.remove(aCommande);
      commandes.add(index, aCommande);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCommandeAt(Commande aCommande, int index)
  {
    boolean wasAdded = false;
    if(commandes.contains(aCommande))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCommandes()) { index = numberOfCommandes() - 1; }
      commandes.remove(aCommande);
      commandes.add(index, aCommande);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCommandeAt(aCommande, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !commandes.isEmpty() )
    {
      commandes.get(0).setClient(null);
    }
  }

  @umplesourcefile(line={8},file={"model.ump"},javaline={164},length={3})
  public String toString(){
    return(this.idCli);
  }

}