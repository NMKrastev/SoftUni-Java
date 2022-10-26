public class A1_Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public A1_Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
/*Define a class Employee with the following information: name, salary, position, department, email, and age.
The name, salary, position, and department are mandatory, while the rest are optional. */