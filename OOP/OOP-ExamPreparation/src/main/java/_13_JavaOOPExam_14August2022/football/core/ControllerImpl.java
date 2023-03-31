package _13_JavaOOPExam_14August2022.football.core;

import _13_JavaOOPExam_14August2022.football.entities.field.ArtificialTurf;
import _13_JavaOOPExam_14August2022.football.entities.field.Field;
import _13_JavaOOPExam_14August2022.football.entities.field.NaturalGrass;
import _13_JavaOOPExam_14August2022.football.entities.player.Men;
import _13_JavaOOPExam_14August2022.football.entities.player.Women;
import _13_JavaOOPExam_14August2022.football.entities.supplement.Liquid;
import _13_JavaOOPExam_14August2022.football.entities.supplement.Powdered;
import _13_JavaOOPExam_14August2022.football.entities.supplement.Supplement;
import _13_JavaOOPExam_14August2022.football.repositories.SupplementRepository;
import _13_JavaOOPExam_14August2022.football.repositories.SupplementRepositoryImpl;
import _13_JavaOOPExam_14August2022.football.entities.player.Player;

import java.util.ArrayList;
import java.util.Collection;

import static _13_JavaOOPExam_14August2022.football.common.ConstantMessages.*;
import static _13_JavaOOPExam_14August2022.football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {

        switch (fieldType) {
            case "ArtificialTurf":
                this.fields.add(new ArtificialTurf(fieldName));
                break;
            case "NaturalGrass":
                this.fields.add(new NaturalGrass(fieldName));
                break;
            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {

        switch (type) {
            case "Powdered":
                this.supplement.add(new Powdered());
                break;
            case "Liquid":
                this.supplement.add(new Liquid());
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {

        Supplement supplementToAdd = this.supplement.findByType(supplementType);

        if (supplementToAdd == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        this.fields
                .stream()
                .filter(e -> e.getName().equals(fieldName))
                .findFirst()
                .get()
                .addSupplement(supplementToAdd);

        this.supplement.remove(supplementToAdd);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {

        Player player;

        switch (playerType) {
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        Field field = this.fields
                .stream()
                .filter(e -> e.getName().equals(fieldName))
                .findFirst()
                .get();

        if (field.getClass().getSimpleName().equals("ArtificialTurf") && player.getClass().getSimpleName().equals("Women") ||
                field.getClass().getSimpleName().equals("NaturalGrass") && player.getClass().getSimpleName().equals("Men")) {
            field.addPlayer(player);
            return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, field.getName());
        }

        return String.format(FIELD_NOT_SUITABLE);
    }

    @Override
    public String dragPlayer(String fieldName) {

        Field field = this.fields
                .stream()
                .filter(e -> e.getName().equals(fieldName))
                .findFirst()
                .get();

        field.drag();

        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {

        Field field = this.fields
                .stream()
                .filter(e -> e.getName().equals(fieldName))
                .findFirst()
                .get();

        int totalStrength = field.getPlayers()
                .stream()
                .mapToInt(Player::getStrength)
                .sum();

        return String.format(STRENGTH_FIELD, field.getName(), totalStrength);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        for (Field field : this.fields) {
            sb.append(field.getInfo()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
