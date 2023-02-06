package EP2_JavaAdvancedExam22Feb2020.A3_Guild;

public class Player {

    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Player %s: %s\nRank: %s\nDescription: %s", getName(), getClazz(), getRank(), getDescription());
    }
}
