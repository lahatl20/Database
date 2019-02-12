import java.util.*;
import java.io.*;

public class EmployeeTester implements Serializable
{
  private static ArrayList<Employee> employees = new ArrayList<Employee>();
  
  public static void main(String[] args)
  {
    menu();
  }
  
  public static void menu()
  {
    //post: This method is the main menu of the database program
    System.out.println("");
    Scanner input = new Scanner(System.in);
    
    //menu options
    System.out.println("         Personnel Databse Menu         ");
    System.out.println("****************************************");
    System.out.println("*Commands:    N - New Employee         *");
    System.out.println("*             C - Compute Paychecks    *");
    System.out.println("*             R - Raise Wages          *");
    System.out.println("*             P - Print Records        *");
    System.out.println("*             D - Download Data        *");
    System.out.println("*             U - Upload Data          *");
    System.out.println("*             Q - Quit                 *");
    System.out.println("****************************************");
    System.out.println("");
    
    //select an option from the menu
    System.out.print("Please select an option above: ");
    char menu = input.next(".").charAt(0);
    
    //determine which option is selected
    if(menu == 'N' || menu == 'n')
      newEmp();
    else if(menu == 'C' || menu == 'c')
      compChecks();
    else if(menu == 'R' || menu == 'r')
      raiseWage();
    else if(menu == 'P' || menu == 'p')
      printRecords();
    else if(menu == 'D' || menu == 'd')
      dataDownload();
    else if(menu == 'U' || menu == 'u')
      dataUpload();
    else if(menu == 'Q' || menu == 'q')
    {
      System.exit(0);
      
    }
    else
    {
      System.out.println("Invalid entry please try again.");
      System.out.println("");
      menu();
    }
  }

  public static void newEmp()
  {
    //post: this method creates a new employee
    Scanner input = new Scanner(System.in);
    double pay = 0;
    
    System.out.print("Enter the name of the new employee (last, first): ");
    String emp = input.nextLine();
    
    System.out.print("Salaried (S) or Hourly (H): ");
    char type = input.next(".").charAt(0);
    
    if(type == 'S' || type == 's')
    {
      System.out.print("Enter annual salary: ");
      pay = input.nextDouble();
      employees.add(new SalariedEmployee(emp, pay));
    }
    else if(type == 'H' || type == 'h')
    {
      System.out.print("Enter hourly wage: ");
      pay = input.nextDouble();
      employees.add(new HourlyEmployee(emp, pay));
    }
    else
    {
      System.out.println("Invalid input. Please try again.");
      newEmp();
    }

    menu();
  }
  
  public static void compChecks()
  {
    //compute weekly paycheck for employees
    clearScreen();
    Scanner input = new Scanner(System.in);
    for(int i = 0; i < employees.size(); i++)
    {
      System.out.print("Enter the number of hours worked by " + employees.get(i).getName() + ": ");
      int hours = input.nextInt();
      System.out.println("Pay = $" + employees.get(i).computePay(hours));
    }
    
    menu();
  }
  
  public static void raiseWage()
  {
    //raises the wage of employees by a percentage
    clearScreen();
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the percent to increase the wages by: ");
    double percent = input.nextDouble();
    System.out.println("");
    
    for(int i = 0; i < employees.size(); i++)
    {
      employees.get(i).increasePay(percent);
    }
    for(int j = 0; j < employees.size(); j++)
    {
      System.out.println(employees.get(j).toString());
      System.out.println("");
    }
    
    menu();
  }
  
  public static void printRecords()
  {
    //prints employee records
    Scanner input =  new Scanner(System.in);
    
    for(int i = 0; i < employees.size(); i++)
    {
      clearScreen();
      System.out.println(employees.get(i).toString());
      System.out.print("Press \"enter\" to continue. Press M to go back to the menu...");
      String enter = input.nextLine();
      if ((enter.compareTo("M")) == 0 || (enter.compareTo("m")) == 0)
          break;
    }
    
    menu();
  }
  
  public static void dataDownload()
  {
    //post: downloads data from a file into an arraylist
    String fileName = "Employees.dat";
    int counter = 0;
    
    try
    {
      FileInputStream fileIn = new FileInputStream(fileName);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      employees = (ArrayList<Employee>) in.readObject();
      in.close();
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
    catch (ClassNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    
    printRecords();
    menu();
  }
  
  public static void dataUpload()
  {
    //post: uploads arraylist data to a file
    String fileName = "Employees.dat";
    
    try
    {
      FileOutputStream fileOut = new FileOutputStream(fileName);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(employees);
      out.close();
      
      System.out.println("");
      System.out.println("All employees were loaded to the server.");
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
    menu();
  }
   
  private static void clearScreen()
  {
      //Post: This method clears the screen
      System.out.println("\u001b[H\u001b[2J");
  }
}