import java.util.ArrayDeque;
import java.util.Scanner;

public class A1_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        String currentUrl = null;
        ArrayDeque<String> urlStack = new ArrayDeque<>();

        while (!(input = scanner.nextLine()).equals("Home")) {

            if (input.equals("back")) {
                if (urlStack.isEmpty()) {
                    System.out.println("no previous URLs");
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
        }
    }
}
/*Write a program that takes two types of browser instructions:
•	Normal navigation: a URL is set, given by a string;
•	The string "back" sets the current URL to the last set URL
After each instruction, the program should print the current URL. If the back instruction can't be executed, print
"no previous URLs". The input ends with the "Home" command, and then you simply have to stop the program.
*/
