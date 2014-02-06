/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3397 modeling language!*/

package accidents;

// line 6 "../../../../ump/tmp460864/model.ump"
// line 63 "../../../../ump/tmp460864/model.ump"
public class AccidentType
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AccidentType Attributes
  private String code;
  private String description;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AccidentType(String aCode, String aDescription)
  {
    cachedHashCode = -1;
    canSetCode = true;
    code = aCode;
    description = aDescription;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    if (!canSetCode) { return false; }
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getCode()
  {
    return code;
  }

  public String getDescription()
  {
    return description;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    AccidentType compareTo = (AccidentType)obj;
  
    if (code == null && compareTo.code != null)
    {
      return false;
    }
    else if (code != null && !code.equals(compareTo.code))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (code != null)
    {
      cachedHashCode = cachedHashCode * 23 + code.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCode = false;
    return cachedHashCode;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "code" + ":" + getCode()+ "," +
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}