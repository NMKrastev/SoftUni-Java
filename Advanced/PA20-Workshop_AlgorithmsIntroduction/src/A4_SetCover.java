import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A4_SetCover {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }
        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }
        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("\\[|]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {

        List<int[]> selectedSets = new ArrayList<>();
        Set<Integer> universeSet = new HashSet<>();
        for (int element : universe) {
            universeSet.add(element);
        }
        while (!universeSet.isEmpty()) {
            int notChosenCount = 0;
            int[] chosenSet = sets.get(0);
            for (int[] set : sets) {
                int count = 0;
                for (int element : set) {
                    if (universeSet.contains(element)) {
                        count++;
                    }
                }
                if (notChosenCount < count) {
                    notChosenCount = count;
                    chosenSet = set;
                }
            }
            selectedSets.add(chosenSet);
            for (int element : chosenSet) {
                universeSet.remove(element);
            }
        }
        return selectedSets;
    }
}
/*Write a program that finds the smallest subset of sets, which contains all elements from a given sequence.
In the Set Cover Problem, we are given two sets - a set of sets (we'll call it sets) and a universe (a sequence).
The sets contain all elements from the universe and no others, however, some elements are repeated.
The task is to find the smallest subset of sets that contains all elements in the universe.
Use the Main class from your skeleton.
Greedy Approach
Using the greedy approach, at each step, we'll take the set which contains the most elements present in the universe
which we haven't yet taken. At the first step, we'll always take the set with the largest number of elements,
but it gets a bit more complicated afterward. To simplify our job (and not check against two sets at the same time),
when taking a set, we can remove all elements in it from the universe. We can also remove the set from the sets we're considering.
Greedy Algorithm Implementation
You are given sample input in the main() method, your task is to complete the chooseSets() method.
*/