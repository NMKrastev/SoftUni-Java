package A1_MathOperation;

public class Main {

    public static void main(String[] args) {

        MathOperation math = new MathOperation();
        System.out.println(math.add(2, 2));
        System.out.println(math.add(3, 3, 3));
        System.out.println(math.add(4, 4, 4, 4));

    }
}
/*Create a class MathOperation, which should have method add().
Method add() has to be invoked with two, three, or four Integers.
You should be able to use the class like this:
Main.java
public static void main(String[] args) throws IOException {
    MathOperation math = new MathOperation();
    System.out.println(math.add(2, 2));
    System.out.println(math.add(3, 3, 3));
    System.out.println(math.add(4, 4, 4, 4));
}
*/
