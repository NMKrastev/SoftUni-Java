package A5_ComparingObjects;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object otherPerson) {
        if (this == otherPerson) return true;
        if (otherPerson == null || getClass() != otherPerson.getClass()) return false;
        Person person = (Person) otherPerson;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(town, person.town);
    }

    @Override
    public int compareTo(Person otherPerson) {
        if (this.getName().equals(otherPerson.getName())) {
            if (this.getAge() == otherPerson.getAge()) {
                return this.getTown().compareTo(otherPerson.getTown());
            } else {
                return Integer.compare(this.getAge(), otherPerson.getAge());
            }
        }
        return this.getName().compareTo(otherPerson.getName());
    }
}
