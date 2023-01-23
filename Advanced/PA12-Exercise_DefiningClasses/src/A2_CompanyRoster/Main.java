package A2_CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>();

        while (num-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Employee employee = null;

            switch (data.length) {
                case 4:
                    employee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3]);
                    break;
                case 5:
                    if (data[4].contains("@")) {
                        employee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4]);
                    } else {
                        employee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], Integer.parseInt(data[4]));
                    }
                    break;
                case 6:
                    employee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4], Integer.parseInt(data[5]));
                    break;
            }

            boolean isDepartmentExist = departments.stream().anyMatch(department -> department.getName().equals(data[3]));
            if (!isDepartmentExist) {
                Department department = new Department(data[3]);
                departments.add(department);
            }
            Department currentDepartment = departments.stream().filter(department ->
                    department.getName().equals(data[3])).findFirst().get();

            currentDepartment.getEmployeesList().add(employee);
        }

        Department highestPaidDep = departments.stream().max(Comparator.comparingDouble(Department::calculateAverageSalary)).get();
        System.out.printf("Highest Average Salary: %s\n", highestPaidDep.getName());
        highestPaidDep.getEmployeesList()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }
}
/*Define a class Employee that holds the following information: name, salary, position, department, email, and age.
The name, salary, position, and department are mandatory, while the rest are optional.
Your task is to write a program that takes N lines of information about employees from the console and calculates
the department with the highest average salary, and prints for each employee in that department
his name, salary, email, and age - sorted by salary in descending order.
If an employee doesn't have an email – in place of that field, you should print "n/a" instead,
if he doesn't have an age – print "-1" instead. The salary should be printed to two decimal places after the separator.
Hint: you can define a Department class that holds a list of employees.
*/
