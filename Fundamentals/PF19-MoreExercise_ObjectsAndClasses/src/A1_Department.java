import java.util.ArrayList;
import java.util.List;

public class A1_Department {

    private List<A1_Employee> employeesList = new ArrayList<>();
    private double highestAverageSalary;
    private String winDepartment = "";

    public A1_Department(String winDepartment, List<A1_Employee> employeesList) {
        this.highestAverageSalary = employeesList.stream().mapToDouble(A1_Employee::getSalary).average().getAsDouble();;
        this.winDepartment = winDepartment;
        this.employeesList = employeesList;
    }

    public void add(A1_Employee employee) {
        employeesList.add(employee);
    }

    public double getHighestSalaryDep() {

        return highestAverageSalary;
    }

    public String getWinDepartment() {

        return winDepartment;
    }

    public List<A1_Employee> getEmployeesList() {

        return employeesList;
    }
}
