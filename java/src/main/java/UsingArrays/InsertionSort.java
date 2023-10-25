package UsingArrays;

public class InsertionSort {
    public static void insertionSort(char[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            char current = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > current) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = current;
        }
    }
}
