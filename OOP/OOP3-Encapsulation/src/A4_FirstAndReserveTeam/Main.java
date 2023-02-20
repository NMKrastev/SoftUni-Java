package A4_FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Team team = new Team("Black Eagles");

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");

            Person person = new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));

            team.addPlayer(person);
        }

        System.out.printf("First team have %d players\n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players\n", team.getReserveTeam().size());
    }
}
/*Create a Team class. Add to this team all people you read. All people younger than 40 go on the first team,
others go on the reverse team. At the end print first and reserve team sizes.
The class should have private fields for:
•	name: String
•	firstTeam: List<Person>
•	reserveTeam: List<Person>
The class should have constructors:
•	Team(String name)
The class should also have private method for setName and public methods for:
•	getName(): String
•	addPlayer(Person person): void
•	getFirstTeam(): List<Person> (Collections.unmodifiableList)
•	getReserveTeam(): List<Person> (Collections.unmodifiableList)
*/