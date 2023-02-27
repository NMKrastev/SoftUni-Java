package A2_Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {

        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    protected final Double getRadius() {

        return radius;
    }

    private void setRadius(Double radius) {

        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {

        setPerimeter(2 * (Math.PI * radius));
    }

    @Override
    public void calculateArea() {

        setArea(Math.PI * radius * radius);
    }
}