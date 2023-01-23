package A2_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeesList;

    public Department(String name) {
        this.name = name;
        employeesList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    public double calculateAverageSalary() {
        return this.employeesList.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }
}
