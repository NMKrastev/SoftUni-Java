import java.util.ArrayDeque;
import java.util.Scanner;

public class A1_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String currentUrl = null;
        ArrayDeque<String> urlStack = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (urlStack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = urlStack.pop();
                }
            } else {
                if (currentUrl != null) {
                    urlStack.push(currentUrl);
                }
                currentUrl = input;
            }

            System.out.println(currentUrl);

            input = scanner.nextLine();
        }
    }
}
