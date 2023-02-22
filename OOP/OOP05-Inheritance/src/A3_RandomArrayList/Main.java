package A3_RandomArrayList;

public class Main {

    public static void main(String[] args) {

        RandomArrayList<Integer> list = new RandomArrayList<>();

        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println(list.getRandomElement());
    }
}
/*Create a RandomArrayList class that has all the functionality of an ArrayList.
Add an additional function that returns and removes a random element from the list.
•	Public method: getRandomElement(): Object
*/