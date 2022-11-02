import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A4_SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> dwarfInfoMap = new LinkedHashMap<>();
        String input;

        while (!(input = scanner.nextLine()).equals("Once upon a time")) {

            String name = input.split("\\s+<:>\\s+")[0];
            String hatColor = input.split("\\s+<:>\\s+")[1];
            int physics = Integer.parseInt(input.split("\\s+<:>\\s+")[2]);

            dwarfInfoMap.putIfAbsent(hatColor, new LinkedHashMap<>());
            dwarfInfoMap.get(hatColor).putIfAbsent(name, -1);

            if (dwarfInfoMap.get(hatColor).get(name) < physics) {
                dwarfInfoMap.get(hatColor).put(name, physics);
            }
        }

        printResult(dwarfInfoMap);
    }

    private static void printResult(LinkedHashMap<String, LinkedHashMap<String, Integer>> dwarfInfoMap) {

        Map<String, Integer> dwarfsToPrint = new LinkedHashMap<>();

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : dwarfInfoMap.entrySet()) {
            for (Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                dwarfsToPrint.put(entry.getKey() + " " + subEntry.getKey() + " " + entry.getValue().size(), subEntry.getValue());
            }
        }

        dwarfsToPrint.entrySet().stream().sorted((dwarfTwo, dwarfOne) -> {
            int sort = Integer.compare(dwarfOne.getValue(), dwarfTwo.getValue());
            if (sort == 0) {
                String[] sort1 = dwarfOne.getKey().split(" ");
                String[] sort2 = dwarfTwo.getKey().split(" ");
                sort = sort1[2].compareTo(sort2[2]);
            }
            return sort;
        }).forEach(pair -> {
            String[] printing = pair.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d\n", printing[0], printing[1], pair.getValue());
        });
    }
}
/*Snow White loves her dwarfs, but there are so many, and she doesn't know how to order them.
Does she order them by name? Or by the color of their hat? Or by physics? She can't decide, so it's up to you to
write a program that does it for her.
You will be receiving several input lines which contain data about dwarfs in the following format:
"{dwarfName} <:> {dwarfHatColor} <:> {dwarfPhysics}"
The dwarfName and the dwarfHatColor are strings. The dwarfPhysics is an integer.
You must store the dwarfs in your program. There are several rules, though:
•	If 2 dwarfs have the same name but different hat colors, they should be considered different dwarfs,
and you should store both of them.
•	If 2 dwarfs have the same name and the same hat color, store the one with the higher physics.
When you receive the command "Once upon a time", the input ends. You must order the dwarfs by physics in
descending order and then by the total count of dwarfs with the same hat color in descending order.
Then you must print them all.
Input
•	The input will consist of several input lines containing dwarf data in the format specified above.
•	The input ends when you receive the command "Once upon a time".
Output
•	As output, you must print the dwarfs ordered as specified above.
•	The output format is: "({hatColor}) {name} <-> {physics}".
Constraints
•	The dwarfName will be a string that may contain any ASCII character except ' ' (space), '<', ':', '>'.
•	The dwarfHatColor will be a string which may contain any ASCII character except ' ' (space), '<', ':', '>'.
•	The dwarfPhysics will be an integer in the range [0, 231 - 1].
•	There will be no invalid input lines.
•	If all sorting criteria fail, the order should be by order of input.
•	It allowed working time/memory: 100ms/16MB.
*/