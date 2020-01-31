package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestFibonacciTest {
    final LongestFibonacci obj = new LongestFibonacci();

    @Test
    public void lenLongestFibSubseq_5() {
        final int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals(5, obj.lenLongestFibSubseq(arr));
    }

    @Test
    public void lenLongestFibSubseq_3() {
        final int[] arr = {1,3,7,11,12,14,18};
        assertEquals(3, obj.lenLongestFibSubseq(arr));
    }
}