import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A3_OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A3_Person> personsList = new ArrayList<>();
        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {
            String line = scanner.nextLine();
            String name = line.split("\\s+")[0];
            int age = Integer.parseInt(line.split("\\s+")[1]);

            A3_Person person = new A3_Person(name, age);
            personsList.add(person);
        }

        printPersonsOlderThanThirty(personsList);
    }

    private static void printPersonsOlderThanThirty(List<A3_Person> personsList) {

        for (A3_Person person: personsList) {
            if (person.getAge() > 30) {
                System.out.printf("%s - %d\n", person.getName(), person.getAge());
            }
        }
    }
}
/*Using the Person class, write a program that reads from the console N lines of
personal information and then prints all people whose age is more than 30 years.*/