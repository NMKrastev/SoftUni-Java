import java.util.ArrayDeque;
import java.util.Scanner;

public class A8_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        ArrayDeque<String> urlStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();
        String currentUrl;
        String currentForward;

        while (!(input = scanner.nextLine()).equals("Home")) {

            if (input.equals("back")) {
                if (urlStack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    currentUrl = urlStack.pop();
                    forwardQueue.push(currentUrl);
                    System.out.println(urlStack.peek());
                }
            } else if (input.equals("forward")) {
                if (forwardQueue.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    currentForward = forwardQueue.pop();
                    System.out.println(currentForward);
                    urlStack.push(currentForward);
                }
            } else {
                urlStack.push(input);
                System.out.println(input);
                forwardQueue.clear();
            }
        }
    }
}
/*Extend "Browser History" with a "forward" instruction, which visits URLs that were navigated away from by "back".
Each forward instruction visits the next most recent such URL. If normal navigation happens, all potential forward
URLs are removed until a new back instruction is given if the forward instruction can't be executed, print
"no next URLs".
*/
