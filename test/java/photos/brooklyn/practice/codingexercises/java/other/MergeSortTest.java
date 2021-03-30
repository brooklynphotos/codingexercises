package photos.brooklyn.practice.codingexercises.java.other;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void sort() {
        int[] sorted = {2, 1, 4, 3};
        MergeSort.sort(sorted);
        assertArrayEquals(new int[]{1, 2, 3, 4}, sorted);
    }

    @Test
    public void sortOdd() {
        int[] sorted = {2, 1, 4, 3, -1};
        MergeSort.sort(sorted);
        assertArrayEquals(new int[]{-1, 1, 2, 3, 4}, sorted);
    }
}