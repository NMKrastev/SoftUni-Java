package A6_StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if (first.getName().length() == second.getName().length()) {
            char startLetterOfFirstPerson = first.getName().toLowerCase().charAt(0);
            char startLetterOfSecondPerson = second.getName().toLowerCase().charAt(0);
            return Character.compare(startLetterOfFirstPerson, startLetterOfSecondPerson);
        }
        return first.getName().length() - second.getName().length();
    }
}
