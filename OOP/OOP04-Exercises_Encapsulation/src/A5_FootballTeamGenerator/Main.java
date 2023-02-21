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
/*A football team has a variable number of players, a name, and a rating.
Team:
-	name: String
-	players: List<Player>
+ 	Team (String)
-	setName(String) : void
+	getName(): String
+	addPlayer(Player) : void
+	removePlayer(String) : void
+	getRating() : double
A player has a name and stats which are the basis for his skill level.
The stats a player has are endurance, sprint, dribble, passing, and shooting. Each stat can be in the range [0..100].
The overall skill level of a player is calculated as the average of his stats.
Only the name of a player and his stats should be visible to all of the outside world. Everything else should be hidden.
Player:
-	name: String
-	endurance:  int
-	sprint:  int
-	dribble: int
-	passing: int
-	shooting: int
+ 	Player (String, int, int, int, int, int)
-	setName(String) : void
+	getName(): String
-	setEndurance (int) : void
-	setSprint (int) : void
-	setDribble (int) : void
-	setPassing (int) : void
-	setShooting (int) : void
+	overallSkillLevel() : double
A team should expose a name, a rating (calculated by the average skill level of all players in the team),
and methods for adding and removing players.
Your task is to model the team and the players following the proper principles of Encapsulation.
Expose only the fields that need to be visible and validate data appropriately.
Input
Your application will receive commands until the "END" command is given. The command can be one of the following:
•	"Team;{TeamName}" – add a new team
•	"Add;{TeamName};{PlayerName};{Endurance};{Sprint};{Dribble};{Passing};{Shooting}" – add a new player to the team
•	"Remove;{TeamName};{PlayerName}" – remove the player from the team
•	"Rating;{TeamName}" – print the team rating, rounded to the closest integer
Data Validation
•	A name cannot be null, empty, or white space. If not, print: "A name should not be empty."
•	Stats should be in the range [0..100]. If not, print: "{Stat name} should be between 0 and 100."
•	If you receive a command to remove a missing player, print: "Player {Player name} is not in {Team name} team."
•	If you receive a command to add a player to a missing team, print: "Team {team name} does not exist."
•	If you receive a command to show stats for a missing team, print: "Team {team name} does not exist."
*/