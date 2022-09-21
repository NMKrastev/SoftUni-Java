import java.util.Scanner;

public class A5_ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOne = scanner.nextLine();
        String nameTwo = scanner.nextLine();
        String delimiter = scanner.nextLine();

        System.out.printf("%s%s%s", nameOne, delimiter, nameTwo);

    }
}
/*Read two names and a delimiter. Print the names joined by the delimiter.*/