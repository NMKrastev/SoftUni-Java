import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class A3_PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalsSet = new TreeSet<>();
        String input;
        for (int i = 0; i < num; i++) {
            input = scanner.nextLine();
            chemicalsSet.addAll(Arrays.asList(input.split("\\s+")));
        }

        chemicalsSet.forEach(element -> System.out.print(element + " "));
    }
}
/*You are given an n number of chemical compounds. You need to keep track of all chemical
elements used in the compounds and at the end, print all unique ones in ascending order:*/
