import java.util.*;

public class A2_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipSet = new TreeSet<>();
        Set<String> regularSet = new TreeSet<>();

        String input;
        while (!(input = scanner.nextLine()).equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vipSet.add(input);
            } else {
                regularSet.add(input);
            }
        }

        while (!(input = scanner.nextLine()).equals("END")) {
            if (Character.isDigit(input.charAt(0))) {
                vipSet.remove(input);
            } else {
                regularSet.remove(input);
            }
        }

        System.out.println(vipSet.size() + regularSet.size());
        if (!vipSet.isEmpty()) {
            vipSet.forEach(System.out::println);
        }
        if (!regularSet.isEmpty()) {
            regularSet.forEach(System.out::println);
        }
    }
}
/*There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular.
When a guest comes, you have to check if he/she exists on any of the two reservation lists.
All reservation numbers will be with 8 chars. All VIP numbers start with a digit.
There will be 2 command lines:
•	First is "PARTY" - the party is on, and guests are coming.
•	The second is "END" - then the party is over, and no more guests will come.
The output shows all guests who didn't come to the party (VIP must be first).
*/
