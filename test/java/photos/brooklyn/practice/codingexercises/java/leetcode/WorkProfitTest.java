package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorkProfitTest {
    private WorkProfit workProfit = new WorkProfit();

    @Test
    public void maxProfitAssignment() {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};

        assertEquals(100, workProfit.maxProfitAssignment(difficulty, profit, worker));
    }

    @Test
    public void maxProfitAssignmentMin() {
        int[] difficulty = {2};
        int[] profit = {10};
        int[] worker = {4};

        assertEquals(10, workProfit.maxProfitAssignment(difficulty, profit, worker));
    }

    @Test
    public void maxProfitAssignmentTooHard() {
        int[] difficulty = {20,30};
        int[] profit = {10,10};
        int[] worker = {4};

        assertEquals(0, workProfit.maxProfitAssignment(difficulty, profit, worker));
    }

    @Test
    public void maxProfitAssignmentReversed() {
        int[] difficulty = {2,4};
        int[] profit = {20,10};
        int[] worker = {4};

        assertEquals(20, workProfit.maxProfitAssignment(difficulty, profit, worker));
    }

    @Test
    public void maxProfitAssignmentBigger() {
        int[] difficulty =  {66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63};
        int[] profit =      {66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77};
        int[] worker =      {61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16};

        assertEquals(1392, workProfit.maxProfitAssignment(difficulty, profit, worker));
    }
}