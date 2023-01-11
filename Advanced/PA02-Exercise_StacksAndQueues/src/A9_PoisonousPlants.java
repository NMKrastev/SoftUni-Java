import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A9_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPlants = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");
        int[] pesticides = new int[numOfPlants];

        for (int i = 0; i < numOfPlants; i++) {
            pesticides[i] = Integer.parseInt(input[i]);
        }

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);
        int[] days = new int[numOfPlants];

        for (int i = 1; i < numOfPlants; i++) {
            int maxDays = 0;
            while (!indexes.isEmpty() && pesticides[indexes.peek()] >= pesticides[i]) {
                maxDays = Math.max(maxDays, days[indexes.pop()]);
            }
            if (!indexes.isEmpty()) {
                days[i] = maxDays + 1;
            }
            indexes.push(i);
        }

        int max = Arrays.stream(days).max().getAsInt();
        System.out.println(max);
    }
}

/*int numOfPlants = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> initialStack = new ArrayDeque<>(numOfPlants);
        for (String num : input) {
            initialStack.push(Integer.valueOf(num));
        }
        ArrayDeque<Integer> deadQueue = new ArrayDeque<>();
        ArrayDeque<Integer> aliveQueue = new ArrayDeque<>();

        int countDays = 0;

        while (!initialStack.isEmpty()) {
            int currentNum = initialStack.pop();
            if (initialStack.size() > 1 && currentNum > initialStack.peek()) {
                deadQueue.push(currentNum);
            } else {
                aliveQueue.offer(currentNum);
            }

            if (initialStack.isEmpty()) {
                if (deadQueue.isEmpty()) {
                    if (countDays == 0) {
                        countDays = 1;
                    }
                    break;
                }
                initialStack = new ArrayDeque<>(aliveQueue);
                aliveQueue = new ArrayDeque<>();
                deadQueue = new ArrayDeque<>();
                countDays++;
            }
        }

        System.out.println(countDays);*/
/*You are given N plants in a garden. Each of these plants has been added with some amount of pesticide. You are given
the pesticide's initial values and each plant's position. After each day, if any plant has more pesticide than the
plant at its left, being weaker (more GMO) than the left one, it dies. Print the number of days after which no plant
dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.
Input
•	The input consists of an integer N representing the number of plants.
•	The next single line consists of N integers, where every integer represents each plant's position
and amount of pesticides. 1 ≤ N ≤ 100000.
•	Pesticides amount on a plant is between 0 and 1000000000.
Output
•	Output a single value equal to the number of days after which no plants die.
*/
