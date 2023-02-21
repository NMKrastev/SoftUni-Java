package A4_PizzaCalories;

import java.util.Arrays;

public class Dough {

    //private String flourType;
    private FlourType flourType;
    //private String bakingTechnique;
    private BakingTechnique bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        boolean isFlourNotExist = Arrays.stream(FlourType.values()).noneMatch(e -> e.name().equals(flourType));
        if (isFlourNotExist) {
            errorMessage();
        }
        this.flourType = FlourType.valueOf(flourType);
        /*switch (flourType) {
            case "White":
            case "Wholegrain":
                this.flourType = flourType;
                break;
            default:
                errorMessage();
        }*/
    }

    private void setBakingTechnique(String bakingTechnique) {
        boolean isTechniqueNotExist = Arrays.stream(BakingTechnique.values()).noneMatch(e -> e.name().equals(bakingTechnique));
        if (isTechniqueNotExist) {
            errorMessage();
        }
        this.bakingTechnique = BakingTechnique.valueOf(bakingTechnique);
        /*switch (bakingTechnique) {
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                errorMessage();
        }*/
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * weight) * flourType.getModifier() /*getFlourTypeModifier()*/ * bakingTechnique.getModifier() /*getBakingTechniqueModifier()*/;
    }

/*    private double getFlourTypeModifier() {
        switch (flourType) {
            case "White":
                return 1.5;
            case "Wholegrain":
                return 1.0;
        }
        return 0;
    }*/

/*    private double getBakingTechniqueModifier() {
        switch (bakingTechnique) {
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1.0;
        }
        return 0;
    }*/

    private static void errorMessage() {
        throw new IllegalArgumentException("Invalid type of dough.");
    }
}
