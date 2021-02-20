package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeakFlagsTest {

    @Test
    public void example() {
        final int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        assertEquals(3, new PeakFlags().solution(A));
    }

    @Test
    public void noPeak() {
        final int[] A = {1, 1, 1, 1, 1, 1};
        assertEquals(0, new PeakFlags().solution(A));
    }

    @Test
    public void onePeak() {
        final int[] A = {1, 1, 1, 2, 1, 1};
        assertEquals(1, new PeakFlags().solution(A));
    }
}