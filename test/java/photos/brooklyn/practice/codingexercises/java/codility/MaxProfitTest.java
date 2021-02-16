package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProfitTest {

    @Test
    public void exampleSolution() {
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
        assertEquals(356, new MaxProfit().solution(A));
    }

    @Test
    public void singularSolution() {
        int[] A = {23171};
        assertEquals(0, new MaxProfit().solution(A));
    }

    @Test
    public void sameEveryDaySolution() {
        int[] A = {2, 2, 2, 2, 2, 2};
        assertEquals(0, new MaxProfit().solution(A));
    }

    @Test
    public void noSolution() {
        int[] A = {5, 4, 3, 2, 1};
        assertEquals(0, new MaxProfit().solution(A));
    }

    @Test
    public void emptySolution() {
        int[] A = {};
        assertEquals(0, new MaxProfit().solution(A));
    }

}