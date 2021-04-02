package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class OverlappingCirclesTest {

    @Test
    public void countPairsExample1() {
        final int[] A = {1, 5, 2, 1, 4, 0};
        assertEquals(11, OverlappingCircles.countPairs(A));
    }
    @Test
    public void countPairsOverZeros() {
        final int[] A = {1, 0, 0, 1, 0, 0, 1};
        assertEquals(4, OverlappingCircles.countPairs(A));
    }
}