import java.util.*;

public class A10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<Integer>>> submissionInfoMap = new LinkedHashMap<>();
        Map<String, List<Integer>> countSubmissionsMap = new LinkedHashMap<>();

        String line;

        while (!(line = scanner.nextLine()).equals("exam finished")) {

            String[] command;
            if (!line.contains("banned")) {

                command = line.split("-");
                String username = command[0];
                String language = command[1];
                int points = Integer.parseInt(command[2]);

                submissionInfoMap.putIfAbsent(username, new HashMap<>());
                submissionInfoMap.get(username).putIfAbsent(language, new ArrayList<>());
                submissionInfoMap.get(username).get(language).add(points);
                countSubmissionsMap.putIfAbsent(language, new ArrayList<>());
                countSubmissionsMap.get(language).add(points);
            } else {

                command = line.split("-");
                String oldUsername = command[0];
                String newUsername = command[1];
                submissionInfoMap.put(oldUsername, submissionInfoMap.put(newUsername, submissionInfoMap.get(oldUsername)));
                submissionInfoMap.remove(oldUsername);
            }
        }

        printResults(submissionInfoMap);
        printSubmissions(submissionInfoMap, countSubmissionsMap);
    }

    private static void printSubmissions(Map<String, Map<String, List<Integer>>> submissionInfoMap, Map<String, List<Integer>> countSubmissionsMap) {

        System.out.println("Submissions:");
        for (Map.Entry<String, List<Integer>> submission : countSubmissionsMap.entrySet()) {
            System.out.printf("%s - %d\n", submission.getKey(), submission.getValue().size());
        }
    }

    private static void printResults(Map<String, Map<String, List<Integer>>> submissionInfoMap) {

        System.out.println("Results:");
        for (Map.Entry<String, Map<String, List<Integer>>> entry : submissionInfoMap.entrySet()) {
            if (!entry.getKey().contains("banned")) {
                for (Map.Entry<String, List<Integer>> languageEntry : submissionInfoMap.get(entry.getKey()).entrySet()) {
                    int max = Integer.MIN_VALUE;
                    for (int i = 0; i < languageEntry.getValue().size(); i++) {
                        if (languageEntry.getValue().get(i) > max) {
                            max = languageEntry.getValue().get(i);
                        }
                    }
                    System.out.printf("%s | %d\n", entry.getKey(), max);
                }
            }
        }
    }
}
/*Judge statistics on the last Programming Fundamentals exam were not working correctly, so you have the task to
take all the submissions and analyze them properly. You should collect all the submissions and print the final
results and statistics about each language in which the participants submitted their solutions.
You will be receiving lines in the following format: "{username}-{language}-{points}" until you receive "exam finished".
You should store each username and their submissions and points.
You can receive a command to ban a user for cheating in the following format: "{username}-banned". In that case, you
should remove the user from the contest but preserve his submissions in the total count of submissions for each language.
After receiving "exam finished", print each of the participants in the following format:
"Results:
{username} | {points}
{username2} | {points}
…
{usernameN} | {points}"
After that, print each language used in the exam in the following format:
"Submissions:
{language1} - {submissions_count}
{language2} - {submissions_count}
…
{language3} - {submissions_count}"
Input / Constraints
Until you receive "exam finished", you will be receiving participant submissions in the following format:
"{username}-{language}-{points}"
You can receive a ban command -> "{username}-banned".
The participant's points will always be a valid integer in the range [0-100].
Output
•	Print the exam results for each participant.
•	After that, print each language in the format shown above.
*/