package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class TargetIntegerTest {

    @Test
    public void givenUniqueNumbers() {
        final int[] A = {-3, 4, -1, 5};
        assertArrayEquals(new int[]{4,5}, TargetInteger.findPair(A, 9));
    }
    @Test
    public void givenNonUniqueNumbers() {
        final int[] A = {4, -3, 4, -1, 5};
        assertArrayEquals(new int[]{4,4}, TargetInteger.findPair(A, 8));
    }
    @Test
    public void givenOneNumber_mustReturnNull() {
        final int[] A = {4};
        assertNull(TargetInteger.findPair(A, 8));
    }
    @Test
    public void givenTargetAsDouble_mustReturnNull() {
        final int[] A = {4, 9};
        assertNull(TargetInteger.findPair(A, 8));
    }
}