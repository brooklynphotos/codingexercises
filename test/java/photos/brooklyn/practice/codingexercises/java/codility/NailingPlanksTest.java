package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class NailingPlanksTest {

    @Test
    public void solution() {
        final int[] A = {1, 4, 5, 8};
        final int[] B = {4, 5, 9, 10};
        final int[] C = {4, 6, 7, 10, 2};
        assertEquals(4, new NailingPlanks().solution(A, B, C));
    }

    @Test
    public void solutionNailIsAPoint() {
        final int[] A = {1};
        final int[] B = {1};
        final int[] C = {1, 1};
        assertEquals(1, new NailingPlanks().solution(A, B, C));
    }

    @Test
    public void solution1Nail1Plank() {
        final int[] A = {1};
        final int[] B = {2};
        final int[] C = {1};
        assertEquals(1, new NailingPlanks().solution(A, B, C));
    }

    @Test
    public void solutionNone() {
        final int[] A = {1, 4, 5, 8};
        final int[] B = {4, 5, 9, 10};
        final int[] C = {4, 6, 7, 3, 2};
        assertEquals(-1, new NailingPlanks().solution(A, B, C));
    }

    @Test
    public void canDoTrue() {
        final int[] A = {1, 4, 5, 8};
        final int[] B = {4, 5, 9, 10};
        final int[] C = {4, 6, 7, 10, 2};
        assertTrue(NailingPlanks.canDo(A, B, C, 3));
    }

    @Test
    public void canDoFalse() {
        final int[] A = {1, 4, 5, 8};
        final int[] B = {4, 5, 9, 10};
        final int[] C = {4, 6, 7, 10, 2};
        assertFalse(NailingPlanks.canDo(A, B, C, 0));
    }

    @Test
    public void canNail() {
        final int[] C = {4, 6, 7, 10, 2};
        assertTrue(NailingPlanks.canNail(3, 5, C, 3));
    }
}