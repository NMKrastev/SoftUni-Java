import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A4_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(".*@(?<name>[A-Za-z]+)[^@:!\\->]*:(?<population>\\d+)[^@:!\\->]*!(?<command>[A|D])![^@:!\\->]*\\->(?<soldier>\\d+).*");
        List<String> attackedPlanetsList = new ArrayList<>();
        List<String> destroyedPlanetsList = new ArrayList<>();
        int numOfLines = Integer.parseInt(scanner.nextLine());

        while (numOfLines-- > 0) {

            String input = scanner.nextLine();
            int keyCount = getKeyCount(input);

            String message = getMessage(input, keyCount);
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                if (matcher.group("command").equals("D")) {
                    destroyedPlanetsList.add(matcher.group("name"));
                } else if (matcher.group("command").equals("A")) {
                    attackedPlanetsList.add(matcher.group("name"));
                }
            }
        }

        printAttackedPlanets(attackedPlanetsList);
        printDestroyedPlanets(destroyedPlanetsList);
    }

    private static void printDestroyedPlanets(List<String> destroyedPlanetsList) {
        Collections.sort(destroyedPlanetsList);
        System.out.printf("Destroyed planets: %d\n", destroyedPlanetsList.size());
        destroyedPlanetsList.forEach(e -> System.out.printf("-> %s\n", e));
    }

    private static void printAttackedPlanets(List<String> attackedPlanetsList) {
        Collections.sort(attackedPlanetsList);
        System.out.printf("Attacked planets: %d\n", attackedPlanetsList.size());
        attackedPlanetsList.forEach(e -> System.out.printf("-> %s\n", e));
    }

    private static String getMessage(String input, int keyCount) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            symbol -= keyCount;
            sb.append(symbol);
        }

        return sb.toString();
    }

    private static int getKeyCount(String input) {

        int keyCount = 0;
        String[] inputArray = input.split("");
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equalsIgnoreCase("s") || inputArray[i].equalsIgnoreCase("t") ||
                    inputArray[i].equalsIgnoreCase("a") || inputArray[i].equalsIgnoreCase("r")) {
                keyCount++;
            }
        }

        return keyCount;
    }
}
/*The war is at its peak, but you, young Padawan, can turn the tides with your programming skills.
You are tasked to create a program to decrypt the messages of The Order and prevent the death of hundreds of lives.
You will receive several messages, which are encrypted using the legendary star enigma.
You should decrypt the messages following these rules:
To properly decrypt a message, you should count all the letters [s, t, a, r] – case insensitive and remove the
count from the current ASCII value of each symbol of the encrypted message.
After decryption:
Each message should have a planet name, population, attack type ('A', as an attack or 'D', as destruction), and soldier count.
The planet's name starts after '@' and contains only letters from the Latin alphabet.
The planet population starts after ':' and is an Integer;
The attack type may be "A"(attack) or "D"(destruction) and must be surrounded by "!" (Exclamation mark).
The soldier count starts after "->" and should be an Integer.
The order in the message should be: planet name -> planet population -> attack type -> soldier count.
Each part can be separated from the others by any character except: '@', '-', '!', ':' and '>'.
Input / Constraints
· The first line holds n – the number of messages – integer in the range [1…100].
· On the next n lines, you will be receiving encrypted messages.
Output
After decrypting all messages, you should print the decrypted information in the following format:
First print the attacked planets, then the destroyed planets. "Attacked planets:
{attackedPlanetsCount}" "-> {planetName}" "Destroyed planets: {destroyedPlanetsCount}" "-> {planetName}"
The planets should be ordered by name alphabetically.*/