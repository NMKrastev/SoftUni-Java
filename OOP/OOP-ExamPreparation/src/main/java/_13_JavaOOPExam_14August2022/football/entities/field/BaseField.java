package _13_JavaOOPExam_14August2022.football.entities.field;

import _13_JavaOOPExam_14August2022.football.entities.supplement.Supplement;
import _13_JavaOOPExam_14August2022.football.entities.player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static _13_JavaOOPExam_14August2022.football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static _13_JavaOOPExam_14August2022.football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int sumEnergy() {

        return this.supplements
                .stream()
                .mapToInt(Supplement::getEnergy)
                .sum();
    }

    @Override
    public void addPlayer(Player player) {

        if (this.players.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s (%s):", this.name, getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("Player: %s",
                        String.format(this.players.isEmpty()
                                ? "none"
                                : this.players.stream().map(Player::getName).collect(Collectors.joining(" ")))))
                .append(System.lineSeparator());
        sb.append(String.format("Supplement: %d", this.supplements.size())).append(System.lineSeparator());
        sb.append(String.format("Energy: %d", this.sumEnergy()));

        return sb.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
