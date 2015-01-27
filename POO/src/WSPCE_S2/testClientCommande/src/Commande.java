/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3767 modeling language!*/



// line 12 "model.ump"
public class Commande
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Commande Attributes
  private String idCde;

  //Commande Associations
  private Client client;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Commande(String aIdCde)
  {
    idCde = aIdCde;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdCde(String aIdCde)
  {
    boolean wasSet = false;
    idCde = aIdCde;
    wasSet = true;
    return wasSet;
  }

  public String getIdCde()
  {
    return idCde;
  }

  public Client getClient()
  {
    return client;
  }

  public boolean hasClient()
  {
    boolean has = client != null;
    return has;
  }

  public boolean setClient(Client aClient)
  {
    boolean wasSet = false;
    Client existingClient = client;
    client = aClient;
    if (existingClient != null && !existingClient.equals(aClient))
    {
      existingClient.removeCommande(this);
    }
    if (aClient != null)
    {
      aClient.addCommande(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (client != null)
    {
      Client placeholderClient = client;
      this.client = null;
      placeholderClient.removeCommande(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "idCde" + ":" + getIdCde()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "client = "+(getClient()!=null?Integer.toHexString(System.identityHashCode(getClient())):"null")
     + outputString;
  }
}