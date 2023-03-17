package _07_JavaOOPExam_15August2021.restaurant.entities.tables;

import _07_JavaOOPExam_15August2021.restaurant.common.ExceptionMessages;
import _07_JavaOOPExam_15August2021.restaurant.entities.drinks.interfaces.Beverages;
import _07_JavaOOPExam_15August2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import _07_JavaOOPExam_15August2021.restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        this.setSize(size);
        this.numberOfPeople = 0;
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
        this.allPeople = 0;
    }

    private void setSize(int size) {

        if (size < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }

        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {

        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {

        this.setNumberOfPeople(numberOfPeople);

        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {

        double healthyFoodBill = this.healthyFood
                .stream()
                .mapToDouble(HealthyFood::getPrice)
                .sum();

        double beveragesBill = this.beverages
                .stream()
                .mapToDouble(Beverages::getPrice)
                .sum();


        double totalTableBill = this.allPeople = this.numberOfPeople * this.pricePerPerson;

        this.clear();

        return totalTableBill;
    }

    @Override
    public void clear() {

        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.isReservedTable = false;
        this.numberOfPeople = 0;
        this.allPeople = 0;
    }

    @Override
    public String tableInformation() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Table - %d", this.number)).append(System.lineSeparator());
        sb.append(String.format("Size - %d", this.size)).append(System.lineSeparator());
        sb.append(String.format("Type - %s", getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("All price - %.2f", this.pricePerPerson)).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
