package EP5_JavaAdvancedRetakeExam16December2020.A3_Openning;

import java.util.*;
import java.util.stream.Collectors;

public class Bakery {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
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
                .findFirst().orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        return String.format("Employees working at Bakery %s:\n%s", name, employees.stream()
                .map(Employee::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
