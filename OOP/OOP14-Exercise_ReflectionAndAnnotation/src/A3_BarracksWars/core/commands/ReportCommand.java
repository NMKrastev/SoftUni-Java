package A3_BarracksWars.core.commands;

import A3_BarracksWars.annotations.Inject;
import A3_BarracksWars.interfaces.Repository;

public class ReportCommand extends Command {

    @Inject
    private Repository repository;

    public ReportCommand(String[] data/*, Repository repository, UnitFactory unitFactory*/) {
        super(data/*, repository, unitFactory*/);
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
