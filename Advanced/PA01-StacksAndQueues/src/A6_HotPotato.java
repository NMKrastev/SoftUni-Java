import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class A6_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> namesQueue = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+")).forEach(name -> namesQueue.offer(name));
        int turns = Integer.parseInt(scanner.nextLine());

        while (namesQueue.size() > 1) {
            for (int i = 1; i < turns; i++) {
                namesQueue.offer(namesQueue.poll());
            }
            System.out.println("Removed " + namesQueue.poll());
        }
        System.out.println("Last is " + namesQueue.poll());
    }
}
/*Hot potato is a game in which children form a circle and start passing a hot potato.
The counting starts with the first kid. Every nth toss, the child left with the potato leaves the game.
When a kid leaves the game, it passes the potato forward. This continues repeating until there is only one kid left.
Create a program that simulates the game of Hot Potato. Print every kid that is removed from the circle.
In the end, print the kid that is left last.
*/
