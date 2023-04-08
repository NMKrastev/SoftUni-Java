package _17_JavaOOPExam_08April2023.robotService.core;

import _17_JavaOOPExam_08April2023.robotService.entities.robot.FemaleRobot;
import _17_JavaOOPExam_08April2023.robotService.entities.robot.MaleRobot;
import _17_JavaOOPExam_08April2023.robotService.entities.services.SecondaryService;
import _17_JavaOOPExam_08April2023.robotService.entities.supplements.MetalArmor;
import _17_JavaOOPExam_08April2023.robotService.repositories.SupplementRepository;
import _17_JavaOOPExam_08April2023.robotService.entities.robot.Robot;
import _17_JavaOOPExam_08April2023.robotService.entities.services.MainService;
import _17_JavaOOPExam_08April2023.robotService.entities.services.Service;
import _17_JavaOOPExam_08April2023.robotService.entities.supplements.PlasticArmor;
import _17_JavaOOPExam_08April2023.robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;

import static _17_JavaOOPExam_08April2023.robotService.common.ConstantMessages.*;
import static _17_JavaOOPExam_08April2023.robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {

        switch (type) {
            case "MainService":
                this.services.add(new MainService(name));
                break;
            case "SecondaryService":
                this.services.add(new SecondaryService(name));
                break;
            default:
                throw new NullPointerException(INVALID_SERVICE_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {

        switch (type) {
            case "PlasticArmor":
                this.supplements.addSupplement(new PlasticArmor());
                break;
            case "MetalArmor":
                this.supplements.addSupplement(new MetalArmor());
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {

        Supplement supplement = this.supplements.findFirst(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Service service = this.services
                .stream()
                .filter(e -> e.getName().equals(serviceName))
                .findFirst()
                .get();

        service.addSupplement(supplement);
        this.supplements.removeSupplement(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {

        Robot robot = null;

        switch (robotType) {
            case "MaleRobot":
                robot = new MaleRobot(robotName, robotKind, price);
                break;
            case "FemaleRobot":
                robot = new FemaleRobot(robotName, robotKind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }

        Service service = this.services
                .stream()
                .filter(e -> e.getName().equals(serviceName))
                .findFirst()
                .get();

        if (service.getClass().getSimpleName().equals("MainService") && robot.getClass().getSimpleName().equals("FemaleRobot")
        || service.getClass().getSimpleName().equals("SecondaryService") && robot.getClass().getSimpleName().equals("MaleRobot")) {
            return String.format(UNSUITABLE_SERVICE);
        }

        service.addRobot(robot);

        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {

        Service service = this.services
                .stream()
                .filter(e -> e.getName().equals(serviceName))
                .findFirst()
                .get();

        service.feeding();

        return String.format(FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {

        Service service = this.services
                .stream()
                .filter(e -> e.getName().equals(serviceName))
                .findFirst()
                .get();

        double robotsValue = service.getRobots()
                .stream()
                .mapToDouble(Robot::getPrice)
                .sum();

        double supplementsValue = service.getSupplements()
                .stream()
                .mapToDouble(Supplement::getPrice)
                .sum();


        return String.format(VALUE_SERVICE, serviceName, robotsValue + supplementsValue);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        this.services.forEach(e -> sb.append(e.getStatistics()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
