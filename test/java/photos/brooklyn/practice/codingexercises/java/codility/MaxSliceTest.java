package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSliceTest {

    @Test
    public void maxSlice() {
        final int[] A = {5, -7, 3, 5, -2, 4, -1};
        assertEquals(10, MaxSlice.maxSlice(A));
    }
}