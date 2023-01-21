import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class A4_AppliedArithmetic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        /*Consumer<List<Integer>> add = numbers -> numbers.replaceAll(n -> n + 1);
        Consumer<List<Integer>> subtract = numbers -> numbers.replaceAll(n -> n - 1);
        Consumer<List<Integer>> multiply = numbers -> numbers.replaceAll(n -> n * 2);*/
        UnaryOperator<List<Integer>> add = numbers -> numbers.stream().map(number -> number + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = numbers -> numbers.stream().map(number -> number - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = numbers -> numbers.stream().map(number -> number * 2).collect(Collectors.toList());

        Consumer<List<Integer>> printer = numbers -> numbers.forEach(num -> System.out.print(num + " "));

        String input;
        while (!(input = scanner.nextLine()).equals("end")) {
            switch (input) {
                case "add":
                    numbersList = add.apply(numbersList);
                    break;
                case "subtract":
                    numbersList = subtract.apply(numbersList);
                    break;
                case "multiply":
                    numbersList = multiply.apply(numbersList);
                    break;
                case "print":
                    printer.accept(numbersList);
                    System.out.println();
                    break;
            }
        }
    }
}
/*On the first line, you are given a list of numbers. On the next lines you are passed different commands that you
need to apply to all numbers in the list: "add" -> adds 1; "multiply" -> multiplies by 2; "subtract" -> subtracts 1;
"print" -> prints all numbers on a new line. The input will end with an "end" command, after which the result must be printed.*/
