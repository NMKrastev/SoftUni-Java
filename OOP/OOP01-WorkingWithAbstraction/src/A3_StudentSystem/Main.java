package A3_StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();
        String input;

        while (!(input = scanner.nextLine()).equals("Exit")) {
            String[] info = input.split("\\s+");
            studentSystem.parseCommand(info);
        }
    }
}
