package _16_JavaOOPRetakeExam_19December2022.magicGame.core;

import _16_JavaOOPRetakeExam_19December2022.magicGame.common.ExceptionMessages;
import _16_JavaOOPRetakeExam_19December2022.magicGame.common.OutputMessages;
import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magicians.BlackWidow;
import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magicians.Magician;
import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magicians.Wizard;
import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magics.RedMagic;
import _16_JavaOOPRetakeExam_19December2022.magicGame.models.region.Region;
import _16_JavaOOPRetakeExam_19December2022.magicGame.models.region.RegionImpl;
import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magics.BlackMagic;
import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magics.Magic;
import _16_JavaOOPRetakeExam_19December2022.magicGame.repositories.MagicRepositoryImpl;
import _16_JavaOOPRetakeExam_19December2022.magicGame.repositories.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {

        switch (type) {
            case "RedMagic":
                this.magics.addMagic(new RedMagic(name, bulletsCount));
                break;
            case "BlackMagic":
                this.magics.addMagic(new BlackMagic(name, bulletsCount));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {

        Magic magic = magics.findByName(magicName);

        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        }

        switch (type) {
            case "Wizard":
                this.magicians.addMagician(new Wizard(username, health, protection, magic));
                break;
            case "BlackWidow":
                this.magicians.addMagician(new BlackWidow(username, health, protection, magic));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        }

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {

        return this.region.start(this.magicians.getData()
                .stream()
                .filter(Magician::isAlive)
                .collect(Collectors.toList()));
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();

        List<Magician> orderedMagicians = this.magicians.getData().stream()
                .sorted(Comparator.comparingInt(Magician::getHealth)
                        .thenComparing(Magician::getUsername))
                .collect(Collectors.toList());

        orderedMagicians.forEach(e -> sb.append(e.toString()));

        return sb.toString().trim();
    }
}