import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A3_MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> playersInfoMap = new LinkedHashMap<>();
        String input;

        while (!(input = scanner.nextLine()).equals("Season end")) {

            if (input.contains("->")) {

                String player = input.split("\\s+->\\s+")[0];
                String position = input.split("\\s+->\\s+")[1];
                int skill = Integer.parseInt(input.split("\\s+->\\s+")[2]);

                playersInfoMap.putIfAbsent(player, new LinkedHashMap<>());
                playersInfoMap.get(player).putIfAbsent(position, -1);

                if (playersInfoMap.get(player).get(position) < skill) {
                    playersInfoMap.get(player).put(position, skill);
                }
            } else {

                String playerOne = input.split("\\s+vs\\s+")[0];
                String playerTwo = input.split("\\s+vs\\s+")[1];
                if (isPlayerExist(playersInfoMap, playerOne) && isPlayerExist(playersInfoMap, playerTwo)) {
                    if (isPositionInCommon(playersInfoMap, playerOne, playerTwo)) {
                        playersInfoMap = playersBattle(playersInfoMap, playerOne, playerTwo);
                    }
                }
            }
        }

        printResults(playersInfoMap);
    }

    private static void printResults(Map<String, Map<String, Integer>> playersInfoMap) {

        playersInfoMap.entrySet()
                .stream()
                .sorted((playerOne, playerTwo) -> {
                    int result = Integer.compare(playerTwo.getValue().values().stream().mapToInt(i -> i).sum(),
                            playerOne.getValue().values().stream().mapToInt(i -> i).sum());
                    if (result == 0) {
                        result = playerOne.getKey().compareTo(playerTwo.getKey());
                    }
                    return result;
                }).forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream().mapToInt(i -> i).sum());
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> {
                                int res = Integer.compare(e2.getValue(), e1.getValue());
                                if (res == 0) {
                                    res = e1.getKey().compareTo(e2.getKey());
                                }
                                return res;
                            }).forEach(e -> {
                                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                            });
                });
    }

    private static Map<String, Map<String, Integer>> playersBattle(Map<String, Map<String, Integer>> playersInfoMap, String playerOne, String playerTwo) {

        if (playersInfoMap.get(playerOne).values().stream().mapToInt(i -> i).sum() >
                playersInfoMap.get(playerTwo).values().stream().mapToInt(i -> i).sum()) {
            playersInfoMap.remove(playerTwo);
        } else if (playersInfoMap.get(playerOne).values().stream().mapToInt(i -> i).sum() <
                playersInfoMap.get(playerTwo).values().stream().mapToInt(i -> i).sum()) {
            playersInfoMap.remove(playerOne);
        }

        return playersInfoMap;
    }

    private static boolean isPositionInCommon(Map<String, Map<String, Integer>> playersInfoMap, String playerOne, String playerTwo) {

        for (Map.Entry<String, Integer> playerOnePosition : playersInfoMap.get(playerOne).entrySet()) {
            for (Map.Entry<String, Integer> playerTwoPosition : playersInfoMap.get(playerTwo).entrySet()) {
                if (playerOnePosition.getKey().equals(playerTwoPosition.getKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPlayerExist(Map<String, Map<String, Integer>> playersInfoMap, String player) {

        return playersInfoMap.containsKey(player);
    }
}
/*Peter is a pro MOBA player. He is struggling to become a master of the Challenger tier.
So he watches the statistics in the tier carefully.
You will receive several input lines in one of the following formats:
"{player} -> {position} -> {skill}"
"{player} vs {player}"
The player and position are strings. The given skill will be an integer number. You need to keep track of every player.
When you receive a player and his position and skill, add him to the player pool. If he isn't present, else add his
position and skill or update his skill, only if the current position skill is lower than the new value.
If you receive "{player} vs {player}" and both players exist in the tier, they duel with the following rules:
Compare their positions, if they got at least one in common, the player with better total skill points wins, and the
other is demoted from the tier -> remove him. If they have the same total skill points,
the duel is a tie, and they both continue in the Season.
If they don't have positions in common, the duel isn't happening, and both continue in the Season.
You should end your program when you receive the command "Season end". At that point, you should print the players,
ordered by total skill in descending order, then ordered by player name in ascending order. For each player print,
their position and skill are ordered descending by skill and then by position name in ascending order.
Input / Constraints
•	The input comes in the form of commands in one of the formats specified above.
•	Player and position will always be one-word string, containing no whitespaces.
•	Skill will be an integer in the range [0, 1000].
•	There will be no invalid input lines.
•	The program ends when you receive the command "Season end".
Output
•	The output format for each player is:
"{player}: {totalSkill} skill
- {position} <::> {skill}"*/