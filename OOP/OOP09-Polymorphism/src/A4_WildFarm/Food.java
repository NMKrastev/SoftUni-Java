package A4_WildFarm;

public abstract class Food {

    protected Integer quantity;

    public Food(Integer quantity) {
        setQuantity(quantity);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
