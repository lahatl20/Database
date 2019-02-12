# Database

Project 3 (Personnel Database)
Written by: Langston Hughes

1. Project Description: In this project, a menu is used for the user to interact with to edit a personnel database. In the menu, the user can add a new employee, compute the weekly paychecks of all
employees, raise the wages of all employees by a percentage(user enters this), print the records of all employees (one at a time), download the data from the server (reads from a text file of employee
info), upload data to the server (writes employee info to a text file), or quit the program.

2. EmployeeTester Class
	A. Main Method
		i. Uses a main menu for the user to interact with
		ii. Main menu options
			n - New employee
			c - Compute paychecks
			r - Raise wages
			p - Print records
			d - Download data
			u - Upload data
			q - Quit
	B. Other Methods
		i. newEmp: creates a new employee and store it in the databse
		ii. compChecks: compute the weekly paychecks for each employee
		iii. raiseWage: raises all employee's wage by an entered percentage
		iv. printRecords: prints all employee records on record at a time (prompts user to press enter to continue)
		v. dataDownload: downloads the file data to an ArrayList
		vi. dataUpload: uploads the data to a text file

3. Personnel Class (abstract)
	A. empName: instance variable for employee name (String)
	B. empPay: instance variable for employee pay (double)
	C. Methods
		i. setName, getName: getter method and setter method for the employee name
		ii. setPay, getPay: getter method and setter method for the employee pay
		iii. increasePay: increases the pay of an employee by a given percentage
		iv. computePay (abstract): computes the weekly pay for the employee when given the numbers worked

4. HourlyEmployee Class (enxtends Employee)
	A. Constructor: takes a name and hourly wage as its parameters
	B. Methods
		i. computePay: multiplies 1st 40 hrs. (or fewer) by employee's hourly hourly wage. Hours after 40 are multiplied by 1.5 times employees wage
		ii. toString: returns a string containing employee's name and hourly wage

5. SalariedEmployee Class (extends Employee)
	A. Constructor: takes a name and annual salry as its parameters
	B. Methods
		i. setSalary, getSalary: getter and setter methods for the annual salary
		ii. computePay: returns 1/52 of the annual salary regardless of hours worked
		iii. toString: returns a string containing employee's name and annual salary
