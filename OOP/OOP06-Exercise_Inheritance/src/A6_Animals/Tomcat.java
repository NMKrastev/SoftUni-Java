package A6_Animals;

public class Tomcat extends Cat {

    private final static String DEFAULT_GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, DEFAULT_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
