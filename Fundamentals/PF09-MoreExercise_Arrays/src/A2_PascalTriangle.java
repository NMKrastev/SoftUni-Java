import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A2_PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        //int[][] pascalTriangle = new int[num][num];

        for (int i = 0; i < num; i++) {

            int number = 1;

            for (int j = 0; j <= i ; j++) {

                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);

            }

            System.out.println();

        }

/*        for (int i = 0; i < num; i++) {

            for (int j = 0; j <= i; j++) {

                if (i == j || j == 0) {

                    pascalTriangle[i][j] = 1;

                } else {

                    pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];

                }

                System.out.print(pascalTriangle[i][j] + " ");

            }

            System.out.println();

        }*/
    }
}
/*The triangle may be constructed in the following manner: In row 0 (the topmost row),
there is a unique nonzero entry 1. Each entry of each subsequent row is constructed
by adding the number above and to the left with the number above and to the right,
treating blank entries as 0. For example, the initial number in the first (or any other)
row is 1 (the sum of 0 and 1), whereas the numbers 1 and 3 in the third row are added to
produce the number 4 in the fourth row.
Print each row element, separated with whitespace.*/