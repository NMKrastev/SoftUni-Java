import java.util.*;
import java.util.stream.Collectors;

public class A1_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A1_Employee> employeesList = new ArrayList<>();
        int numOfEmployees = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfEmployees; i++) {

            List<String> employeeInfoList = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .collect(Collectors.toList());

            A1_Employee employee = new A1_Employee(String.valueOf(employeeInfoList.get(0)),
            Double.parseDouble(employeeInfoList.get(1)),
            String.valueOf(employeeInfoList.get(2)),
            String.valueOf(employeeInfoList.get(3)));

            if (employeeInfoList.size() == 5) {
                if (employeeInfoList.get(4).contains("@")) {
                    employee.setEmail(String.valueOf(employeeInfoList.get(4)));
                } else {
                    employee.setAge(Integer.parseInt(employeeInfoList.get(4)));
                }
            } else if (employeeInfoList.size() == 6) {
                if (employeeInfoList.get(4).contains("@")) {
                    employee.setEmail(String.valueOf(employeeInfoList.get(4)));
                    employee.setAge(Integer.parseInt(employeeInfoList.get(5)));
                } else {
                    employee.setAge(Integer.parseInt(employeeInfoList.get(4)));
                    employee.setEmail(String.valueOf(employeeInfoList.get(5)));
                }
            }

            employeesList.add(employee);
        }

        List<String> departmentsList = employeesList.stream().map(A1_Employee::getDepartment).distinct().collect(Collectors.toList());

        List<A1_Department> departments = new ArrayList<>();

        for (String department : departmentsList) {

            departments.add(new A1_Department(department, employeesList.stream().filter(employee -> employee.getDepartment()
                    .equals(department)).collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(A1_Department::getHighestSalaryDep).reversed());
        A1_Department department = departments.get(0);
        department.getEmployeesList().sort(Comparator.comparingDouble(A1_Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getWinDepartment());
        for (A1_Employee employee : department.getEmployeesList()) {

            System.out.printf("%s %.2f %s %d%n", employee.getName(),
                    employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }
}
/*Define a class Employee with the following information: name, salary, position, department, email, and age.
The name, salary, position, and department are mandatory, while the rest are optional.
Your task is to write a program that takes N lines of employees from the console and calculates the department
with the highest average salary, and prints for each employee in that department his name, salary, email, and age –
sorted by salary in descending order. If an employee doesn't have an email – in place of that field,
you should print "n/a" instead, if he doesn't have an age – print "-1" instead. The salary should be
printed to two decimal places after the separator.
*/