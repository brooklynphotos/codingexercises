package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayShiftTest {

    @Test
    public void givenExample1_solutionCorrect() {
        final int[] A = {3, 8, 9, 7, 6};
        final int K = 3;
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, new ArrayShift().solution(A, K));
    }
    @Test
    public void givenExample2_solutionCorrect() {
        final int[] A = {0, 0, 0};
        final int K = 1;
        assertArrayEquals(new int[]{0, 0, 0}, new ArrayShift().solution(A, K));
    }
    @Test
    public void givenExample3_solutionCorrect() {
        final int[] A = {1, 2, 3, 4};
        final int K = 4;
        assertArrayEquals(new int[]{1, 2, 3, 4}, new ArrayShift().solution(A, K));
    }
    @Test
    public void givenEmpty_solutionCorrect() {
        final int[] A = {};
        final int K = 4;
        assertArrayEquals(new int[]{}, new ArrayShift().solution(A, K));
    }
    @Test(timeout = 3)
    public void givenBig_solutionCorrectShort() {
        final int[] A = new int[100];
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        final int K = 99;
        assertEquals(1, new ArrayShift().solution(A, K)[0]);
    }
}