package A5_FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new LinkedHashMap<>();

        String line;
        while (!(line = scanner.nextLine()).equals("END")) {

            String[] commands = line.split(";");
            String commandType = commands[0];
            String teamName = commands[1];

            switch (commandType) {

                case "Team":

                    try {
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Add":

                    String playerName = commands[2];

                    int endurance = Integer.parseInt(commands[3]);
                    int sprint = Integer.parseInt(commands[4]);
                    int dribble = Integer.parseInt(commands[5]);
                    int passing = Integer.parseInt(commands[6]);
                    int shooting = Integer.parseInt(commands[7]);

                    if (!teams.containsKey(teamName)) {
                        teamDoesNotExist(teamName);
                    } else {
                        try {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teams.get(teamName).addPlayer(player);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case "Remove":

                    String playerToRemove = commands[2];

                    try {
                        teams.get(teamName).removePlayer(playerToRemove);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Rating":

                    if (!teams.containsKey(teamName)) {
                        teamDoesNotExist(teamName);
                    } else {
                        System.out.printf("%s - %d\n", teamName, Math.round(teams.get(teamName).getRating()));
                    }
                    break;
            }
        }
    }

    private static void teamDoesNotExist(String teamName) {
        System.out.printf("Team %s does not exist.\n", teamName);
    }
}
