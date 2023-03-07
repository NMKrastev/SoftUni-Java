package JavaOOPExam_16August2020.onlineShop.models.products.components;

import JavaOOPExam_16August2020.onlineShop.models.products.BaseProduct;

import static JavaOOPExam_16August2020.onlineShop.common.constants.OutputMessages.COMPONENT_TO_STRING;

public abstract class BaseComponent extends BaseProduct implements Component {

    private int generation;

    protected BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }

    @Override
    public int getGeneration() {
        return generation;
    }

    @Override
    public String toString() {
        //super.toString() + " Connection Type: %s",  getOverallPerformance(), getPrice(), getClass().getSimpleName(),
        //                getManufacturer(), getModel(), getId(), connectionType
        return String.format(super.toString() + COMPONENT_TO_STRING, getOverallPerformance(), getPrice(), getClass().getSimpleName(),
                getManufacturer(), getModel(), getId(), generation);
    }
}
