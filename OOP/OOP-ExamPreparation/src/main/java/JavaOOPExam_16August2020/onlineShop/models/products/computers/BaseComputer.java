package JavaOOPExam_16August2020.onlineShop.models.products.computers;

import JavaOOPExam_16August2020.onlineShop.models.products.BaseProduct;
import JavaOOPExam_16August2020.onlineShop.models.products.components.Component;
import JavaOOPExam_16August2020.onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static JavaOOPExam_16August2020.onlineShop.common.constants.ExceptionMessages.*;
import static JavaOOPExam_16August2020.onlineShop.common.constants.OutputMessages.COMPUTER_COMPONENTS_TO_STRING;
import static JavaOOPExam_16August2020.onlineShop.common.constants.OutputMessages.COMPUTER_PERIPHERALS_TO_STRING;

public abstract class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;


    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

/*
double getOverallPerformance()
Override the base functionality (if the components collection is empty, it should return only the computer overall performance,
otherwise return the sum of the computer overall performance and the average overall performance from all components)

double getPrice()
Override the base functionality (The price is equal to the total sum of the computer price with
the sum of all component prices and the sum of all peripheral prices)
*/

    @Override
    public void addComponent(Component component) {
        /*Component isPresent = components.stream()
                .filter(e -> e.equals(component))
                .findFirst()
                .orElse(null);*/
        boolean isPresent = components.stream().filter(e -> e.equals(component)).isParallel();

        if (isPresent) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(),
                    getClass().getSimpleName(), getId()));
        }

        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {

        Component component = components.stream()
                .filter(e -> e.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .orElse(null);

        if (component == null && components.isEmpty()) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, getClass().getSimpleName(), getId()));
        }

        components.remove(component);

        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {

        boolean isPresent = peripherals.stream().filter(e -> e.equals(peripheral)).isParallel();

        if (isPresent) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(),
                    getClass().getSimpleName(), getId()));
        }

        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {

        Peripheral peripheral = peripherals.stream()
                .filter(e -> e.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .orElse(null);

        if (peripheral == null && peripherals.isEmpty()) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, getClass().getSimpleName(), getId()));
        }

        peripherals.remove(peripheral);

        return peripheral;
    }


    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()) {
            return super.getOverallPerformance();
        } else {
            double averageComponentsPerformance = components.stream()
                    .mapToDouble(Component::getOverallPerformance)
                    .average()
                    .orElse(0);

            return super.getOverallPerformance() + averageComponentsPerformance;
        }
    }

    @Override
    public double getPrice() {
        double componentsSum = components.stream()
                .mapToDouble(Component::getPrice)
                .sum();
        double peripheralsSum = peripherals.stream()
                .mapToDouble(Peripheral::getPrice)
                .sum();
        return super.getPrice() + componentsSum + peripheralsSum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(super.toString(), getOverallPerformance(), getPrice(), getClass().getSimpleName(), getManufacturer(), getModel(), getId()))
                .append(System.lineSeparator());
        sb.append(" ");
        sb.append(String.format(COMPUTER_COMPONENTS_TO_STRING, components.size())).append(System.lineSeparator());

        for (Component component : components) {
            //String.format("  %s", components.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator() + "  "))))
            sb.append("  ");
            sb.append(String.format("%s", component.toString())).append(System.lineSeparator());
        }

        sb.append(" ");
        sb.append(String.format(COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(), peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0)))
                .append(System.lineSeparator());
        for (Peripheral peripheral : peripherals) {
            sb.append("  ");
            sb.append(String.format("%s", peripheral.toString())).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
