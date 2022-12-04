import java.util.Scanner;

public class A1_Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder spell = new StringBuilder(scanner.nextLine());
        String command;
        while (!(command = scanner.nextLine()).equals("Abracadabra")) {
            if (command.equals("Abjuration")) {
                spell = new StringBuilder(spell.toString().toUpperCase());
                System.out.println(spell);
            } else if (command.equals("Necromancy")) {
                spell = new StringBuilder(spell.toString().toLowerCase());
                System.out.println(spell);
            } else if (command.contains("Illusion")) {
                int index = Integer.parseInt(command.split("\\s+")[1]);
                if (isValidIndex(index, spell)) {
                    String letter = command.split("\\s+")[2];
                    spell.replace(index, index + 1, letter);
                    //spell.delete(index, index + 1);
                    //spell.insert(index, letter);
                    System.out.println("Done!");
                } else {
                    System.out.println("The spell was too weak.");
                }
            } else if (command.contains("Divination")) {
                String substring = command.split("\\s+")[1];
                if (spell.toString().contains(substring)) {
                    String replacement = command.split("\\s+")[2];
                    int index = spell.indexOf(substring);
                    while (index != -1) {
                        spell.replace(index, index + substring.length(), replacement);
                        index = spell.indexOf(substring);
                    }
                    System.out.println(spell);
                }
            } else if (command.contains("Alteration")) {
                String substring = command.split("\\s+")[1];
                if (spell.toString().contains(substring)) {
                    spell.delete(spell.indexOf(substring), spell.indexOf(substring) + substring.length());
                    System.out.println(spell);
                }
            } else {
                System.out.println("The spell did not work!");
            }
        }
    }

    private static boolean isValidIndex(int index, StringBuilder spell) {
        return index >= 0 && index < spell.length();
    }
}
