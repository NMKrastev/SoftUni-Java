package A6_Animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throwErrorMessage();
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throwErrorMessage();
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throwErrorMessage();
        }
        this.gender = gender;
    }

    public String produceSound() {
        return "";
    }

    private static void throwErrorMessage() {
        throw new IllegalArgumentException("Invalid input!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append(String.format("%s %d %s", name, age, gender))
                .append(System.lineSeparator())
                .append(produceSound());
        return sb.toString().trim();
    }
}
