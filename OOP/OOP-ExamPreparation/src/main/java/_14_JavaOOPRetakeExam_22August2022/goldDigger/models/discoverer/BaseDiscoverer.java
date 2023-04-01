package _14_JavaOOPRetakeExam_22August2022.goldDigger.models.discoverer;

import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.museum.Museum;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.museum.BaseMuseum;

import static _14_JavaOOPRetakeExam_22August2022.goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static _14_JavaOOPRetakeExam_22August2022.goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiscoverer implements Discoverer {

    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setEnergy(double energy) {

        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }

        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canDig() {
        return this.energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public void dig() {
        this.energy -= 15;

        if (this.energy < 0) {
            this.energy = 0;
        }
    }
}
