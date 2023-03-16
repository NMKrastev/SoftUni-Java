package _03_JavaOOPExam_12December2020.bakery.core;

import _03_JavaOOPExam_12December2020.bakery.core.interfaces.Controller;
import _03_JavaOOPExam_12December2020.bakery.entities.bakedFoods.interfaces.BakedFood;
import _03_JavaOOPExam_12December2020.bakery.entities.tables.OutsideTable;
import _03_JavaOOPExam_12December2020.bakery.repositories.interfaces.DrinkRepository;
import _03_JavaOOPExam_12December2020.bakery.repositories.interfaces.FoodRepository;
import _03_JavaOOPExam_12December2020.bakery.repositories.interfaces.TableRepository;
import _03_JavaOOPExam_12December2020.bakery.common.enums.BakedFoodType;
import _03_JavaOOPExam_12December2020.bakery.common.enums.DrinkType;
import _03_JavaOOPExam_12December2020.bakery.common.enums.TableTYpe;
import _03_JavaOOPExam_12December2020.bakery.entities.bakedFoods.Bread;
import _03_JavaOOPExam_12December2020.bakery.entities.bakedFoods.Cake;
import _03_JavaOOPExam_12December2020.bakery.entities.drinks.Tea;
import _03_JavaOOPExam_12December2020.bakery.entities.drinks.Water;
import _03_JavaOOPExam_12December2020.bakery.entities.drinks.interfaces.Drink;
import _03_JavaOOPExam_12December2020.bakery.entities.tables.InsideTable;
import _03_JavaOOPExam_12December2020.bakery.entities.tables.interfaces.Table;

import java.util.List;
import java.util.stream.Collectors;

import static _03_JavaOOPExam_12December2020.bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static _03_JavaOOPExam_12December2020.bakery.common.ExceptionMessages.TABLE_EXIST;
import static _03_JavaOOPExam_12December2020.bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private final FoodRepository<BakedFood> foodRepository;
    private final DrinkRepository<Drink> drinkRepository;
    private final TableRepository<Table> tableRepository;
    private double totalIncome;


    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.totalIncome = 0;
    }


    @Override
    public String addFood(String type, String name, double price) {

        BakedFood food = this.foodRepository.getAll().stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (food != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        BakedFoodType foodType = BakedFoodType.valueOf(type);

        switch (foodType) {
            case Bread:
                food = new Bread(name, price);
                break;
            case Cake:
                food = new Cake(name, price);
                break;
            default:
                throw new IllegalArgumentException("TODO");
        }

        this.foodRepository.add(food);

        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {

        Drink drink = this.drinkRepository.getAll().stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (drink != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        DrinkType drinkType = DrinkType.valueOf(type);

        switch (drinkType) {
            case Tea:
                drink = new Tea(name, portion, brand);
                break;
            case Water:
                drink = new Water(name, portion, brand);
                break;
            default:
                throw new IllegalArgumentException("TODO");
        }

        this.drinkRepository.add(drink);

        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {

        Table table = this.tableRepository.getAll().stream()
                .filter(e -> e.getTableNumber() == tableNumber)
                .findFirst()
                .orElse(null);

        if (table != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        TableTYpe tableType = TableTYpe.valueOf(type);

        switch (tableType) {
            case InsideTable:
                table = new InsideTable(tableNumber, capacity);
                break;
            case OutsideTable:
                table = new OutsideTable(tableNumber, capacity);
                break;
            default:
                throw new IllegalArgumentException("TODO");
        }

        this.tableRepository.add(table);

        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {

        Table table = this.tableRepository.getAll().stream()
                .filter(e -> e.getCapacity() >= numberOfPeople && !e.isReserved())
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        table.reserve(numberOfPeople);

        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {

        Table table = this.tableRepository.getAll().stream()
                .filter(e -> e.getTableNumber() == tableNumber && e.isReserved())
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        BakedFood food = this.foodRepository.getAll().stream()
                .filter(e -> e.getName().equals(foodName))
                .findFirst()
                .orElse(null);

        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }

        table.orderFood(food);

        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {

        Table table = this.tableRepository.getAll().stream()
                .filter(e -> e.getTableNumber() == tableNumber && e.isReserved())
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        Drink drink = this.drinkRepository.getAll().stream()
                .filter(e -> e.getName().equals(drinkName) && e.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);

        if (drink == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }

        table.orderDrink(drink);

        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {

        Table table = this.tableRepository.getAll().stream()
                .filter(e -> e. getTableNumber() == tableNumber)
                .findFirst()
                .orElse(null);

        if (table == null) {
            throw new IllegalArgumentException("TODO");
        }

        double bill = table.getBill();
        table.clear();
        this.totalIncome += bill;

        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        List<Table> freeTable = tableRepository.getAll().stream()
                .filter(e -> !e.isReserved())
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        freeTable.forEach(e -> sb.append(e.getFreeTableInfo()).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, this.totalIncome);
    }
}
