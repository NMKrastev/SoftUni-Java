package A3_BarracksWars.core.commands;

import A3_BarracksWars.annotations.Inject;
import A3_BarracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command {

    @Inject
    private Repository repository;

    public RetireCommand(String[] data/*, Repository repository, UnitFactory unitFactory*/) {
        super(data/*, repository, unitFactory*/);
    }

    @Override
    public String execute() {
        try {
            String unitType = getData()[1];
            repository.removeUnit(unitType);
            return unitType + " retired!";
        } catch (IllegalArgumentException | ExecutionControl.NotImplementedException e) {
            return e.getMessage();
        }
    }
}
