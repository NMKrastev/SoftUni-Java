package EP3_JavaAdvancedExam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class A1_Bombs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> bombEffects = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> bombCasings = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        String daturaBombs = "Datura Bombs";
        String cherryBombs = "Cherry Bombs";
        String smokeBombs = "Smoke Decoy Bombs";
        Map<String, Integer> bombsMap = new TreeMap<>(
                Map.of(cherryBombs, 0,
                        daturaBombs, 0,
                        smokeBombs, 0));
        boolean hasMadeTheBombs = false;

        while (!bombEffects.isEmpty() && !bombCasings.isEmpty()) {

            int currentEffect = bombEffects.removeFirst();
            int currentCasing = bombCasings.removeLast();
            int product = currentEffect + currentCasing;

            if (product == 40) {
                bombsMap.put(daturaBombs, bombsMap.get(daturaBombs) + 1);
            } else if (product == 60) {
                bombsMap.put(cherryBombs, bombsMap.get(cherryBombs) + 1);
            } else if (product == 120) {
                bombsMap.put(smokeBombs, bombsMap.get(smokeBombs) + 1);
            } else {
                bombEffects.addFirst(currentEffect);
                currentCasing -= 5;
                bombCasings.addLast(currentCasing);
            }

            if (bombsMap.get(daturaBombs) >= 3 && bombsMap.get(cherryBombs) >= 3 && bombsMap.get(smokeBombs) >= 3) {
                hasMadeTheBombs = true;
                break;
            }
        }

        System.out.println(hasMadeTheBombs
                ? "Bene! You have successfully filled the bomb pouch!"
                : "You don't have enough materials to fill the bomb pouch.");
        System.out.println(bombEffects.isEmpty()
                ? "Bomb Effects: empty"
                : String.format("Bomb Effects: %s", bombEffects.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println(bombCasings.isEmpty()
                ? "Bomb Casings: empty"
                : String.format("Bomb Casings: %s", bombCasings.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        bombsMap.forEach((bombs, value) -> System.out.printf("%s: %d\n", bombs, value));
    }
}
/*You will be given two sequences of integers, representing bomb effects and bomb casings.
You need to start from the first bomb effect and try to mix it with the last bomb casing.
If the sum of their values is equal to any of the materials in the table below – create the bomb corresponding
to the value and remove both bomb materials. Otherwise, just decrease the value of the bomb casing by 5.
You need to stop combining when you have no more bomb effects of bomb casings, or you successfully filled the bomb pouch.
Bombs:
•	Datura Bombs: 40
•	Cherry Bombs: 60
•	Smoke Decoy Bombs: 120
To fill the bomb pouch, Ezio needs three of each of the bomb types.
Input
•	On the first line, you will receive the integers representing the bomb effects, separated by ", ".
•	On the second line, you will receive the integers representing the bomb casing, separated by ", ".
Output
•	On the first line of output – print one of these rows according to whether Ezio succeeded to fulfill the bomb pouch:
o	"Bene! You have successfully filled the bomb pouch!"
o	"You don't have enough materials to fill the bomb pouch."
•	On the second line - print all bomb effects left:
o	If there are no bomb effects: "Bomb Effects: empty"
o	If there are effects: "Bomb Effects: {bombEffect1}, {bombEffect2}, (…)"
•	On the third line - print all bomb casings left:
o	If there are no bomb casings: "Bomb Casings: empty"
o	If there are casings: "Bomb Casings: {bombCasing1}, {bombCasing2}, (…)"
•	Then, you need to print all created bombs and the count you have of them, ordered alphabetically:
o	"Cherry Bombs: {count}"
o	"Datura Bombs: {count}"
o	"Smoke Decoy Bombs: {count}"
Constraints
•	All of the given numbers will be valid integers in the range [0, 120].
•	Don't have a situation with negative material.
*/
