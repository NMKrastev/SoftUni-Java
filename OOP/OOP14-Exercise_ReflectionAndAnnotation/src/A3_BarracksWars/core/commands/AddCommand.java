package A3_BarracksWars.core.commands;

import A3_BarracksWars.annotations.Inject;
import A3_BarracksWars.interfaces.Repository;
import A3_BarracksWars.interfaces.Unit;
import A3_BarracksWars.interfaces.UnitFactory;

public class AddCommand extends Command {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data/*, Repository repository, UnitFactory unitFactory*/) {
        super(data/*, repository, unitFactory*/);
    }

    @Override
    public String execute() {

        String unitType = getData()[1];

        Unit unitToAdd = unitFactory.createUnit(unitType);

        repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
