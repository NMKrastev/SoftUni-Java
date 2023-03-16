package _03_JavaOOPExam_12December2020.bakery.entities.tables;

public class InsideTable extends BaseTable {

    private static final double pricePerPerson = 2.50;

    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, pricePerPerson);
    }
}
