import java.util.*;
import java.util.stream.Collectors;

public class A1_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());

        Map<Double, Integer> countNumbersMap = new TreeMap<>();

        for (double currentNum : numsList) {

            Integer currentValue = countNumbersMap.get(currentNum);
            if (countNumbersMap.containsKey(currentNum)) {
                countNumbersMap.put(currentNum, currentValue + 1);
            } else {
                countNumbersMap.put(currentNum, 1);
            }

            //Does the same thing as the code above.
            /*countNumbersMap.putIfAbsent(currentNum, 0);
            int currentValue = countNumbersMap.get(currentNum);
            countNumbersMap.put(currentNum, currentValue + 1);*/
        }

        for (Map.Entry<Double, Integer> entry : countNumbersMap.entrySet()) {
            System.out.printf("%.0f -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
/*Read a list of real numbers and print them in ascending order along with their number of occurrences.*/