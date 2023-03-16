package _01_JavaOOPExam_16August2020.onlineShop.models.products.peripherals;

import _01_JavaOOPExam_16August2020.onlineShop.models.products.BaseProduct;

import static _01_JavaOOPExam_16August2020.onlineShop.common.constants.OutputMessages.PERIPHERAL_TO_STRING;

public abstract class BasePeripheral extends BaseProduct implements Peripheral {

    private String connectionType;

    protected BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String getConnectionType() {
        return connectionType;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + PERIPHERAL_TO_STRING, getOverallPerformance(), getPrice(), getClass().getSimpleName(),
                getManufacturer(), getModel(), getId(), connectionType);
    }
}
