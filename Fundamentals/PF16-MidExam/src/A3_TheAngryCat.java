import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A3_TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> priceRatingList = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int index = Integer.parseInt(scanner.nextLine());
        String typeOfItem = scanner.nextLine();
        int leftDamage = 0;
        int rightDamage = 0;

        switch (typeOfItem) {
            case "cheap":
                leftDamage = getLeftDamage(priceRatingList, index, leftDamage);
                rightDamage = getRightDamage(priceRatingList, index, rightDamage);

                printResult(leftDamage, rightDamage);
                break;
            case "expensive":
                leftDamage = getLeftDamageExpensive(priceRatingList, index, leftDamage);
                rightDamage = getRightDamageExpensive(priceRatingList, index, rightDamage);

                printResult(leftDamage, rightDamage);
        }
    }

    private static int getRightDamageExpensive(List<Integer> priceRatingList, int index, int rightDamage) {

        for (int i = index + 1; i < priceRatingList.size(); i++) {
            if (priceRatingList.get(index) <= priceRatingList.get(i)) {
                rightDamage += priceRatingList.get(i);
            }
        }
        return rightDamage;
    }

    private static int getLeftDamageExpensive(List<Integer> priceRatingList, int index, int leftDamage) {

        for (int i = 0; i < index; i++) {
            if (priceRatingList.get(index) <= priceRatingList.get(i)) {
                leftDamage += priceRatingList.get(i);
            }
        }
        return leftDamage;
    }

    private static int getRightDamage(List<Integer> priceRatingList, int index, int rightDamage) {

        for (int i = index + 1; i < priceRatingList.size(); i++) {
            if (priceRatingList.get(index) > priceRatingList.get(i)) {
                rightDamage += priceRatingList.get(i);
            }
        }
        return rightDamage;
    }

    private static int getLeftDamage(List<Integer> priceRatingList, int index, int leftDamage) {

        for (int i = 0; i < index; i++) {
            if (priceRatingList.get(index) > priceRatingList.get(i)) {
                leftDamage += priceRatingList.get(i);
            }
        }
        return leftDamage;
    }

    private static void printResult(int leftDamage, int rightDamage) {
        if (leftDamage >= rightDamage) {
            System.out.printf("Left - %d\n", leftDamage);
        } else {
            System.out.printf("Right - %d\n", rightDamage);
        }
    }
}
/*Each item has a price rating, a number that describes how valuable that item is for John's owner.
You will be given an entry point from which John will break the items to his left and then to his right.
John will never break the item at his entry point.
You must calculate the damage to both his left and right, then print only the higher (bigger) damage to the household.
If both sums are equal, print the left one.
Input / Constrains:
•	On the first line, you will receive the price ratings, separated by (", ").
Each element will be an integer in the range  [-231...  231).
•	On the second line, you will receive the entry point, which will always be between the second and the
penultimate element in the array.
•	On the third line, you will receive the type of items John wants to break which will be one of the following:
o	"cheap" - items that have a lower price rating than the entry point item
o	"expensive" - items that have the same price rating, or higher price rating than the entry point item
Output:
•	A single line containing the sum of price ratings and their position based on the entry point in the follow ing format:
o	"{position} - {sum of price ratings} "
o	Positions can be "Right" or "left"
*/