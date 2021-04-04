package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxDoubleSliceTest {

    @Test
    public void maxDoubleSliceExample() {
        final int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
        assertEquals(17, MaxDoubleSlice.maxDoubleSlice(A));
    }
}