import java.util.*;

public class A10_LogsAggregator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> userIPInfoMap = new TreeMap<>();
        Map<String, Integer> userDurationInfoMap = new TreeMap<>();
        int num = Integer.parseInt(scanner.nextLine());
        String input;
        for (int i = 0; i < num; i++) {
            input = scanner.nextLine();

            userIPInfoMap.putIfAbsent(input.split("\\s+")[1], new TreeSet<>());
            userIPInfoMap.get(input.split("\\s+")[1]).add(input.split("\\s+")[0]);
            userDurationInfoMap.putIfAbsent(input.split("\\s+")[1], 0);
            userDurationInfoMap.put(input.split("\\s+")[1], userDurationInfoMap.get(input.split("\\s+")[1]) + Integer.parseInt(input.split("\\s+")[2]));
        }

        userDurationInfoMap.forEach((currentUser, totalDuration) -> {
            System.out.printf("%s: %d [%s]\n", currentUser, totalDuration,
                    String.join(", ", userIPInfoMap.get(currentUser)));
        });
    }
}
/*You are given a sequence of access logs in format "{IP} {user} {duration}". For example:
•	192.168.0.11 peter 33
•	10.10.17.33 alex 12
•	10.10.17.35 peter 30
•	10.10.17.34 peter 120
•	10.10.17.34 peter 120
•	212.50.118.81 alex 46
•	212.50.118.81 alex 4
Write a program to aggregate the logs data and print for each user the total duration of his sessions and a list of
unique IP addresses in the format "{user}: {duration} [IP1, IP2, ...]". Order the users alphabetically.
Order the IPs alphabetically. In our example, the output should be the following:
•	alex: 62 [10.10.17.33, 212.50.118.81]
•	peter: 303 [10.10.17.34, 10.10.17.35, 192.168.0.11]
Input
The input comes from the console. At the first line, a number n stays, which says how many log lines will follow.
Each of the next n lines holds a log information in format "{IP} {user} {duration}".
The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
Print one line for each user (order users alphabetically). For each user print its sum of durations and all of his
sessions' IPs, ordered alphabetically in format "{user}: {duration} [{IP1}, {IP2}, ...]".
Remove any duplicated values in the IP addresses and order them alphabetically (like we order strings).
Constraints
•	The count of the order lines n is in the range [1…1000].
•	The {IP} is a standard IP address in format a.b.c.d where a, b, c, and d are integers in the range [0…255].
•	The {user} consists of only of Latin characters, with a length of [1…20].
•	The {duration} is an integer number in the range [1…1000].
•	Time limit: 300ms/16 MB
*/
