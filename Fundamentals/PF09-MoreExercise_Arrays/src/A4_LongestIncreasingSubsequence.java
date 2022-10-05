import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A4_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numsArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int maxLength = 0;
        int lastIndex = -1;
        int[] length = new int[numsArray.length];
        int[] previous = new int[numsArray.length];

        for (int i = 0; i < numsArray.length; i++) {

            length[i] = 1;
            previous[i] = -1;

            for (int j = 0; j < i; j++) {

                if (numsArray[j] < numsArray[i] && length[j] + 1 > length[i]) {

                    length[i] = length[j] + 1;
                    previous[i] = j;

                }
            }

            if (length[i] > maxLength) {

                maxLength = length[i];
                lastIndex = i;

            }
        }

        int[] LIS = new int[maxLength];
        int currentIndex = maxLength - 1;

        while (lastIndex != -1) {

            LIS[currentIndex] = numsArray[lastIndex];
            currentIndex--;
            lastIndex = previous[lastIndex];

        }

        for (int nums : LIS) {

            System.out.print(nums + " ");

        }
    }
}
/*Read a list of integers and find the longest increasing subsequence (LIS).
If several such exist, print the leftmost.
Hints:
· Assume we have n numbers in an array nums[0…n-1].
· Let len[p] hold the length of the longest increasing subsequence (LIS) ending at position p.
· In a for loop, we shall calculate len[p] for p = 0 … n-1 as follows:
o Let left be the leftmost position on the left of p (left < p), such that len[left] is the largest possible.
o Then, len[p] = 1 + len[left]. If left does not exist, len[p] = 1.
o Also, save prev[p] = left (we hold if prev[] the previous position, used to obtain the best length for position p).
· Once the values for len[0…n-1] are calculated, restore the LIS starting from position p such that len[p] is maximal
and go back and back through p = prev[p].*/
