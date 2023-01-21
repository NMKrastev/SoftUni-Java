import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A10_PredicateParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command;
        while (!(command = scanner.nextLine()).equals("Party!")) {
            filters.add(command);
        }

        filters.forEach(filter -> {
            String commandType = filter.split("\\s+")[0];
            Predicate<String> filterToApply = getPredicate(filter);
            switch (commandType) {
                case "Remove":
                    guests.removeIf(filterToApply);
                    break;
                case "Double":
                    guests.addAll(guests.stream().filter(filterToApply).collect(Collectors.toList()));
                    break;
            }
        });

        Collections.sort(guests);
        System.out.println(guests.isEmpty() ? "Nobody is going to the party!" :
                String.format("%s are going to the party!", String.join(", ", guests)));
    }

    private static Predicate<String> getPredicate(String filter) {

        String filterType = filter.split("\\s+")[1];
        String parameter = filter.split("\\s+")[2];

        switch (filterType) {
            case "StartsWith":
                return s -> s.startsWith(parameter);
            case "EndsWith":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            default:
            throw new IllegalArgumentException("Unknown condition " + filter);
        }
    }
}
/*The Wire's parents are on vacation for the holidays, and he is planning an epic party at home. Unfortunately,
his organizational skills are next to non-existent, so you are given the task of helping him with the reservations.
On the first line, you get a list of all the people that are coming. On the next lines, until you get the "Party!"
command, you may be asked to double or remove all the people that apply to the given criteria.
There are three different options:
•	Everyone that has a name starts with a given string.
•	Everyone that has a name ending with a given string.
•	Everyone has a name with a given length.
When you print the guests that are coming to the party, you have to print them in ascending order. If nobody is going,
print "Nobody is going to the party!". See the examples below:
*/
