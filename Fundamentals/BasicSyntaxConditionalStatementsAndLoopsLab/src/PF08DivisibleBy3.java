import java.util.Scanner;

public class PF08DivisibleBy3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 3; i <= 100 ; i += 3) {
            System.out.println(i);
        }
    }
}
/*Write a program, which prints all the numbers from 1 to 100, which are divisible by 3.
You have to use a single for loop. The program should not receive input.*/