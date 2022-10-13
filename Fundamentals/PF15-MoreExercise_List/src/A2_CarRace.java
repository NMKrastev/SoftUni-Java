import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A2_CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        double carOneTime = findCarOneTime(numsList);
        double carTwoTime = findCarTwoTime(numsList);
        findWinner(carOneTime, carTwoTime);
    }

    private static void findWinner(double carOneTime, double carTwoTime) {
        if (carOneTime < carTwoTime) {
            System.out.printf("The winner is left with total time: %.1f", carOneTime);
        } else {
            System.out.printf("The winner is right with total time: %.1f", carTwoTime);
        }
    }

    private static double findCarTwoTime(List<Integer> numsList) {

        double carTwoTime = 0;
        int carTwoCount = numsList.size() - 1;


        while (carTwoCount > numsList.size() / 2) {
            if (numsList.get(carTwoCount) == 0) {
                carTwoTime *= 0.8;
            } else {
                carTwoTime += numsList.get(carTwoCount);
            }
            carTwoCount--;
        }
        return carTwoTime;
    }

    private static double findCarOneTime(List<Integer> numsList) {

        double carOneTime = 0;
        int carOneCount = 0;

        while (carOneCount < numsList.size() / 2) {
            if (numsList.get(carOneCount) == 0) {
                carOneTime *= 0.8;
            } else {
                carOneTime += numsList.get(carOneCount);
            }
            carOneCount++;
        }
        return carOneTime;
    }
}
