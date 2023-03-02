package solid.output;

public class ConsoleOutput implements Output {

    private static final String SUM = "Sum: %.2f";
    private static final String AVERAGE = "Average: %.2f";

    @Override
    public void outputSum(double sum) {
        System.out.printf((SUM) + "\n", sum);
    }

    @Override
    public void outputAverage(double sum) {
        System.out.printf((AVERAGE) + "\n", sum);
    }
}
