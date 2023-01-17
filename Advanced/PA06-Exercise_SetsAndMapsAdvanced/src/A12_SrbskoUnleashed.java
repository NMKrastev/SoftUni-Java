import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class A12_SrbskoUnleashed {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^(?<name>[\\w\\s]+?)\\s+@(?<venue>[\\w\\s]+?)\\s(?<price>\\d+)\\s(?<tickets>\\d+)");
        Map<String, Map<String, Integer>> srbskoInfoMap  = new LinkedHashMap<>();
        String input;
        while(!(input = scanner.nextLine()).equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                String venue = matcher.group("venue");
                int price = Integer.parseInt(matcher.group("price"));
                int earnings = price * Integer.parseInt(matcher.group("tickets"));
                srbskoInfoMap.putIfAbsent(venue, new LinkedHashMap<>());
                srbskoInfoMap.get(venue).putIfAbsent(name, 0);
                srbskoInfoMap.get(venue).put(name, srbskoInfoMap.get(venue).get(name) + earnings);
            }
        }

        srbskoInfoMap.forEach((venue, singer) -> {
            System.out.printf("%s\n", venue);
            singer = singer.entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            singer.forEach((name, earnings) ->
                System.out.printf("#  %s -> %d\n", name, earnings));
        });
    }
}
/*Admit it – the СРЪБСКО is your favorite sort of music. You never miss a concert, and you have become quite the geek
concerning everything involved with СРЪБСКО. You can't decide between all the singers you know who your favorite one is.
One way to find out is to keep a statistic of how much money their concerts make. Write a program that does all the
boring calculations for you.
On each input line you’ll be given data in format: "{singer} @{venue} {ticketsPrice} {ticketsCount}". There will be no
redundant whitespaces anywhere in the input. Aggregate the data by venue and by the singer. For each venue, print the
singer and the total amount of money his/her concerts have made on a separate line. Venues should be kept in the same
order they were entered, the singers should be sorted by how much money they have made in descending order.
If two singers have made the same amount of money, keep them in the order in which they were entered.
Keep in mind that if a line is in incorrect format, it should be skipped, and its data should not be added to the output.
Each of the four tokens must be separated by a space, everything else is invalid. The venue should be denoted
with @ in front of it, such as @Sunny Beach
SKIP THOSE: Ceca@Belgrade125 12378, Ceca @Belgrade12312 123
The singer and town name may consist of one to three words.
Input
•	The input data should be read from the console.
•	It consists of a variable number of lines and ends when the command "End" is received.
•	The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
•	The output should be printed on the console.
•	Print the aggregated data for each venue and singer in the below format.
•	Format for singer lines is "# {singer} -> {total money}".
Constraints
•	The number of input lines will be in the range [2 … 50].
•	The ticket price will be an integer in the range [0 … 200].
•	The ticket count will be an integer in the range [0 … 100 000]
•	Singers and venues are case-sensitive.
•	Allowed time:  100ms/16 MB.
*/
