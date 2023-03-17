package _07_JavaOOPExam_15August2021.restaurant.core;

import _07_JavaOOPExam_15August2021.restaurant.common.ExceptionMessages;
import _07_JavaOOPExam_15August2021.restaurant.common.OutputMessages;
import _07_JavaOOPExam_15August2021.restaurant.entities.drinks.interfaces.Beverages;
import _07_JavaOOPExam_15August2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import _07_JavaOOPExam_15August2021.restaurant.entities.tables.interfaces.Table;
import _07_JavaOOPExam_15August2021.restaurant.core.interfaces.Controller;
import _07_JavaOOPExam_15August2021.restaurant.entities.drinks.Fresh;
import _07_JavaOOPExam_15August2021.restaurant.entities.drinks.Smoothie;
import _07_JavaOOPExam_15August2021.restaurant.entities.healthyFoods.Food;
import _07_JavaOOPExam_15August2021.restaurant.entities.healthyFoods.Salad;
import _07_JavaOOPExam_15August2021.restaurant.entities.healthyFoods.VeganBiscuits;
import _07_JavaOOPExam_15August2021.restaurant.entities.tables.InGarden;
import _07_JavaOOPExam_15August2021.restaurant.entities.tables.Indoors;
import _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces.BeverageRepository;
import _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces.HealthFoodRepository;
import _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces.TableRepository;

public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
        this.totalMoney = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {

        Food food = null;

        switch (type) {
            case "Salad":
                food = new Salad(name, price);
                break;
            case "VeganBiscuits":
                food = new VeganBiscuits(name, price);
                break;
        }

        if (this.healthFoodRepository.getAllEntities().contains(food)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
        }

        this.healthFoodRepository.add(food);

        return String.format(OutputMessages.FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {

        Beverages beverage = null;

        switch (type) {
            case "Smoothie":
                beverage = new Smoothie(name, counter, brand);
                break;
            case "Fresh":
                beverage = new Fresh(name, counter, brand);
                break;
        }

        if (this.beverageRepository.getAllEntities().contains(beverage)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
        }

        this.beverageRepository.add(beverage);

        return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {

        Table table = null;

        switch (type) {
            case "InGarden":
                table = new InGarden(tableNumber, capacity);
                break;
            case "Indoors":
                table = new Indoors(tableNumber, capacity);
                break;
        }

        for (Table currentTable : this.tableRepository.getAllEntities()) {
            if (currentTable.getTableNumber() == table.getTableNumber()) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
            }
        }

        this.tableRepository.add(table);

        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {

        Table table = this.tableRepository.getAllEntities()
                .stream()
                .filter(e -> e.getSize() >= numberOfPeople && !e.isReservedTable())
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        table.reserve(numberOfPeople);

        return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {

        Table table = this.tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        HealthyFood food = this.healthFoodRepository.foodByName(healthyFoodName);

        if (food == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(food);

        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {

        Table table = this.tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        Beverages beverage = this.beverageRepository.beverageByName(name, brand);

        if (beverage == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(beverage);

        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {

        Table table = this.tableRepository.byNumber(tableNumber);

        double tableBill = table.bill();

        this.totalMoney += tableBill;

        return String.format(OutputMessages.BILL, tableNumber, tableBill);
    }


    @Override
    public String totalMoney() {

        return String.format(OutputMessages.TOTAL_MONEY, this.totalMoney);
    }
}
