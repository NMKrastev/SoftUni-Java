import java.util.Arrays;
import java.util.Scanner;

public class A5_KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        int bestSequenceSum = 0;
        int bestSequenceIndex = 0;
        int count = 0;
        int sequenceIndex = length;
        int[] bestDNASequence = new int[length];

        while (!line.equals("Clone them!")) {

            int[] dnaSequence = Arrays.stream(line.split("!+")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            int index = length;
            count++;

            for (int i = 0; i < dnaSequence.length; i++) {
                if ((i != dnaSequence.length - 1) && dnaSequence[i] == 1 && dnaSequence[i + 1] == 1
                        && index == length) {
                    index = i;
                }

                sum += dnaSequence[i];

            }

            if (index == sequenceIndex && sum > bestSequenceSum) {

                bestDNASequence = dnaSequence;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
                sequenceIndex = index;

            } else if (index < sequenceIndex) {

                bestDNASequence = dnaSequence;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
                sequenceIndex = index;

            }

            line = scanner.nextLine();

        }

        if (bestSequenceSum == 0) {
            bestSequenceIndex = 1;
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex, bestSequenceSum);
        for (int nums : bestDNASequence) {
            System.out.print(nums + " ");
        }
    }
}

/*The clone factory in Kamino got another order to clone troops.
But this time, you are tasked to find the best DNA sequence to use in the production.
You will receive the DNA length, and until you receive the command "Clone them!"
you will be receiving DNA sequences of ones and zeroes, split by "!" (one or several).
You should select the sequence with the longest subsequence of ones.
If there are several sequences with the same length of a subsequence of ones,
print the one with the leftmost starting index, if there are several sequences
with the same length and starting index, select the sequence with the greater sum of its elements.
After you receive the last command "Clone them!", you should print the
collected information in the following format:
"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
"{DNA sequence, joined by space}"
Input / Constraints:
· The first line holds the length of the sequences – integer in the range [1…100].
· On the next lines, until you receive "Clone them!" you will be receiving
sequences (at least one) of ones and zeroes, split by "!" (one or several).
Output:
The output should be printed on the console and consists of two lines in the following format:
"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
"{DNA sequence, joined by space}"*/