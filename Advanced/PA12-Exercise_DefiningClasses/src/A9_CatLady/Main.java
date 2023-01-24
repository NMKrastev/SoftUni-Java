package A9_CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> catsMap = new HashMap<>();
        String input;
        Cat cat = null;
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] catData = input.split("\\s+");
            String catBreed = catData[0];
            String catName = catData[1];

            if (catBreed.equals("Siamese")) {
                double earSize = Double.parseDouble(catData[2]);
                cat = new Siamese(catName, earSize);
            } else if (catBreed.equals("Cymric")) {
                double furLength = Double.parseDouble(catData[2]);
                cat = new Cymric(catName, furLength);
            } else if (catBreed.equals("StreetExtraordinaire")) {
                double decibels =  Double.parseDouble(catData[2]);
                cat = new StreetExtraordinaire(catName, decibels);
            }

            catsMap.put(catName, cat);
        }

        input = scanner.nextLine();
        if (catsMap.containsKey(input)) {
            System.out.println(catsMap.get(input));
        }
    }
}
/*Sara has 3 specific breeds of cats "Siamese", "Cymric" and the very famous Bulgarian breed "Street Extraordinaire",
each breed has a specific characteristic about which information should be kept. For the Siamese cats their ear size
should be kept, for Cymric cats - the length of their fur in millimeters and for the Street Extraordinaire,
the decibels of their meowing during the night.
From the console, you will receive lines of cat information until the command "End" is received, the information will
come in one of the following formats:
•	"Siamese {name} {earSize}"
•	"Cymric {name} {furLength}"
•	"StreetExtraordinaire {name} {decibelsOfMeows}"
On the last line, after the "End" command, you will receive the name of a cat, and you should print that cat.
Round the numbers two digits after the decimal separator.
*/
