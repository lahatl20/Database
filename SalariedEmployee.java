import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class SalariedEmployee extends Employee implements Serializable
{
  private String empName;
  private double empSal;

  public SalariedEmployee(String name, double pay)
  {
    super(name, pay);
  }
  
  public void setSalary(double pay)
  {
    empSal = pay;
  }
  
  public double getSalary()
  {
    return empSal;
  }
  
  public String computePay(int hours)
  {
    double weekSal = ((getPay())/52);
    
    String pattern = "######.##";
    DecimalFormat decFormat = new DecimalFormat(pattern);
    String weekPay = decFormat.format(weekSal);
    return weekPay;
  }
  
  public String toString()
  {
    String pattern = "######.##";
    DecimalFormat decFormat = new DecimalFormat(pattern);
    String newPay = decFormat.format(getPay());
    return "Employee Name:  " + getName() + "\nEmployee Type:  Salaried" + "\nEmployee Pay:  $" + newPay + "  per year";
  }

}