package JavaOOPExam_12December2020.bakery.entities.tables;

public class OutsideTable extends BaseTable {

    private static final double pricePerPerson = 3.50;

    public OutsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, pricePerPerson);
    }
}
