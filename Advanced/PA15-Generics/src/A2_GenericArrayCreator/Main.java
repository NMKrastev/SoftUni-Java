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
