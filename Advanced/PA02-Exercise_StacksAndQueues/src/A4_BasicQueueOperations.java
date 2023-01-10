import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class A4_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int s = Integer.parseInt(input.split("\\s+")[1]);
        int x = Integer.parseInt(input.split("\\s+")[2]);
        String nums = scanner.nextLine();
        ArrayDeque<Integer> elementsQueue = new ArrayDeque<>();
        Arrays.stream(nums.split("\\s+")).forEach(num -> elementsQueue.offer(Integer.parseInt(num)));

        for (int i = 0; i < s; i++) {
            elementsQueue.poll();
        }
        if (elementsQueue.isEmpty()) {
            System.out.println(0);
        } else if (elementsQueue.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(elementsQueue));
        }
    }
}
/*You will be given an integer N representing the number of elements to enqueue (add), an integer S representing
the number of elements to dequeue (remove/poll) from the queue, and finally, an integer X, an element that you
should check whether is present in the queue. If it is - prints true on the console,
if it is not - print the smallest element currently present in the queue.*/
