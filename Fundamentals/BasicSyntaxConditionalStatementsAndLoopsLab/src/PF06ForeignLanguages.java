import java.util.Scanner;

public class PF06ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("England") || input.equals("USA")) {
            System.out.println("English");
        } else if (input.equals("Spain") || input.equals("Argentina") || input.equals("Mexico")) {
            System.out.println("Spanish");
        } else {
            System.out.println("unknown");
        }

    }
}
/*Write a program, which prints the language, that a given country speaks. You can receive only the
following combinations: English is spoken in England and USA; Spanish is spoken in Spain, Argentina,
and Mexico; for the others, we should print "unknown".
Input
You will receive a single country name on a single line.
Output
Print the language, which the country speaks, or if it is unknown for your program, print "unknown".
*/