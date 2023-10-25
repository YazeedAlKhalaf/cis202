package UsingArrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {
    @Test
    void insertionSort_shouldSortAndUnorderedArrayOfTypeChar() {
        char[] array = {'Z', 'B', 'C', 'D', 'A', 'E', 'H', 'G', 'F'};
        InsertionSort.insertionSort(array);

        char[] sortedArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'Z'};
        assertArrayEquals(sortedArray, array);
    }
}