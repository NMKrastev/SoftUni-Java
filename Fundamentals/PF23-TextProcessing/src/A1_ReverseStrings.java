import java.util.Scanner;

public class A1_ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            StringBuilder sb = new StringBuilder();
            sb.append(line);

            System.out.printf("%s = %s\n", line, sb.reverse().toString());
        }
    }
}
/*You will be given a series of strings until you receive an "end" command.
Write a program that reverses strings and prints each pair on a separate line in the format "{word} = {reversed word}".*/