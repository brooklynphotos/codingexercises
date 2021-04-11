package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MinAbsSumTwoTest {

    @Test
    public void solutionExample1() {
        final int[] A = {1, 4, -3};
        assertEquals(1, new MinAbsSumTwo().solution(A));
    }

    @Test
    public void solutionExample2() {
        final int[] A = {-8, 4, 5, -10, 3};
        assertEquals(3, new MinAbsSumTwo().solution(A));
    }

    @Test
    public void solutionSingle() {
        final int[] A = {-8};
        assertEquals(16, new MinAbsSumTwo().solution(A));
    }

    @Test
    public void solutionHighNegCount() {
        final int[] A = new int[100_000];
        A[0] = -1;
        A[1] = 1;
        for (int i = 2; i < A.length; i++) {
            A[i] = -1 * new Random().nextInt(1_000_000_001);
        }
        assertEquals(0, new MinAbsSumTwo().solution(A));
    }

    @Test
    public void solutionHighPositiveCount() {
        final int[] A = new int[100_000];
        A[0] = -1;
        A[1] = 1;
        for (int i = 2; i < A.length; i++) {
            A[i] = new Random().nextInt(1_000_000_001);
        }
        assertEquals(0, new MinAbsSumTwo().solution(A));
    }

    @Test
    public void solutionBalancedParity() {
        final int[] A = new int[100_000];
        A[0] = -1;
        A[1] = 1;
        for (int i = 2; i < A.length; i++) {
            final int v = new Random().nextInt(1_000_000_001);
            A[i] = i % 2 == 0 ? v : -v;
        }
        assertEquals(0, new MinAbsSumTwo().solution(A));
    }

    @Test
    public void solutionOnlyNegs() {
        final int[] A = {-1, -4, -2, -7};
        assertEquals(2, new MinAbsSumTwo().solution(A));
    }

    @Test
    public void solutionOnlyPos() {
        final int[] A = {1, 4, 2, 7};
        assertEquals(2, new MinAbsSumTwo().solution(A));
    }

    @Test
    public void solutionNegSelf() {
        final int[] A = {-1, -4, 20, 27};
        assertEquals(2, new MinAbsSumTwo().solution(A));
    }
}