package _11_JavaOOPExam09April2022.fairyShop.core;

import _11_JavaOOPExam09April2022.fairyShop.models.*;
import _11_JavaOOPExam09April2022.fairyShop.repositories.PresentRepository;
import _11_JavaOOPExam09April2022.fairyShop.repositories.HelperRepository;

import java.util.List;
import java.util.stream.Collectors;

import static _11_JavaOOPExam09April2022.fairyShop.common.ConstantMessages.*;
import static _11_JavaOOPExam09April2022.fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private Shop shop;
    private int craftedPresentsCount;
    int brokenInstrumentsCount;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        this.shop = new ShopImpl();
        this.craftedPresentsCount = 0;
        this.brokenInstrumentsCount = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {

        switch (type) {
            case "Happy":
                this.helperRepository.add(new Happy(helperName));
                break;
            case "Sleepy":
                this.helperRepository.add(new Sleepy(helperName));
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }

        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {

        Helper helper = this.helperRepository.findByName(helperName);

        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        helper.addInstrument(new InstrumentImpl(power));

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {

        this.presentRepository.add(new PresentImpl(presentName, energyRequired));

        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        List<Helper> suitableHelpers = this.helperRepository.getModels()
                .stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        if (suitableHelpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        Present present = this.presentRepository.findByName(presentName);

        for (Helper helper : suitableHelpers) {

            this.shop.craft(present, helper);

            this.brokenInstrumentsCount = helper.getInstruments()
                    .stream()
                    .filter(Instrument::isBroken)
                    .collect(Collectors.toList())
                    .size();

            if (present.isDone()) {
                this.craftedPresentsCount++;
                break;
            }
        }

        return String.format(PRESENT_DONE + COUNT_BROKEN_INSTRUMENTS,
                presentName, String.format(present.isDone() ? "done" : "not done"),
                this.brokenInstrumentsCount);
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d presents are done!", this.craftedPresentsCount)).append(System.lineSeparator());
        sb.append("Helpers info:").append(System.lineSeparator());
        for (Helper helper : this.helperRepository.getModels()) {
            sb.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator());
            sb.append(String.format("Energy: %d", helper.getEnergy())).append(System.lineSeparator());
            sb.append(String.format("Instruments: %d not broken left",
                            helper.getInstruments().stream().filter(e -> !e.isBroken()).collect(Collectors.toList()).size()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
