package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberSolitaireTest {

    @Test
    public void givenShortTail_returnCorrectMax() {
        final int[] arr = {1, -2, 0, 9, -1, -2};
        assertEquals(9, NumberSolitaire.maxRest(arr, 1));
    }

    @Test
    public void givenLongTail_returnCorrectMax() {
        final int[] arr = {1, -2, 0, 9, -1, -2, -10, 12, 7};
        assertEquals(12, NumberSolitaire.maxRest(arr, 1));
    }

    @Test(timeout = 5)
    public void givenSample_returnExpected() {
        final int[] A = {1, -2, 0, 9, -1, -2};
        assertEquals(8, new NumberSolitaire().solution(A));
    }
    @Test(timeout = 5)
    public void givenAllPos_returnSum() {
        final int[] A = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(28, new NumberSolitaire().solution(A));
    }
    @Test(timeout = 5)
    public void givenMinimumA_returnSum() {
        final int[] A = {1, 3};
        assertEquals(4, new NumberSolitaire().solution(A));
    }
    @Test(timeout = 5)
    public void givenMinimumAWithNeg_returnSum() {
        final int[] A = {1, -3};
        assertEquals(-2, new NumberSolitaire().solution(A));
    }
    @Test(timeout = 5)
    public void givenFewerThan6_returnExpected() {
        final int[] A = {1, -3, 7, -5};
        assertEquals(3, new NumberSolitaire().solution(A));
    }
    @Test(timeout = 5)
    public void givenAlternatingPosNeg_returnSumPosAndLast() {
        final int[] A = {1, -1, 1, -1, 1, -1};
        assertEquals(2, new NumberSolitaire().solution(A));
    }
    @Test(timeout = 19)
    public void givenMaxSizes_returnExpected() {
        final int[] A = new int[100_000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i % 2 == 0 ? 10_000 : -10_000;
        }
        assertEquals(((100_000 / 2) - 1) * 10_000, new NumberSolitaire().solution(A));
    }
}