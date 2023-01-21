import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A11_ThePartyReservationFilterModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command;

        while (!(command = scanner.nextLine()).equals("Print")) {
            String addOrRemove = command.split(";")[0];
            String type = command.split(";")[1];
            String parameter = command.split(";")[2];

            if (addOrRemove.equals("Add filter")) {
                filters.add(type + ";" + parameter);
            } else {
                filters.remove(type + ";" + parameter);
            }
        }

        filters.forEach(filter -> {
            Predicate<String> filterToApple = getPredicate(filter);
            guests.removeIf(filterToApple);
        });

        guests.forEach(name -> System.out.print(name + " "));
    }

    private static Predicate<String> getPredicate(String filter) {

        String filterType = filter.split(";")[0];
        String parameter = filter.split(";")[1];

        switch (filterType) {
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "Ends with":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            case "Contains":
                return s -> s.contains(parameter);
        }

        return null;
    }
}
/*You are a young and talented developer. The first task you need to do is to implement a filtering module to a
party reservation software. First, The Party Reservation Filter Module (TPRF Module for short) is passed a list with
invitations. Next, the TPRF receives a sequence of commands that specify if you need to add or remove a given filter.
TPRF Commands are in the given format "{command;filter type;filter parameter}".
You can receive the following TPRF commands: "Add filter", "Remove filter" or "Print".
The possible TPRF filter types are: "Starts with", "Ends with", "Length", and "Contains".
All TPRF filter parameters will be a string (or an integer for the length filter).
The input will end with a "Print" command. See the examples below:
*/
