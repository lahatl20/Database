import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public abstract class Employee implements Serializable
{
  private String empName;
  private double empPay;
  
  public Employee(String name, double pay)
  {
    empName = name;
    empPay = pay;
  }
  
  public void setName(String name)
  {
    empName = name;
  }
  
  public String getName()
  {
    return empName;
  }
  
  public void setPay(double pay)
  {
    empPay = pay;
  }
  
  public double getPay()
  {
    return empPay;
  }
  
  public double increasePay(double percent)
  {
    double total = (empPay * (percent/100)) + empPay;
    setPay(total);
    return total;
  }
  
  public abstract String computePay(int hours);
}