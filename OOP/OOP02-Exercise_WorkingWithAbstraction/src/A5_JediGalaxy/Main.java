package A5_JediGalaxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = InputParser.parseIntegerArray(scanner.nextLine());

        int rows = dimensions[0];
        int cols = dimensions[1];

        Galaxy galaxy = new Galaxy(new Field(new int[rows][cols]));

        Evil evil = new Evil(galaxy);
        Jedi jedi = new Jedi(galaxy);
        Engine engine = new Engine(scanner, evil, jedi);
        engine.run();

        System.out.println(jedi.getPoints());
    }
}
/*Ivo is Jedi and so he starts gathering stars to grow stronger.
His galaxy is represented as a two-dimensional array. Every cell in the matrix is a star that has a value.
Peter starts at the given col and row. He can move only on the diagonal from the lowest left to the upper right
and adds to his score all the stars (values) from the cells he passes through. Unfortunately,
there is always an Evil power that tries to prevent his success.
Evil power starts at the given row and col and instantly destroys all-stars on the opposite diagonal –
From the lowest right to the upper left.
Peter adds the values only of the stars that are not destroyed by the evil power.
You will receive two integers, separated by space, which represent the two-dimensional array -
the first being the rows and the second being the columns. Then, you must fill the two-dimensional array
with increasing integers starting from 0, and continuing on every row, like this:
first row: 0, 1, 2… m
second row: n+1, n+2, n+3… n + n.
Example:
Peter starts with coordinates row = 5, col = -1. He must collect all stars with value [20, 16, 12, 8, 4].
Evil starts with coordinates row = 5, col = 5. Evil destroys all-stars in the range [24, 18, 12, 6, 0].
The star with a value of 12 is the cross point for Peter and The Evil, so Peter skips the stars
and collects only those who are not in the evil range.
You will also receive multiple pairs of commands in the form of 2 integers separated by a single space.
The first two integers will represent Peter’s start coordinates.
The second one will represent the Evil Power’s start coordinates.
The input ends when you receive the command "Let the Force be with you". When that happens, you must print the value
of all-stars that Peter has collected successfully.
Input
•	On the first line, you will receive the number N, M -> the dimensions of the matrix.
You must then fill the matrix according to these dimensions.
•	On the next several lines you will begin receiving 2 integers separated by a single space,
which represent Peter’s row and col. On the next line, you will receive the Evil Power’s coordinates.
•	There will always be at least 2 lines of input to represent at least 1 path of Peter and the Evil force.
•	When you receive the command, "Let the Force be with you" the input ends.
Output
•	The output is simple. Print the sum of the values from all-stars that Peter has collected.
Constraints
•	The dimensions of the matrix will be integers in the range [5, 2000].
•	The given rows will be valid integers in the range [0, 2000].
•	The given columns will be valid integers in the range [-231 + 1, 231 - 1].
INITIAL CODE:
package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = dimestions[0];
            int y = dimestions[1];

            int[][] matrix = new int[x][y];

            int value = 0;
            for (int i = 0; i < x; i++)
            {
                for (int j = 0; j < y; j++)
                {
                    matrix[i][j] = value++;
                }
            }

            String command = scanner.nextLine();
            long sum = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int xE = evil[0];
                int yE = evil[1];

                while (xE >= 0 && yE >= 0)
                {
                    if (xE >= 0 && xE < matrix.length && yE >= 0 && yE < matrix[0].length)
                    {
                        matrix[xE] [yE] = 0;
                    }
                    xE--;
                    yE--;
                }

                int xI = ivoS[0];
                int yI = ivoS[1];

                while (xI >= 0 && yI < matrix[1].length)
                {
                    if (xI >= 0 && xI < matrix.length && yI >= 0 && yI < matrix[0].length)
                    {
                        sum += matrix[xI][yI];
                    }

                    yI++;
                    xI--;
                }

                command = scanner.nextLine();
            }

        System.out.println(sum);


    }
}
*/