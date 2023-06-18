package A6_FootballBettingDatabase;

public enum CompetitionTypes {

    LOCAL("Local"),
    NATIONAL("National"),
    INTERNATIONAL("International");

    private final String name;

    CompetitionTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
