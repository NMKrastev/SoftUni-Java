package _01_JavaOOPExam_16August2020.onlineShop.core;

import _01_JavaOOPExam_16August2020.onlineShop.core.interfaces.Controller;
import _01_JavaOOPExam_16August2020.onlineShop.models.products.components.*;
import _01_JavaOOPExam_16August2020.onlineShop.models.products.computers.Computer;
import _01_JavaOOPExam_16August2020.onlineShop.models.products.computers.DesktopComputer;
import _01_JavaOOPExam_16August2020.onlineShop.models.products.computers.Laptop;
import _01_JavaOOPExam_16August2020.onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static _01_JavaOOPExam_16August2020.onlineShop.common.constants.ExceptionMessages.*;
import static _01_JavaOOPExam_16August2020.onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computers;
    private Computer computer;

    public ControllerImpl() {
        this.computers = new LinkedHashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {

        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }

        switch (computerType) {
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }

        computers.put(id, computer);

        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {

        checkForComputerId(!computers.containsKey(computerId), NOT_EXISTING_COMPUTER_ID);

        if (computers.get(computerId).getComponents().stream().anyMatch(e -> e.getId() == id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        Component component;

        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        computers.get(computerId).addComponent(component);

        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {

        checkForComputerId(!computers.containsKey(computerId), NOT_EXISTING_COMPUTER_ID);

        Component component = computers.get(computerId).removeComponent(componentType);

        if (component == null) {
            return String.format(NOT_EXISTING_COMPONENT, componentType, computers.get(computerId).getClass().getSimpleName(), computerId);
        }

        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {

        checkForComputerId(!computers.containsKey(computerId), NOT_EXISTING_COMPUTER_ID);

        if (computers.get(computerId).getPeripherals().stream().anyMatch(e -> e.getId() == id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }

        Peripheral peripheral;

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        computers.get(computerId).addPeripheral(peripheral);

        return String.format(ADDED_PERIPHERAL, peripheralType, peripheral.getId(), computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {

        checkForComputerId(!computers.containsKey(computerId), NOT_EXISTING_COMPUTER_ID);

        Peripheral peripheral = computers.get(computerId).removePeripheral(peripheralType);

        if (peripheral != null) {
            return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
        }

        return null;
    }

    @Override
    public String buyComputer(int id) {

        checkForComputerId(!computers.containsKey(id), NOT_EXISTING_COMPUTER_ID);

        Computer computer = computers.get(id);

        computers.remove(id);

        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {

        List<Computer> sortedComputers = computers.values()
                .stream()
                .sorted(Comparator.comparing(Computer::getOverallPerformance).thenComparing(Computer::getPrice))
                .collect(Collectors.toList());

        Computer computer = sortedComputers.stream()
                .filter(e -> e.getPrice() <= budget)
                .findFirst()
                .orElse(null);

        /*Computer computer = null;

        for (Computer sortedComputer : sortedComputers) {
            if (sortedComputer.getPrice() <= budget) {
                computer = sortedComputer;
                break;
            }
        }*/

        if (computer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        computers.remove(computer.getId());

        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {

        if (!computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        Computer computer = computers.get(id);
        return computer.toString();
    }

    private void checkForComputerId(boolean computers, String notExistingComputerId) {
        if (computers) {
            throw new IllegalArgumentException(notExistingComputerId);
        }
    }
}
