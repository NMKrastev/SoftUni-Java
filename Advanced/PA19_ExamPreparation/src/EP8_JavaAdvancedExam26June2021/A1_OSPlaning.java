package EP8_JavaAdvancedExam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A1_OSPlaning {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(tasks::push);
        Deque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(threads::offer);
        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (true) {

            int task = tasks.pop();
            int thread = threads.poll();

            if (thread < task) {
                tasks.push(task);
            }

            if (tasks.peek() == taskToKill) {
                System.out.printf("Thread with value %d killed task %d\n", threads.peek(), tasks.peek());
                System.out.println(threads.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));
                return;
            }
        }
    }
}
/*On the first line, you will be given some tasks as integer values, separated by a comma and space ", ".
On the second line, you will be given some threads as integer values, separated by a single space.
On the third line, you will receive the integer value of a task that you need to kill.
Your job is to stop the work of the OS as soon as you get to this task, otherwise, your OS will crash.
The thread that gets first to this task, kills it.
The OS works in the following way:
•	It takes the first given thread value and the last given task value.
•	If the thread value is greater than or equal to the task value, the task and thread get removed.
•	If the thread value is less than the task value, the thread gets removed, but the task remains.
After you finish the needed task, print on a single line:
"Thread with value {thread} killed task {taskToBeKilled}"
Then print the remaining threads (including the one that killed the task) starting from the first on a single line,
separated by a single space.
Input
•	On the first line, you will receive the tasks, separated by ", ".
•	On the second line, you will the threads, separated by a single space.
•	On the third line, you will receive a single integer – a value of the task to be killed.
Output
•	Print the thread that killed the task and the task itself in the format given above.
•	Print the remaining threads starting from the first on a single line, separated by a single space.
Constraints
•	The needed task will always be with a unique value.
•	You will always have enough threads to get to the needed task.
*/
