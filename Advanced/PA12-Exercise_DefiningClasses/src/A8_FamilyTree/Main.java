package A8_FamilyTree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOrBirthday = scanner.nextLine();
        Map<String, List<String>> familyMap = new LinkedHashMap<>();
        Set<String> familySet = new LinkedHashSet<>();
        List<Person> personsList = new ArrayList<>();
        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            if (input.contains(" - ")) {
                String parentData = input.split("\\s+-\\s+")[0];
                String childData = input.split("\\s+-\\s+")[1];
                familyMap.putIfAbsent(parentData, new ArrayList<>());
                familyMap.get(parentData).add(childData);
                familySet.add(parentData);
                familySet.add(childData);

            } else {
                String name = input.split("\\s+")[0] + " " + input.split("\\s+")[1];
                String birthday = input.split("\\s+")[input.split("\\s+").length - 1];
                Person person = new Person(name, birthday);
                personsList.add(person);

            }
        }

        familySet.forEach(data -> {
            Person person = getPersonInfo(data, personsList);
            familyMap.forEach((key, value) -> {
                Person parent = getPersonInfo(key, personsList);
                value.forEach(childEntry -> {
                    Person child = getPersonInfo(childEntry, personsList);
                    if (person == child) {
                        person.addParent(parent);
                    } else if (person == parent) {
                        person.addChild(child);
                    }
                });
            });
        });

        System.out.println(getPersonInfo(nameOrBirthday, personsList).toString());
    }

    private static Person getPersonInfo(String data, List<Person> personsList) {
        Person currentPerson = null;
        for (Person person : personsList) {
            if (person.getName().equals(data) || person.getBirthday().equals(data)) {
                currentPerson = person;
            }
        }
        return currentPerson;
    }
}
/*On the first line of the input, you will receive either a name or a birthdate in the format "{FirstName} {LastName}"
or "day/month/year" - your task is to find information about the person in the family tree. On the next lines,
until the command "End" is received, you will receive information about your predecessors that you will use to build the family tree.
The information will be in one of the following formats:
•	"{FirstName} {LastName} – {FirstName} {LastName}"
•	"{FirstName} {LastName} – {day/month/year}"
•	"{day/month/year} – {FirstName} {LastName}"
•	"{day/month/year} – {day/month/year}"
•	"{FirstName} {LastName} {day/month/year}"
The first 4 formats reveal a family tie – the person on the left is the parent of the person on the right
(as you can see the format does not need to contain names, for example, the 4th format means the person born on the
left date is parent to the person born on the right date). The last format ties different information together – i.e.
the person with that name was born on that date. Names and birthdates are unique – there won't be 2 people with
the same name or birthdate, there will always be enough entries to construct the family tree
(all people's names and birthdates are known, and they have at least one connection to another person in the tree).
After the command "End" is received, you should print all information about the person whose name or birthdate you
received on the first line – his name, birthday, parents, and children (check the examples for the format).
The people in the parents and children lists should be ordered by their first appearance in the input
(regardless if they appeared as a birthdate or a name, for example, in the first input, Peter is before Sara because
he first appeared in the first line, while she appears in the third).
*/
