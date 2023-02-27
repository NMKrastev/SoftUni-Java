package A3_Animals;

public abstract class Animal {

    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood) {

        setName(name);
        setFavouriteFood(favouriteFood);
    }

    protected String getName() {

        return name;
    }

    protected void setName(String name) {

        this.name = name;
    }

    protected String getFavouriteFood() {

        return favouriteFood;
    }

    protected void setFavouriteFood(String favouriteFood) {

        this.favouriteFood = favouriteFood;
    }

    public String explainSelf() {

        return String.format("I am %s and my favourite food is %s", name, favouriteFood);
    }
}
