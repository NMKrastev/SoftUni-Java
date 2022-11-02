import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class A2_Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> dataMap = new LinkedHashMap<>();
        String input;

        while (!(input = scanner.nextLine()).equals("no more time")) {
            String username = input.split("\\s+->\\s+")[0];
            String contest = input.split("\\s+->\\s+")[1];
            int points = Integer.parseInt(input.split("\\s+->\\s+")[2]);

            dataMap.putIfAbsent(contest, new LinkedHashMap<>());
            dataMap.get(contest).putIfAbsent(username, -1);
            if (dataMap.get(contest).get(username) < points) {
                dataMap.get(contest).put(username, points);
            }
        }

        printContestStandings(dataMap);

        Map<String, Integer> standings = new LinkedHashMap<>();
        standings = addIndividualStandings(dataMap, standings);

        printIndividualStandings(standings);
    }

    private static void printIndividualStandings(Map<String, Integer> standings) {

        AtomicInteger num = new AtomicInteger();

        System.out.println("Individual standings:");
        num.set(1);

        standings.entrySet().stream().sorted((e2, e1) -> {
            int sort = Integer.compare(e1.getValue(), e2.getValue());
            if (sort == 0) {
                sort = e2.getKey().compareTo(e1.getKey());
            }
            return sort;
        }).forEach(element -> System.out.printf("%d. %s -> %d\n", num.getAndIncrement(), element.getKey(), element.getValue()));
    }

    private static Map<String, Integer> addIndividualStandings(Map<String, LinkedHashMap<String, Integer>> dataMap, Map<String, Integer> standings) {

        for (Map.Entry<String, LinkedHashMap<String, Integer>> contestEntry : dataMap.entrySet()) {
            for (Map.Entry<String, Integer> valuesEntry : contestEntry.getValue().entrySet()) {
                standings.putIfAbsent(valuesEntry.getKey(), 0);
                standings.put(valuesEntry.getKey(), standings.get(valuesEntry.getKey()) + valuesEntry.getValue());
            }
        }
        return standings;
    }

    private static void printContestStandings(Map<String, LinkedHashMap<String, Integer>> dataMap) {

        AtomicInteger num = new AtomicInteger();
        dataMap.forEach((key, value) -> {
            num.set(1);
            System.out.printf("%s: %d participants\n", key, value.size());
            value.entrySet().stream().sorted((i2, i1) -> {
                int sort = Integer.compare(i1.getValue(), i2.getValue());
                if (sort == 0) {
                    sort = i2.getKey().compareTo(i1.getKey());
                }
                return sort;
            }).forEach(element -> System.out.printf("%d. %s <::> %d\n", num.getAndIncrement(), element.getKey(), element.getValue()));
        });
    }
}
/*You know the Judge system, right?! Your job is to create a program similar to the Judge system.
You will receive several input lines in the following format:
"{username} -> {contest} -> {points}"
The contestName and username are strings. The given points will be an integer number. You need to keep track of every
contest and individual statistics of every user. You should check if such a contest already exists, and if not, add it,
otherwise, check if the current user is participating in the contest.
If he is participating, take the higher score, otherwise, just add it.
Also, you need to keep individual statistics for each user - the total points of all contests.
You should end your program when you receive the command "no more time". At that point, you should print each contest
in order of input. For each contest, print the participants ordered by points in descending order and then by name in
ascending order. After that, you should print individual statistics for every participant ordered by total points in
descending order and then by alphabetical order.
Input / Constraints
•	The input comes in the form of commands in the format specified above.
•	Username and contest name always will be one word.
•	Points will be an integer in the range [0, 1000].
•	There will be no invalid input lines.
•	If all sorting criteria fail, the order should be by order of input.
•	The input ends when you receive the command "no more time".
Output
•	The output format for the contests is:
"{constestName}: {participants.Count} participants
{position}. {username} <::> {points}"
•	After you print all contests, print the individual statistics for every participant.
•	The output format is:
"Individual standings:
{position}. {username} -> {totalPoints}"
*/