package _17_JavaOOPExam_08April2023.robotService.entities.services;

import _17_JavaOOPExam_08April2023.robotService.entities.robot.Robot;
import _17_JavaOOPExam_08April2023.robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static _17_JavaOOPExam_08April2023.robotService.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT;
import static _17_JavaOOPExam_08April2023.robotService.common.ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseService implements Service {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    protected BaseService(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void addRobot(Robot robot) {

        if (this.robots.size() >= capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }

        this.robots.add(robot);

    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        this.robots.forEach(Robot::eating);
    }

    @Override
    public int sumHardness() {
        return this.supplements
                .stream()
                .mapToInt(Supplement::getHardness)
                .sum();
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s:", this.name, getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("Robots: %s",
                String.format(this.robots.isEmpty()
                        ? "none"
                        : this.robots.stream().map(Robot::getName).collect(Collectors.joining(" "))))).append(System.lineSeparator());
        sb.append(String.format("Supplements: %d Hardness: %d", this.supplements.size(), this.sumHardness())).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
