package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String registerStudent(Student student) {
        if (students.size() >= capacity) {
            return "No seats in the university";
        } else if (students.contains(student)) {
            return "Student is already in the university";
        } else {
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
    }

    public String dismissStudent(Student student) {
        if (!students.contains(student)) {
            return "Student not found";
        } else {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return students.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public int getStudentCount() {
        return students.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        students.forEach(e -> sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                e.getFirstName(), e.getLastName(), e.getBestSubject())).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
