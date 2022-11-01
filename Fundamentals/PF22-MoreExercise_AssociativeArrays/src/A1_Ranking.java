import java.util.*;
import java.util.stream.Collectors;

public class A1_Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestsMap = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> submissionsMap = new TreeMap<>();

        String input;

        while (!(input = scanner.nextLine()).equals("end of contests")) {

            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            contestsMap.putIfAbsent(contest, password);
        }

        while (!(input = scanner.nextLine()).equals("end of submissions")) {

            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String username = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);

            if (isContestExist(contestsMap, contest) && isPasswordValid(contestsMap, password)) {
                submissionsMap.putIfAbsent(username, new HashMap<>());
                submissionsMap.get(username).putIfAbsent(contest, points);
                if (isUserExist(submissionsMap, username, contest)) {
                    submissionsMap = checkForHigherPoints(submissionsMap, username, contest, points);
                }
            }
        }
        printBestCandidate(submissionsMap);
        printResults(submissionsMap);
    }

    private static void printResults(Map<String, Map<String, Integer>> submissionsMap) {

        System.out.println("Ranking:");
        for (Map.Entry<String, Map<String, Integer>> entryName : submissionsMap.entrySet()) {

            Map<String, Integer> valueSortedMap = entryName.getValue();
            valueSortedMap = sortByValue(valueSortedMap);
            System.out.printf("%s\n", entryName.getKey());
            for (Map.Entry<String, Integer> valueSortedMapEntry : valueSortedMap.entrySet()) {

                System.out.printf("#  %s -> %d\n", valueSortedMapEntry.getKey(), valueSortedMapEntry.getValue());
            }
        }
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> valueSortedMap) {

        Map<String, Integer> sortedMap =
                valueSortedMap.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        return sortedMap;
    }

    private static void printBestCandidate(Map<String, Map<String, Integer>> submissionsMap) {

        String bestCandidate = "";
        String currentCandidate = "";
        int currentSum = 0;
        int bestSum = Integer.MIN_VALUE;

        for (Map.Entry<String, Map<String, Integer>> candidate : submissionsMap.entrySet()) {
            currentCandidate = candidate.getKey();

            for (Map.Entry<String, Integer> getPoints : candidate.getValue().entrySet()) {
                currentSum += getPoints.getValue();
            }

            if (bestSum < currentSum) {
                bestSum = currentSum;
                bestCandidate = currentCandidate;
            }
            currentCandidate = "";
            currentSum = 0;
        }

        System.out.printf("Best candidate is %s with total %d points.\n", bestCandidate, bestSum);
    }

    private static Map<String, Map<String, Integer>> checkForHigherPoints(Map<String, Map<String, Integer>> submissionsMap, String username, String contest, int points) {

        for (Map.Entry<String, Map<String, Integer>> entryName : submissionsMap.entrySet()) {
            for (Map.Entry<String, Integer> valueEntry : entryName.getValue().entrySet()) {
                if (valueEntry.getValue() < points && entryName.getKey().equals(username) && valueEntry.getKey().equals(contest)) {
                    valueEntry.setValue(points);
                    break;
                }
            }

        }
        return submissionsMap;
    }

    private static boolean isUserExist(Map<String, Map<String, Integer>> submissionsMap, String username, String contest) {

        if (submissionsMap.get(username).containsKey(contest)) {
            return true;
        }
        return false;
    }

    private static boolean isContestExist(Map<String, String> contestsMap, String contest) {

        if (contestsMap.containsKey(contest)) {
            return true;
        }
        return false;
    }

    private static boolean isPasswordValid(Map<String, String> contestsMap, String password) {

        if (contestsMap.containsValue(password)) {
            return true;
        }
        return false;
    }
}
/*Here comes the final and the most interesting part - the Final ranking of the candidate interns.
The final ranking is determined by the points of the interview tasks and from the exams in SoftUni.
Here is your final task. You will receive some lines of input in the format "{contest}:{password for contest}"
until you receive "end of contests". Save that data because you will need it later. After that, you will receive
another type of input in the format "{contest}=>{password}=>{username}=>{points}" until you receive "end of submissions".
Here is what you need to do:
•	Check if the contest is valid (if you received it in the first type of input);
•	Check if the password is correct for the given contest;
•	Save the user with the contest they take part in (a user can take part in many contests) and
the points the user has in the given contest. If you receive the same contest and the same user, update the points only
if the new ones are more than the older ones.
In the end, you have to print the info for the user with the most points in the format "Best candidate is {user}
with total {total points} points.". After that, print all students ordered by their names. For each user, print each
contest with the points in descending order. See the examples.
Input:
•	Strings in format "{contest}:{password for contest}" until the "end of contests" command.
There will be no case with two equal contests.
•	Strings in format "{contest}=>{password}=>{username}=>{points}" until the "end of submissions" command.
•	There will be no case with 2 or more users with the same total points!
Output:
•	On the first line, print the best user in a format:
"Best candidate is {user} with total {total points} points.".
•	Then print all students ordered as mentioned above in format:
"{user1 name}
#  {contest1} -> {points}
#  {contest2} -> {points}"
Constraints:
•	The strings may contain any ASCII character except (:, =, >).
•	The numbers will be in the range [0 - 10000].
•	The second input is always valid.
*/