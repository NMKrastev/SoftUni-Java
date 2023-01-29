package A3_GenericScal;

public class Main {
    public static void main(String[] args) {


        Scale<Integer> scale = new Scale<>(5, 6);

        Scale<String> stringScale = new Scale<>("A", "B");

        System.out.println(scale.getHeavier());
        System.out.println(stringScale.getHeavier());
    }
}
/*Create a class Scale<T> that holds two elements - left and right.
The scale should receive the elements through its single constructor:
•	Scale(T left, T right)
The scale should have a single method:
•	T getHeavier()
The greater of the two elements is heavier. The method should return null if elements are equal.
*/
