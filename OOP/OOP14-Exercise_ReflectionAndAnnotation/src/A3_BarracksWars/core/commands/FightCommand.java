package A3_BarracksWars.core.commands;

public class FightCommand extends Command {

    public FightCommand(String[] data/*, Repository repository, UnitFactory unitFactory*/) {
        super(data/*, repository, unitFactory*/);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
