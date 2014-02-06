package accidents;
public class Employee
{
  private String id;
  private String department;
  private String name;
  private String supervisor;
  private String other_employee_details;

  private List<Accident> accidents;

  public Employee(String aId, String aDepartment, String aName, ...){ ... }
  public Accident getAccident(int index){ ... }
  public List<Accident> getAccidents(){ ... }
  public int numberOfAccidents(){ ... }
  public boolean hasAccidents(){ ... }
  public int indexOfAccident(Accident aAccident){ ... }
  public static int minimumNumberOfAccidents(){return 0;}
  public Accident addAccident(String aId, String aDescription, Date aDate, ...){ ... }
  public boolean addAccident(Accident aAccident){ ... }
  public boolean removeAccident(Accident aAccident){ ... }
}