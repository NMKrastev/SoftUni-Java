package EP17_JavaAdvancedRetakeExam14December2022;

import java.util.*;
import java.util.stream.Stream;

public class A1_ClimbThePeaks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> conqueredPeaks = new ArrayList<>();
        Deque<String> peaks = new ArrayDeque<>(Arrays.asList("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));
        Map<String, Integer> peaksAndLevels = new LinkedHashMap<>(Map.of(
                "Vihren", 80,
                "Kutelo", 90,
                "Banski Suhodol", 100,
                "Polezhan", 60,
                "Kamenitza", 70
        ));

        Deque<Integer> dailyPortions = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(dailyPortions::push);
        Deque<Integer> dailyStamina = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(dailyStamina::offer);

        while (!peaks.isEmpty() && !dailyPortions.isEmpty() && !dailyStamina.isEmpty()) {
            String currentPeak = peaks.getFirst();
            if (dailyPortions.peek() + dailyStamina.peek() >= peaksAndLevels.get(currentPeak)) {
                conqueredPeaks.add(currentPeak);
                dailyPortions.pop();
                dailyStamina.poll();
                peaksAndLevels.remove(currentPeak);
                peaks.removeFirst();
            } else {
                dailyPortions.pop();
                dailyStamina.poll();
            }
        }

        System.out.println(peaksAndLevels.isEmpty()
                ? "Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK"
                : "Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            conqueredPeaks.forEach(System.out::println);
        }
    }
}
/*You will have to keep information for all the conquered peaks, if any.
Every day, Alex will use one portion of his daily food supplies and will exhaust one of his daily stamina.
First, you will be given a sequence of numbers, representing the quantities of the daily portions of food supplies in his backpack.
Afterward, you will be given another sequence of numbers, representing the quantities of the daily stamina
he will have at his disposal for the next seven days.
You have to sum the quantity of the last daily food portion with the quantity of the first daily stamina.
He will start climbing from the first peak in the table below to the last one.
•	If the sum is equal or greater than the corresponding Mountain Peak’s Difficulty level from the table below,
it means that the peak is conquered. In this case, you should remove both quantities from
the sequences and continue with the next ones towards the next peak.
•	If the sum is less than the corresponding Mountain Peak’s Difficulty level from the table below,
the peak remains unconquered. You should remove both quantities from the sequences.
Alex will have to sleep in his tent. On the next day he will try the same peak once again.

Mountain Peaks	Difficulty level
Vihren	80
Kutelo	90
Banski Suhodol	100
Polezhan	60
Kamenitza	70

Alex will try to conquer as much peaks as he can in seven days. If he manages to climb all the peaks earlier
(before the seventh day), the adventure is over and the output is printed on the Console.
Finally, print on the Console all the conquered peaks(in the order of climbing).
Input
•	On the first line, you will receive the food portions quantities, separated by a comma and a single space
(", ").
•	On the second line, you will receive the stamina quantities, separated by a comma and a single space (", ").
Output
•	On the first line – print whether Alex managed to reach his goal and climb all the peaks in his list:
o	If he managed to conquer all: "Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK"
o	If he didn't manage to climb all of the peaks: "Alex failed! He has to organize his journey better next time -> @PIRINWINS"
•	Then, in either case, if Alex fails or succeeds in completing the climbing adventure, you should print all conquered peaks (in the order of climbing), if there are any:
Conquered peaks:
{peak1}
{peak2}
…
{peakn}
o	If there are no conquered peaks do not print this message.
*/
