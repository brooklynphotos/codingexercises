package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountTrianglesTest {

    @Test
    public void solution() {
        final int[] A = {10, 2, 5, 1, 8, 12};
        assertEquals(4, new CountTriangles().solution(A));
    }

    @Test
    public void solutionSimplestNoTriangle() {
        final int[] A = {1,1,3};
        assertEquals(0, new CountTriangles().solution(A));
    }

    @Test
    public void solutionLargest() {
        final int[] A = new int[1000];
        for (int i = 0; i < A.length; i++) {
            A[i] = (i + 1) * 9000;
        }
        assertEquals(82958750, new CountTriangles().solution(A));
    }
}