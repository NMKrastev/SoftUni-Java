package EP2_JavaAdvancedExam22Feb2020.A3_Guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(e -> e.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Member")) {
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Trial")) {
                player.setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] players = roster.stream()
                .filter(p -> p.getClazz().equals(clazz))
                .toArray(Player[]::new);

        roster.removeIf(e -> e.getClazz().equals(clazz));
        return players;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        return String.format("Players in the guild: %s:\n%s", name,
                roster.stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
