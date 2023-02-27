package A2_Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {

        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    protected Double getHeight() {

        return height;
    }

    private void setHeight(Double height) {

        this.height = height;
    }

    protected Double getWidth() {

        return width;
    }

    private void setWidth(Double width) {

        this.width = width;
    }

    @Override
    public void calculatePerimeter() {

        setPerimeter(2 * (height + width));
    }

    @Override
    public void calculateArea() {

        setArea(height * width);
    }
}