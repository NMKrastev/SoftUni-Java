package EP9_JavaAdvancedRetakeExam18August2021.A3_Cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }


    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        return String.format("Employees working at Cafe %s\n%s", name, employees.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
