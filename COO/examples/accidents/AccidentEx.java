package accidents;
import java.sql.Date;
import java.sql.Time;

public class Accident
{
  private String id;
  private String description;
  private Date date;
  private Time time;
  private String other_details;

  private Employee employee;
  private AccidentType accidentType;
  private SeriousnessLevel seriousnessLevel;

  public Accident(String aId, String aDescription, Date aDate, Time aTime, String aOther_details, Employee aEmployee, AccidentType aAccidentType, SeriousnessLevel aSeriousnessLevel)
  { ... }
  // gettes and setters
  ... 
  public Employee getEmployee(){ ... }
  public AccidentType getAccidentType(){ ... }
  public SeriousnessLevel getSeriousnessLevel(){ ... }
  public boolean setEmployee(Employee aEmployee){ ... }
  public boolean setAccidentType(AccidentType aNewAccidentType){ ... }
  public boolean setSeriousnessLevel(SeriousnessLevel aNewSeriousnessLevel){ ... }
}