package JavaOOPExam_16August2020.onlineShop.models.products.computers;

import JavaOOPExam_16August2020.onlineShop.models.products.components.Component;

public class Laptop extends BaseComputer {

    private static final double OVERALL_PERFORMANCE = 10;

    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, OVERALL_PERFORMANCE);
    }

     /*
double getOverallPerformance()
Override the base functionality (if the components collection is empty, it should return only the computer overall performance,
otherwise return the sum of the computer overall performance and the average overall performance from all components)

double getPrice()
Override the base functionality (The price is equal to the total sum of the computer price with
the sum of all component prices and the sum of all peripheral prices)
*/
}
