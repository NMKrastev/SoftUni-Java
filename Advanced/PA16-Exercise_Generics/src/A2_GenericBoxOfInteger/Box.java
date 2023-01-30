package A2_GenericBoxOfInteger;

public class Box <T> {

    private T name;

    public Box(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name.getClass(), name).replace("class ", "");
    }
}
