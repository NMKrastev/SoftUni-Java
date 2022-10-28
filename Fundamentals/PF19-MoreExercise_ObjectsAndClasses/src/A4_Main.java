import java.util.*;

public class A4_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A4_Team> teamsList = new ArrayList<>();
        int numOfTeams = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfTeams; i++) {

            String[] input = scanner.nextLine().split("-".trim());

            if (isTeamExist(teamsList, input[1])) {
                System.out.printf("Team %s was already created!\n", input[1]);
            } else if (!isTeamExist(teamsList, input[1]) && isCreatorSame(teamsList, input[0])) {
                System.out.printf("%s cannot create another team!\n", input[0]);
            } else if (!isTeamExist(teamsList, input[1]) && !isCreatorSame(teamsList, input[0])) {
                A4_Team team = new A4_Team();
                team.setCreator(input[0]);
                team.setTeam(input[1]);
                teamsList.add(team);
                System.out.printf("Team %s has been created by %s!\n", input[1], input[0]);
            }
        }

        String input;

        while (!(input = scanner.nextLine()).equals("end of assignment")) {

            String[] command = input.split("->".trim());

            for (A4_Team team : teamsList) {
                if (!isTeamExist(teamsList, command[1])) {
                    System.out.printf("Team %s does not exist!\n", command[1]);
                    break;
                } else if (isTeamExist(teamsList, command[1]) && ((isMemberExist(teamsList, command[0])) || isCreatorSame(teamsList, command[0]))) {
                    System.out.printf("Member %s cannot join team %s!\n", command[0], command[1]);
                    break;
                } else if (isTeamExist(teamsList, command[1]) && !isMemberExist(teamsList, command[0])) {
                    for (A4_Team teams : teamsList) {
                        if (teams.getTeam().contains(command[1])) {
                            teams.addMember(command[0]);
                            break;
                        }
                    }
                    break;
                }
            }
        }

        teamsList.sort(Comparator.comparingInt(A4_Team::getNumberOfMembers).reversed().thenComparing(A4_Team::getTeam));

        printResult(teamsList);
    }

    private static void printResult(List<A4_Team> teamsList) {
        for (A4_Team currentTeam : teamsList) {
            Collections.sort(currentTeam.getMembers());
            if (!currentTeam.getMembers().isEmpty()) {
                System.out.println(currentTeam.getTeam());
                System.out.printf("- %s\n", currentTeam.getCreator());
                for (String member : currentTeam.getMembers()) {
                    System.out.printf("-- %s\n", member);
                }
            }
        }

        System.out.println("Teams to disband:");
        for (A4_Team disbandTeam : teamsList) {
            if (disbandTeam.getMembers().isEmpty()) {
                System.out.println(disbandTeam.getTeam());
            }
        }
    }

    private static boolean isMemberExist(List<A4_Team> teamsList, String member) {

        for (A4_Team members : teamsList) {
            if (members.getMembers().contains(member)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCreatorSame(List<A4_Team> teamsList, String teamCreator) {

        for (A4_Team creator : teamsList) {
            if (creator.getCreator().contains(teamCreator)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isTeamExist(List<A4_Team> teamsList, String teamToJoin) {
        for (A4_Team team : teamsList) {
            if (team.getTeam().contains(teamToJoin)) {
                return true;
            }
        }
        return false;
    }
}
/*It's time for teamwork projects, and you are responsible for making the teams. First, you will receive an integer -
the count of the teams you will have to register. You will be given a user and a team (separated with "-").
The user is the creator of that team.
For every newly created team, you should print a message:
"Team {team Name} has been created by {user}!"
Next, you will receive a user with the team (separated with "->") which means that the user wants to join that team.
Upon receiving the command: "end of assignment", you should print every team, ordered by the count of its members
(descending) and then by name (ascending). For each team (disband teams as well), you have to print its members
sorted by name (ascending). However, there are several rules:
•	If a user tries to create a team more than once, a message should be displayed:
"Team {teamName} was already created!"
•	The creator of a team cannot create another team - the message should be thrown:
"{user} cannot create another team!"
•	If a user tries to join a currently non-existing team, a message should be displayed:
"Team {teamName} does not exist!"
•	A Member of a team cannot join another team - the message should be thrown:
"Member {user} cannot join team {team Name}!"
•	At the end (after teams' report), teams with zero members (with only a creator) should disband, ordered by name in ascending other.
•	 Every valid team should be printed ordered by name (ascending) in this format:
"{teamName}:
 - {create}
 -- {member}..."
*/