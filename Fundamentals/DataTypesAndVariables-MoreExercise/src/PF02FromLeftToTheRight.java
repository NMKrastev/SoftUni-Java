import java.util.Scanner;

public class PF02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String input = scanner.nextLine();
            StringBuilder sbLeft = new StringBuilder();
            StringBuilder sbRight = new StringBuilder();
            int count = 0;

            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                String character = Character.toString(ch);
                if (character.equals(" ")) {
                    count++;
                }
                if (count == 0) {
                    sbLeft.append(ch);
                } else if (count == 1) {
                    count++;
                } else {
                    sbRight.append(ch);
                }
            }

            long leftNum = Long.parseLong(String.valueOf(sbLeft));
            long rightNum = Long.parseLong(String.valueOf(sbRight));
            int sum = 0;

            if (leftNum >= rightNum) {
                leftNum = Math.abs(leftNum);
                while (leftNum > 0) {
                    sum += (leftNum % 10);
                    leftNum /= 10;
                }
            } else {
                rightNum = Math.abs(rightNum);
                while (rightNum > 0) {
                    sum += (rightNum % 10);
                    rightNum /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}

    //This solution is not recognized by Judge system but it works as the one above
        /*for (int i = 0; i <= num; i++) {
            double leftNum = Double.parseDouble(scanner.next());
            double rightNum = Double.parseDouble(scanner.next());

            int sum = 0;

            if (leftNum > rightNum) {
                leftNum = Math.abs(leftNum);
                while (leftNum > 0) {
                    sum += (leftNum % 10);
                    leftNum /= 10;
                }
            } else {
                rightNum = Math.abs(rightNum);
                while (rightNum > 0) {
                    sum += (rightNum % 10);
                    rightNum /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }*/

/*You will receive a number that represents how many lines we will get as input. On the next N lines, you will
receive a string with 2 numbers separated by a single space. You need to compare them. If the left number is
greater than the right number, you need to print the sum of all digits in the left number, otherwise, print
the sum of all digits in the right number.*/