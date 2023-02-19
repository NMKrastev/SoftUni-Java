package A5_JediGalaxy;

import java.util.Scanner;

public class Engine {

    private Scanner scanner;
    private Evil evil;
    private Jedi jedi;
    private String command;

    public Engine(Scanner scanner, Evil evil, Jedi jedi) {
        this.scanner = scanner;
        this.evil = evil;
        this.jedi = jedi;
        this.command = "";
    }

    public void run() {
        command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {

            int[] jediPosition = InputParser.parseIntegerArray(command);

            int[] evilPosition = InputParser.parseIntegerArray(scanner.nextLine());

            int enemyRow = evilPosition[0];
            int enemyCol = evilPosition[1];

            evil.destroyStars(enemyRow, enemyCol);

            int playerRow = jediPosition[0];
            int playerCol = jediPosition[1];

            this.jedi.collectStars(playerRow, playerCol);

            this.command = scanner.nextLine();
        }
    }
}
