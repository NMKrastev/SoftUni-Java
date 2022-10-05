import java.util.Scanner;

public class A4_Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());

        //Note: Judge system does not recognize the enhanced switch (It gives "Compile time error").
        switch (operation) {
            case "add" -> getAdd(numOne, numTwo);
            case "multiply" -> getMultiply(numOne, numTwo);
            case "subtract" -> getSubtract(numOne, numTwo);
            case "divide" -> getDivide(numOne, numTwo);
        }
    }

    private static void getAdd(int numOne, int numTwo) {

        System.out.println(numOne + numTwo);
    }

    private static void getMultiply(int numOne, int numTwo) {

        System.out.println(numOne * numTwo);
    }

    private static void getSubtract(int numOne, int numTwo) {

        System.out.println(numOne - numTwo);
    }

    private static void getDivide(int numOne, int numTwo) {

        System.out.println(numOne / numTwo);
    }
}
/*Write a program that receives a string on the first line ("add", "multiply", "subtract", "divide")
and on the next two lines receives two numbers. Create four methods (for each calculation) and invoke
the right one depending on the command. The method should also print the result (it needs to be void).*/