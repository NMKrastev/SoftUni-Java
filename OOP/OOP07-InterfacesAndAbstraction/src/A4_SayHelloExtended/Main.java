package A4_SayHelloExtended;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        persons.add(new Bulgarian("Peter"));
        persons.add(new European("Peter"));
        persons.add(new Chinese("Peter"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
/*Build hierarchy from classes and interfaces for this UML diagram

                                                Bulgarian
                                                +Bulgarian(name)
                                                +sayHello(): String
                                              /
                                            /
                                          /
<<Person>>                  BasePerson                      European
+getName(): String          -name: String                   +European(name)
+sayHello(): String <-----  #BasePerson(name) <-----------  +sayHello(): String
(Abstract)                  +getName(): String
                            -setName(): void
                                             \
                                               \
                                                 \
                                                 Chinese
                                                 +Chinese(name)
                                                 +sayHello(): String
*/
