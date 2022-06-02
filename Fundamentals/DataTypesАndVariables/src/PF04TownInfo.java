import java.util.Scanner;

public class PF04TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfTown = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        double area = Double.parseDouble(scanner.nextLine());

        System.out.printf("Town %s has population of %d and area %.0f square km.",
                nameOfTown, population, area);
    }
}
/*You will be given 3 lines of input. On the first line you will be given the name of the town,
on the second – the population and on the third the area. Use the correct data types and print the
result in the following format:
"Town {town name} has population of {population} and area {area} square km.".
*/