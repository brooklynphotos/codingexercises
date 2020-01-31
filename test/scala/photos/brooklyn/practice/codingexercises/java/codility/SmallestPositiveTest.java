package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestPositiveTest {

    @Test
    public void testAllPositives() {
        final int[] input = {1, 3, 6, 4, 1, 2};
        assertEquals(5, new SmallestPositive().solution(input));
    }
    @Test
    public void testAllNumbers() {
        final int[] input = {-1, 1, 3, 6, 4, 1, 2, -9};
        assertEquals(5, new SmallestPositive().solution(input));
    }
    @Test
    public void testConsec() {
        final int[] input = {1,2,3};
        assertEquals(4, new SmallestPositive().solution(input));
    }
    @Test
    public void testMissing1() {
        final int[] input = {-1, 2, 3, 4};
        assertEquals(1, new SmallestPositive().solution(input));
    }
    @Test
    public void testAllNegs() {
        final int[] input = {-1, -7,-6};
        assertEquals(1, new SmallestPositive().solution(input));
    }
}