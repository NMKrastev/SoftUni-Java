import java.util.Scanner;

public class A6_BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isBalanced = true, isOpen = false;
        int openingBracketCount = 0, closingBracketCount = 0, consecutiveOpeningBracketsCount = 0;

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {

            String input = scanner.nextLine();

            if (isOpen && input.equals("(")){

                System.out.println("UNBALANCED");
                isBalanced = false;
                break;

            } else {

                isOpen = false;

            }

            if (input.equals("(")) {

                openingBracketCount++;
                isOpen = true;

            } else if (input.equals(")")) {

                closingBracketCount++;

            }

            if (input.equals("(") && i == num - 1) {

                System.out.println("UNBALANCED");
                isBalanced = false;
                break;

            }

        }
        if (isBalanced) {

            if (openingBracketCount == closingBracketCount) {

                System.out.println("BALANCED");

            } else {

                System.out.println("UNBALANCED");
            }
        }
    }
}
/*You will receive n lines. On those lines, you will receive one of the following:
•	Opening bracket – "(",
•	Closing bracket – ")" or
•	Random string
Your task is to find out if the brackets are balanced. That means after every closing bracket should follow an
opening one. Nested parentheses are not valid, and if two consecutive opening brackets exist, the expression
should be marked as unbalanced.
Input:
•	On the first line, you will receive n – the number of lines, which will follow.
•	On the next n lines, you will receive "(", ")" or another string.
Output:
You have to print "BALANCED" if the parentheses are balanced and "UNBALANCED" otherwise.
Constraints:
•	n will be in the interval [1…20].
•	The length of the stings will be between [1…100] characters.
*/