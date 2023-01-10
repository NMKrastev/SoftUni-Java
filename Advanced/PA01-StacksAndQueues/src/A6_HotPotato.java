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
