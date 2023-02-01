package A6_StrategyPattern;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        return first.getAge() - second.getAge();
    }
}
