package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSliceNegativesTest {

    @Test
    public void maxSlice() {
        final int[] A = {3, 2, -6, 4, 0};
        assertEquals(5, MaxSlice.maxSlice(A));
    }

    @Test
    public void maxSliceNegatives() {
        final int[] A = {-3, -2, -6, -4, -5};
        assertEquals(-2, MaxSlice.maxSlice(A));
    }
}