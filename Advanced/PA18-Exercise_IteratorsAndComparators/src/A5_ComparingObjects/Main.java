package A5_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personsList = new ArrayList<>();
        String input;
        while (!(input = scanner.nextLine()).equals("END")) {

            String[] peopleData = input.split("\\s+");
            String name = peopleData[0];
            int age = Integer.parseInt(peopleData[1]);
            String town = peopleData[2];

            Person person = new Person(name, age, town);
            personsList.add(person);
        }

        int searchedIndex = Integer.parseInt(scanner.nextLine());
        int matchPeopleCount = 0;
        int differentPeopleCount = 0;
        Person mainPerson = personsList.get(searchedIndex - 1);

        for (Person person : personsList) {
            if (person.compareTo(mainPerson) == 0) {
                matchPeopleCount++;
            } else {
                differentPeopleCount++;
            }
        }

        System.out.println(matchPeopleCount != 1
                ? String.format("%d %d %d", matchPeopleCount, differentPeopleCount, personsList.size())
                : "No matches");
    }
}
/*There is a Comparable interface, but probably you already know. Your task is simple. Create a Class Person.
Each person should have a name, age, and town. You should implement the interface -
Comparable and try to override the compareTo method. When you compare two people, first you should compare their names,
after that - their age and last but not least - compare their town.
Input
On single lines, you will be given people in the format:
"{name} {age} {town}"
Collect them till you receive "END".
After that, you will receive an integer N - the Nth person in your collection.
Output
On the single output line, you should bring statistics, how many people are equal to him, how many people
are not equal to him, and the total number of people in your collection.
Format:
•	"{number of equal people} {number of not equal people} {total number of people}"
If there are no equal people, print: "No matches".
Constraints
•	Names, ages, and addresses will be valid.
•	Input number will be always а valid integer in the range [2…100].
*/
