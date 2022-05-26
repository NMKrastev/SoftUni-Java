import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int current = 1;
        boolean isBigger = false;

        for (int rows = 1; rows <= num; rows++) {
            for (int cols = 1; cols <= rows; cols++) {

                if (current > num) {
                    isBigger = true;
                    break;
                }
                System.out.print(current + " ");
                current++;
            }
            if (isBigger) {
                break;
            }
            System.out.println();
        }
    }
}
/*Напишете програма, която чете цяло число n, въведено от потребителя, и отпечатва пирамида от числа като в примерите:
вход	                            изход
7	                                1
                                    2 3
                                    4 5 6
                                    7

10                                  1
                                    2 3
                                    4 5 6
                                    7 8 9 10

12	                                1
                                    2 3
                                    4 5 6
                                    7 8 9 10
                                    11 12

15	                                1
                                    2 3
                                    4 5 6
                                    7 8 9 10
                                    11 12 13 14 15
*/