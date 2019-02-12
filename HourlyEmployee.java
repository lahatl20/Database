import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class HourlyEmployee extends Employee implements Serializable
{

  public HourlyEmployee(String name, double pay)
  {
    super(name, pay);
  }
  
  public String computePay(int hours)
  {
    double weekPay1 = 0; 
    double weekPay2 = 0;
    double total = 0;
    
    for(int i = 1; i <= hours; i++)
    {
      if(i <= 40)
        weekPay1 += (getPay());
      
      if(i > 40)
        weekPay2 += ((getPay()) * 1.5);
    }
    
    total = weekPay1 + weekPay2;
    String pattern = "######.##";
    DecimalFormat decFormat = new DecimalFormat(pattern);
    String weekPay = decFormat.format(total);
    return weekPay; 
  }
  
  public String toString()
  {
    String pattern = "######.##";
    DecimalFormat decFormat = new DecimalFormat(pattern);
    String newPay = decFormat.format(getPay());
    return "Employee Name:  " + getName() + "\nEmployee Type:  Hourly" + "\nEmployee Pay:  $" + newPay + "  per hour";
  }
}