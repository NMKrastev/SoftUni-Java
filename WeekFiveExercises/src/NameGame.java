import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int maxScore = Integer.MIN_VALUE;
        String winnerName = "";
        String name = scanner.nextLine();


        while (!name.equals("Stop")) {
            int score = 0;
            for (int i = 0; i < name.length(); i++) {

                char symbol = name.charAt(i);
                int number = Integer.parseInt(scanner.nextLine());
                if (symbol == number) {
                    score += 10;
                } else {
                    score += 2;
                }

            }
            if (score >= maxScore) {
                maxScore = score;
                winnerName = name;
            }
            name = scanner.nextLine();
        }

        System.out.printf("The winner is %s with %d points!", winnerName, maxScore);
    }
}
