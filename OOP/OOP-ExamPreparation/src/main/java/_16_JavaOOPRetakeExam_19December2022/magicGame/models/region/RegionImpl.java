package _16_JavaOOPRetakeExam_19December2022.magicGame.models.region;

import _16_JavaOOPRetakeExam_19December2022.magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {

        List<Magician> wizards = magicians.stream()
                .filter(e -> e.getClass().getSimpleName().equals("Wizard"))
                .collect(Collectors.toList());

        List<Magician> blackWidows = magicians.stream()
                .filter(e -> e.getClass().getSimpleName().equals("BlackWidow"))
                .collect(Collectors.toList());

        while (!wizards.isEmpty() && !blackWidows.isEmpty()) {

            Magician wizard = wizards.get(0);
            Magician blackWidow = blackWidows.get(0);

            blackWidow.takeDamage(wizard.getMagic().fire());

            if (blackWidow.isAlive()) {

                wizard.takeDamage(blackWidow.getMagic().fire());

                if (!wizard.isAlive()) {
                    wizards.remove(wizard);
                }

            } else {
                blackWidows.remove(blackWidow);
            }
        }

        return String.format(wizards.isEmpty()
                ? "Black widows win!"
                : "Wizards win!");
    }
}