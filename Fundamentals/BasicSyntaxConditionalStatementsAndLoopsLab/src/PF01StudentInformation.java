import java.util.Scanner;

public class PF01StudentInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double grade = Double.parseDouble(scanner.nextLine());

        System.out.printf("Name: %s, Age: %d, Grade: %.2f", name, age, grade);
    }
}
/*You will be given 3 lines of input – student name, age, and average grade. Your task is to print all the info
about the student in the following format: "Name: {student name}, Age: {student age}, Grade: {student grade}".*/