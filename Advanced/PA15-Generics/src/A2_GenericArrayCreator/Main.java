package A2_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {


        Integer[] array = ArrayCreator.create(Integer.class, 5, 7);
        for (int i : array) {
            System.out.print(i + " ");
        }

        String[] arr = ArrayCreator.create(String.class, 5, "Java");
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
/*Create a class ArrayCreator with a method and a single overload to it:
•	static T[] create(int length, T item)
•	static T[] create(Class<T> class, int length, T item)
The method should return an array with the given length, and every element should be set to the given default item.
*/
