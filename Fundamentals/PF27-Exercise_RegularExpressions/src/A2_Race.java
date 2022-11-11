import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A2_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> participantsMap = new LinkedHashMap<>();
        String nameRegex = "[a-zA-Z]+";
        String distanceRegex = "[0-9]";
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern distancePattern = Pattern.compile(distanceRegex);
        int totalDistance = 0;
        String input;
        String[] participants = scanner.nextLine().split(",\\s+");

        for (String participant : participants) {
            participantsMap.put(participant, totalDistance);
        }

        while (!(input = scanner.nextLine()).equals("end of race")) {

            Matcher nameMatcher = namePattern.matcher(input);
            Matcher distanceMatcher = distancePattern.matcher(input);

            String name = getName(nameMatcher);
            int currentDistance = 0;
            currentDistance = getCurrentDistance(distanceMatcher, currentDistance);

            if (participantsMap.containsKey(name)) {
                totalDistance = participantsMap.get(name);
                totalDistance += currentDistance;
                participantsMap.put(name, totalDistance);
            }
        }

        participantsMap = participantsMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        printResults(participantsMap);
    }

    private static void printResults(Map<String, Integer> participantsMap) {

        int i = 0;
        for (Map.Entry<String, Integer> entry : participantsMap.entrySet()) {
            if (i == 0) {
                System.out.printf("1st place: %s\n", entry.getKey());
            }
            if (i == 1) {
                System.out.printf("2nd place: %s\n", entry.getKey());
            }
            if (i == 2) {
                System.out.printf("3rd place: %s\n", entry.getKey());
            }
            if (i == 2) {
                break;
            }
            i++;
        }
    }

    private static int getCurrentDistance(Matcher distanceMatcher, int currentDistance) {

        while (distanceMatcher.find()) {
            currentDistance += Integer.parseInt(distanceMatcher.group());
        }
        return currentDistance;
    }

    private static String getName(Matcher nameMatcher) {

        StringBuilder sb = new StringBuilder();
        while (nameMatcher.find()) {
            sb.append(nameMatcher.group());
        }
        return sb.toString();
    }
}
/*Write a program that processes information about a race. On the first line, you will be given a list of participants
separated by ", ". On the next few lines, until you receive the line "end of race" you will be given some info which
will be some alphanumeric characters. In between them, you could have some extra characters which you should ignore.
For example: "G!32e%o7r#32g$235@!2e". The letters are the name of the person, and the sum of the digits is the distance
he ran. So here we have George, who ran 29 km. Store the information about the person only if the list of racers
contains the name of the person. If you receive the same person more than once add the distance to his old distance.
In the end, print the top 3 racers in the format:
"1st place: {first racer}
2nd place: {second racer}
3rd place: {third racer}"*/