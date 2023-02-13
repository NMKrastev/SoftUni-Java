package A3_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void parseCommand(String[] info) {

        String firstArgument = info[0];
        String name = info[1];

        if (firstArgument.equals("Create")) {
            int age = Integer.parseInt(info[2]);
            double grade = Double.parseDouble(info[3]);
            if (!repo.containsKey(name)) {
                var student = new Student(name, age, grade);
                repo.put(name, student);
            }
        } else if (firstArgument.equals("Show")) {
            if (repo.containsKey(name)) {
                Student student = repo.get(name);
                StringBuilder sb = new StringBuilder(String.format("%s is %s years old.", student.getName(), student.getAge()));
                if (student.getGrade() >= 5.00) {
                    sb.append(" Excellent student.");
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    sb.append(" Average student.");
                } else {
                    sb.append(" Very nice person.");
                }

                System.out.println(sb.toString());
            }
        }
    }
}
