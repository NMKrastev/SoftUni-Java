import java.util.*;

public class A3_HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> heroesMap = new LinkedHashMap<>();
        String command;
        while (!(command = scanner.nextLine()).equals("End")) {
            String heroName = command.split("\\s+")[1];
            if (command.contains("Enroll")) {
                if (!heroesMap.containsKey(heroName)) {
                    heroesMap.put(heroName, new ArrayList<>());
                } else {
                    System.out.printf("%s is already enrolled.\n", heroName);
                }
            } else if (command.contains("Learn")) {
                if (heroesMap.containsKey(heroName)) {
                    learnSpell(heroesMap, command, heroName);
                } else {
                    System.out.printf("%s doesn't exist.\n", heroName);
                }
            } else if (command.contains("Unlearn")) {
                if (heroesMap.containsKey(heroName)) {
                    unlearnSpell(heroesMap, command, heroName);
                } else {
                    System.out.printf("%s doesn't exist.\n", heroName);
                }
            }
        }
        printResults(heroesMap);
    }

    private static void printResults(Map<String, List<String>> heroesMap) {
        System.out.println("Heroes:");
        heroesMap.forEach((hero, spells) -> System.out.println("== " + hero + ": " + String.join(", ", spells)));
    }

    private static Map<String, List<String>> unlearnSpell(Map<String, List<String>> heroesMap, String command, String heroName) {
        boolean isSpellPresent = false;
        String spell = command.split("\\s+")[2];
        for (int i = 0; i < heroesMap.get(heroName).size(); i++) {
            if (heroesMap.get(heroName).get(i).equals(spell)) {
                heroesMap.get(heroName).remove(i);
                isSpellPresent = true;
                break;
            }
        }
        if (!isSpellPresent) {
            System.out.printf("%s doesn't know %s.\n", heroName, spell);
        }
        return heroesMap;
    }

    private static Map<String, List<String>> learnSpell(Map<String, List<String>> heroesMap, String command, String heroName) {
        boolean isSpellPresent = false;
        String spell = command.split("\\s+")[2];
        for (int i = 0; i < heroesMap.get(heroName).size(); i++) {
            if (heroesMap.get(heroName).get(i).equals(spell)) {
                System.out.printf("%s has already learnt %s.\n", heroName, spell);
                isSpellPresent = true;
                break;
            }
        }
        if (!isSpellPresent) {
            heroesMap.get(heroName).add(spell);
        }
        return heroesMap;
    }
}
