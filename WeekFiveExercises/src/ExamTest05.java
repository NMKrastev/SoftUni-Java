import java.util.Scanner;

public class ExamTest05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int hearthstoneCount = 0, forniteCount = 0, overwatchCount = 0, othersCount = 0;
        double heartstone = 0, fortnite = 0, overwatch = 0, others = 0;

        for (int i = 0; i < number; i++) {

            String game = scanner.nextLine().toLowerCase();

            if (game.equals("hearthstone")) {
                hearthstoneCount++;
                heartstone = ((double)hearthstoneCount) / number * 100;
            } else if (game.equals("fornite")) {
                forniteCount++;
                fortnite = ((double)forniteCount) / number * 100;
            } else if (game.equals("overwatch")) {
                overwatchCount++;
                overwatch = ((double)overwatchCount) / number * 100;
            } else {
                othersCount++;
                others = ((double)othersCount) / number * 100;
            }

        }

        System.out.printf("Hearthstone - %.2f%%\nFornite - %.2f%%\nOverwatch - %.2f%%\nOthers - %.2f%%\n",
                heartstone, fortnite, overwatch, others);

    }
}
