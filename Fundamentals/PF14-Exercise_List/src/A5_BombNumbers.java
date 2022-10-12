import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A5_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int[] specialNumAndPower = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int specialNumber = specialNumAndPower[0];
        int power = specialNumAndPower[1];

        detonation(numsList, specialNumber, power);
        printSumOfRemainingList(numsList);

    }

    private static void printSumOfRemainingList(List<Integer> numsList) {
        int sum = 0;
        for (int num : numsList) {
            sum += num;
        }
        System.out.println(sum);
    }

    private static List<Integer> detonation(List<Integer> numsList, int specialNumber, int power) {

        if (numsList.contains(specialNumber)) {
            for (int i = 0; i < numsList.size(); i++) {
                int currentNumber = numsList.get(i);
                if (currentNumber == specialNumber) {
                    int startIndex = i - power;
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    int endIndex = i + power;
                    if (endIndex > numsList.size() - 1) {
                        endIndex = numsList.size() - 1;
                    }

                    for (int j = startIndex; j <= endIndex; j++) {
                        numsList.set(j, 0);
                    }
                }
            }
        }
        return numsList;
    }
}
/*Write a program that reads a sequence of numbers and a special bomb number with a certain power.
Your task is to detonate every occurrence of the special bomb number and according to its power -
his neighbors from left and right. Detonations are performed from left to right, and all detonated numbers disappear.
Finally, print the sum of the remaining elements in the sequence.*/