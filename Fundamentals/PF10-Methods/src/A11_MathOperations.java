import java.text.DecimalFormat;
import java.util.Scanner;

public class A11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numOne = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double numTwo = Double.parseDouble(scanner.nextLine());
        double result = printMathOperation(numOne, operator, numTwo);

        System.out.println(new DecimalFormat("0.##").format(result));

    }

    private static double printMathOperation(double numOne, String operator, double numTwo) {

        double result = 0;

        switch (operator) {
            case "+":
                result = numOne + numTwo;
                break;
            case "-":
                result = numOne - numTwo;
                break;
            case "*":
                result = numOne * numTwo;
                break;
            case "/":
                result = numOne / numTwo;
                break;
        }
        return result;
    }
}
/*Write a method that receives two numbers and an operator, calculates the result and returns it.
You will be given three lines of input. The first will be the first number, the second one will
be the operator and the last one will be the second number. The possible operators are: / * + -
Print the result rounded up to the second decimal point.*/