package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinAvgTwoSliceTest {

    @Test
    public void minIndexExample() {
        final int[] A = {4, 2, 2, 5, 1, 5, 8};
        assertEquals(1, MinAvgTwoSlice.minIndex(A));
    }
}