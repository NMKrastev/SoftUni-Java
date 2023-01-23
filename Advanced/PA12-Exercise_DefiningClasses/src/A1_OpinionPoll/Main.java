package A1_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class A1PA12_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        List<A1PA12_Person> personsList = new ArrayList<>();
        A1PA12_Person person;
        while (num-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

            person = new A1PA12_Person(data[0], Integer.parseInt(data[1]));
            personsList.add(person);
        }

        Predicate<A1PA12_Person> findAge = age -> age.getAge() > 30;
        personsList.stream().filter(findAge)
                .sorted(Comparator.comparing(A1PA12_Person::getName))
                .forEach(p ->
                        System.out.printf("%s - %d\n", p.getName(), p.getAge()));
    }
}
/*Create a Person class with two fields String name and int age. Write a program that reads from the console N lines
of personal information and then prints all people whose age is more than 30 years, sorted in alphabetical order.
Note: you can use the stream() to filter people.
*/
