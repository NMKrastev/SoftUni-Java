public class A4_Student {

    private String firstName;
    private String lastName;
    private double grade;

    public A4_Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    //Can be used on a later stage for comparing or sorting by first name if needed
    /*public String getFirstName() {
        return firstName;
    }*/

    //Can be used on a later stage for comparing or sorting by last name if needed
    /*public String getLastName() {
        return lastName;
    }*/

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
    }
}
