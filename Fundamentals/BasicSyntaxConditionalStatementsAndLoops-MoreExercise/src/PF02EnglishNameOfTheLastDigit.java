import java.util.Scanner;

public class PF02EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nums[] = {"zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine"};

        int number = Integer.parseInt(scanner.nextLine());

        number = number % 10;

        switch (number) {
            case 0:
                System.out.println(nums[0]);
                break;
            case 1:
                System.out.println(nums[1]);
                break;
            case 2:
                System.out.println(nums[2]);
                break;
            case 3:
                System.out.println(nums[3]);
                break;
            case 4:
                System.out.println(nums[4]);
                break;
            case 5:
                System.out.println(nums[5]);
                break;
            case 6:
                System.out.println(nums[6]);
                break;
            case 7:
                System.out.println(nums[7]);
                break;
            case 8:
                System.out.println(nums[8]);
                break;
            case 9:
                System.out.println(nums[9]);
                break;
        }

    }
}
/*Write a method that returns the English name of the last digit of a given number. Write a program that
reads an integer and prints the returned value from this method.*/