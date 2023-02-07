package EP5_JavaAdvancedRetakeExam16December2020.A3_Openning.src;

import EP5_JavaAdvancedRetakeExam16December2020.A3_Openning.Bakery;
import EP5_JavaAdvancedRetakeExam16December2020.A3_Openning.Employee;

public class Main {
    public static void main(String[] args) {
        //TODO:
        Bakery bakery = new Bakery("Barny", 10);
//Initialize entity
        Employee employee = new Employee("Stephen", 40, "Bulgaria");
//Print Employee
        System.out.println(employee); //Employee: Stephen, 40 (Bulgaria)

//Add Employee
        bakery.add(employee);
//Remove Employee
        System.out.println(bakery.remove("Employee name")); //false

        Employee secondEmployee = new Employee("Mark", 34, "UK");

//Add Employee
        bakery.add(secondEmployee);

        Employee oldestEmployee = bakery.getOldestEmployee(); // Employee with name Stephen
        Employee employeeStephen = bakery.getEmployee("Stephen"); // Employee with name Stephen
        System.out.println(oldestEmployee); //Employee: Stephen, 40 (Bulgaria)
        System.out.println(employeeStephen); //Employee: Stephen, 40 (Bulgaria)

        System.out.println(bakery.getCount()); //2

        System.out.println(bakery.report());
//Employees working at Bakery Barny:
//Employee: Stephen, 40 (Bulgaria)
//Employee: Mark, 34 (UK)

    }
}
/*Your task is to create a bakery, which stores employees by creating the classes described below.
First, write a Java class Employee with the following properties:
•	name: String
•	age: int
•	country: String
The class constructor should receive name, age and country and override the ToString() method in the following format:
"Employee: {name}, {age} ({country})"
Next, write a Java class Bakery that has employees (a collection, which stores the entity Employee).
All entities inside the repository have the same properties. Also, the Bakery class should have those properties:
•	name: String
•	capacity: int
The class constructor should receive the name and capacity, also it should initialize the employees with
a new instance of the collection. Implement the following features:
•	Field employees – List that holds added Employees
•	Method add(Employee employee) – adds an entity to the data if there is room for him/her.
•	Method remove(String name) – removes an employee by given name, if such exists, and returns a bool.
•	Method getOldestEmployee() – returns the oldest employee.
•	Method getEmployee(string name) – returns the employee with the given name.
•	Getter getCount() – returns the number of employees.
•	report() – returns a string in the following format:
o	"Employees working at Bakery {bakeryName}:
{Employee1}
{Employee2}
(…)"
Constraints
•	The names of the employees will be always unique.
•	The age of the employees will always be with positive values.
•	You will always have an employee added before receiving methods manipulating the Space Station’s Employees.
*/
