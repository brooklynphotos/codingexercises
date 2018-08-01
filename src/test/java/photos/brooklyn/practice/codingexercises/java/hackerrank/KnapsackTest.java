package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnapsackTest {

    @Test
    public void getMaxValue_small() {
        final int[] wts = {1, 2, 3, 2, 2};
        final int[] values = {8, 4, 0, 5, 3};
        assertEquals(13, Knapsack.getMaxValue(4, wts, values));
    }
}