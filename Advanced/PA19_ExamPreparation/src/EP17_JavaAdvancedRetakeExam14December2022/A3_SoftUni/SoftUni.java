package EP17_JavaAdvancedRetakeExam14December2022.A3_SoftUni;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String insert(Student student) {
        if (data.size() < capacity) {
            if (data.contains(student)) {
                return "Student is already in the hall.";
            } else {
                data.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            }
        } else {
            return "The hall is full.";
        }
    }

    public String remove(Student student) {
        if (data.contains(student)) {
            data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return data.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        return String.format("Hall size: %d\n%s", getCount(), data.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
