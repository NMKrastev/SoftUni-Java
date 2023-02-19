package A5_JediGalaxy;

import java.util.Arrays;

public class InputParser {

    public static int[] parseIntegerArray(String input) {
        return Arrays
                .stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
