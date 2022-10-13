import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A5_DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        List<Integer> initialDrumSet = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        getGabsyDrumSet(scanner, budget, initialDrumSet);

    }

    private static void getGabsyDrumSet(Scanner scanner, double budget, List<Integer> initialDrumSet) {

        List<Integer> drumSet = new ArrayList<>(initialDrumSet);
        String input = "";

        while (!(input = scanner.nextLine()).equals("Hit it again, Gabsy!")) {

            int power = Integer.parseInt(input);

            for (int i = 0; i < drumSet.size(); i++) {
                drumSet.set(i, (drumSet.get(i) - power));
                if (drumSet.get(i) <= 0 && budget >= initialDrumSet.get(i) * 3) {
                    drumSet.set(i, initialDrumSet.get(i));
                    budget -= initialDrumSet.get(i) * 3;
                } else if (drumSet.get(i) <= 0 && budget < initialDrumSet.get(i) * 3) {
                    drumSet.remove(drumSet.get(i));
                    initialDrumSet.remove(initialDrumSet.get(i));
                    i--;
                }
            }
        }

        for (int num : drumSet) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", budget);
    }
}

/*Gabsy is Orgolt's Final Revenge charming drummer. She has a drum set, but the different drums have different origins
– some she bought, some are gifts, so they are all of different quality. Every day she practices on each of them, so
she does damage and reduces the drum's quality. Sometimes a drum breaks, so she needs to buy a new one. Help her keep
her drum set organized.
You will receive Gabsy's savings, the money she can spend on new drums. Next, you receive a sequence of integers which
represent the initial quality of each drum in Gabsy's drum set.
Until you receive the command "Hit it again, Gabsy!", you will be receiving an integer: the hit power Gabsy applies on
each drum while practicing. When the power is applied, you should decrease the value of the drum's quality with the current power.
When a certain drum reaches 0 quality, it breaks. Then Gabsy should buy a replacement. She needs to buy the same model.
Therefore, its quality will be the same as the initial quality of the broken drum. The price is calculated by the
formula: {initialQuality} * 3. Gabsy will always replace her broken drums until the moment she can no longer afford them.
If she doesn't have enough money for a replacement, the broken drum is removed from the drum set.
When you receive the command "Hit it again, Gabsy!", the program ends, and you should print the current state of the
drum set. On the second line, you should print the remaining money in Gabsy's savings account.
Input
•	On the first line, you receive the savings – a floating-point number.
•	On the second line, you receive the drum set: a sequence of integers separated by spaces.
•	Until you receive the command "Hit it again, Gabsy!" you will be receiving integers – the hit power
Gabsy applies on each drum.
Output
•	On the first line, you should print each drum in the drum set, separated by space.
•	Then you must print the money that is left on the second line in the format "Gabsy has {money left}lv.",
formatted with two digits after the decimal point.
Constraints
•	The savings – the floating-point number in the range [0.00, 10000.00].
•	The quality of each drum in the drum set – is an integer in the range [1, 1000].
•	The hit power will be in the range [0, 1000].
•	Allowed working time / memory: 100ms / 16MB.
*/