package A1_ClassBoxDataValidation;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {

        checkParameters(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {

        checkParameters(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        checkParameters(height, "Height");
        this.height = height;
    }

    private void checkParameters(double element, String messagePrefix) {
        if (element <= 0) {
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", messagePrefix));
        }
    }

    public double calculateSurfaceArea() {
        return (2 * length * width) + (2 * length * height) + (2 * width * height);
    }

    public double calculateLateralSurfaceArea() {
        return (2 * length * height) + (2 * width * height);
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
