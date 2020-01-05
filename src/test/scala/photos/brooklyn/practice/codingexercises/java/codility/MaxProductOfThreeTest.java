package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProductOfThreeTest {

    @Test
    public void givenSample_returnCorrect() {
        final int[] A = {-3, 1, 2, -2, 5, 6};
        assertEquals(60, new MaxProductOfThree().solution(A));
    }
    @Test
    public void givenAllNegatives_returnNegativeClosestToZero() {
        final int[] A = {-1, -2, -3, -4, -5};
        assertEquals(-6, new MaxProductOfThree().solution(A));
    }
    @Test
    public void givenAllPositives_returnMargestProduct() {
        final int[] A = {1, 2, 3, 4, 5};
        assertEquals(60, new MaxProductOfThree().solution(A));
    }
    @Test
    public void givenOnlyThree_returnProduct() {
        final int[] A = {1, 2, 3};
        assertEquals(6, new MaxProductOfThree().solution(A));
    }
    @Test
    public void givenOnlyThreeNegative_returnProduct() {
        final int[] A = {-1, -2, -3};
        assertEquals(-6, new MaxProductOfThree().solution(A));
    }
    @Test
    public void given3N0_return0() {
        final int[] A = {-1, 0, -2, -3};
        assertEquals(0, new MaxProductOfThree().solution(A));
    }
    @Test
    public void givenOnly2P1N_returnProduct() {
        final int[] A = {1, 2, -3};
        assertEquals(-6, new MaxProductOfThree().solution(A));
    }
    @Test
    public void givenOnly1P2N_returnProduct() {
        final int[] A = {1, -2, -3};
        assertEquals(6, new MaxProductOfThree().solution(A));
    }
    @Test
    public void given4N_returnProdLargest() {
        final int[] A = {-9, -1, -2, -3};
        assertEquals(-6, new MaxProductOfThree().solution(A));
    }
    @Test
    public void given1P3N_returnProd1P2N() {
        final int[] A = {1, -2, -3, -1};
        assertEquals(6, new MaxProductOfThree().solution(A));
    }
    @Test
    public void givenOnly2P2N_returnProd1P2N() {
        final int[] A = {7, 1, -2, -3};
        assertEquals(42, new MaxProductOfThree().solution(A));
    }
    @Test
    public void givenOnly2P1N0_return0() {
        final int[] A = {7, 1, 0, -3};
        assertEquals(0, new MaxProductOfThree().solution(A));
    }
    @Test
    public void givenOnly1P2N0_returnProd1P2N() {
        final int[] A = {0, 1, -2, -3};
        assertEquals(6, new MaxProductOfThree().solution(A));
    }
    @Test(timeout = 20)
    public void givenBiggest_returnCorrect() {
        final int[] A = new int[100_000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i % 2 == 0 ? 1000 : -1000;
        }
        assertEquals(1_000_000_000, new MaxProductOfThree().solution(A));
    }
}