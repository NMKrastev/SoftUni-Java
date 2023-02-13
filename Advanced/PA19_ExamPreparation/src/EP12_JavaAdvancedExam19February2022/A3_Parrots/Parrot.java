package EP12_JavaAdvancedExam19February2022.A3_Parrots;

public class Parrot {

    private String name;
    private String species;
    private boolean available;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setAvailable(boolean available) {
        available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s", species, name);
    }
}
