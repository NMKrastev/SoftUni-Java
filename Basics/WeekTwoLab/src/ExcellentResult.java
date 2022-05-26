import java.util.Scanner;

public class ExcellentResult {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double evaluation = Double.parseDouble(scanner.nextLine());

        if (evaluation >= 5) {

            System.out.println("Excellent!");

        }/* else {

            System.out.println("Not excellent.");

        }*/
    }
}