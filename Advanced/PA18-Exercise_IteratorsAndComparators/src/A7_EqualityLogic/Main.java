package A7_EqualityLogic;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> personsTree = new TreeSet<>();
        HashSet<Person> personsHash = new HashSet<>();

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);

            personsTree.add(person);
            personsHash.add(person);
        }

        System.out.println(personsTree.size());
        System.out.println(personsHash.size());
    }
}
/*Create a class Person holding name and age. A person with the same name and age should be considered the same,
override any methods needed to enforce this logic. Your class should work with both standards and hashed collections.
Create a TreeSet and a HashSet of type Person.
Input
On the first line of input, you will receive a number N. On each of the next N lines, you will receive information
about people in the format "{name} {age}". Add the people from the input into both sets (both sets should hold all
the people passed in from the input).
Output
The output should consist of exactly 2 lines. On the first, you should print the size of the TreeSet, and on the second
- the size of the HashSet.
Constraints
•	A person's name will be a string that contains only alphanumerical characters with a length between [1…50] symbols.
•	A person's age will be a positive integer between [1…100].
•	The number of people N will be a positive integer between [0…100]
*/
