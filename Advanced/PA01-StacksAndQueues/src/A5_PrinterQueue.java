import java.util.ArrayDeque;
import java.util.Scanner;

public class A5_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        String input;

        while (!(input = scanner.nextLine()).equals("print")) {

            if (input.equals("cancel")) {
                String output = printerQueue.isEmpty()
                        ? "Printer is on standby"
                        : "Canceled " + printerQueue.poll();
                System.out.println(output);
            } else {
                printerQueue.offer(input);
            }
        }

        for (String file : printerQueue) {
            System.out.println(file);
        }
    }
}
/*The printer queue is a simple way to control the order of files sent to a printer device.
We know that a single printer can be shared between multiple devices. So to preserve the order of the
files sent, we can use a queue.
Write a program which takes filenames until the "print" command is received. Then as output,
print the filenames in the order of printing. Some of the tasks may be canceled.
If you receive "cancel" you have to remove the first file to be printed.
If there is no current file to be printed, print "Printer is on standby".
*/
