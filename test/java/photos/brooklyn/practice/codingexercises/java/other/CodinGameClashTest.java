package photos.brooklyn.practice.codingexercises.java.other;

import org.junit.Test;

import static org.junit.Assert.*;

import static photos.brooklyn.practice.codingexercises.java.other.CodinGameClash.*;

public class CodinGameClashTest {

    @Test
    public void isTwinExample1() {
        assertTrue(isTwin("Marion", "Romain"));
    }

    @Test
    public void isTwinExampleFalse() {
        assertFalse(isTwin("Hello", "world"));
    }

    @Test
    public void isTwinExampleTrue() {
        assertTrue(isTwin("acb", "bac"));
    }

    @Test
    public void isTwinExample2() {
        assertTrue(isTwin("Lookout", "Outlook"));
    }

    @Test
    public void closestToZeroLargeNeg() {
        int[] ints = {-2147483647};
        assertEquals(-2147483647, closestToZero(ints));
    }

    @Test
    public void closestToZeroLargePos() {
        int[] ints = {-2147483647, 2147483647};
        assertEquals(2147483647, closestToZero(ints));
    }

    @Test
    public void closestToZeroNull() {
        int[] ints = null;
        assertEquals(0, closestToZero(ints));
    }

    @Test
    public void closestToZeroEmpty() {
        int[] ints = {};
        assertEquals(0, closestToZero(ints));
    }

    @Test
    public void closestToZeroExample1() {
        int[] ints = { -9, 8, 2, -5, 7 };
        assertEquals(2, closestToZero(ints));
    }

    @Test
    public void closestToZeroPosNeg() {
        int[] ints = { -9, -1, 1, -5, 7 };
        assertEquals(1, closestToZero(ints));
    }

    @Test
    public void closestToZeroNegWin() {
        int[] ints = { -9, -1, 2, -5, 7 };
        assertEquals(-1, closestToZero(ints));
    }

    @Test
    public void scrambleHalfHalfEmpty() {
        assertEquals("", scrambleHalfHalf(""));
    }

    @Test
    public void scrambleHalfHalfOne() {
        assertEquals("x", scrambleHalfHalf("x"));
    }

    @Test
    public void scrambleHalfHalf1() {
        assertEquals("Hleol", scrambleHalfHalf("Hello"));
    }

    @Test
    public void scrambleHalfHalf2() {
        assertEquals("Hleol!", scrambleHalfHalf("Hello!"));
    }

    @Test
    public void getNonMultipleEx1() {
        assertEquals(13, getNonMultiple(new int[]{2, 3}, 1, 5));
    }
}