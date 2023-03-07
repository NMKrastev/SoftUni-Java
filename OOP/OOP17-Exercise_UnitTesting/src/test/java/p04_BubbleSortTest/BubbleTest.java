package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] numbers = {5, 3, 2, 1, 10, 9 , 8, 6};
        int[] sortedNumbers = {1, 2, 3, 5, 6, 8 , 9, 10};
        Bubble.sort(numbers);
        assertArrayEquals(sortedNumbers, numbers);
    }
}