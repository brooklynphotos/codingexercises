package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
 */
public class MaxProfit {
    public int solution(int[] A) {
        int profit = 0;
        int minVal = 200_001;
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            if (val < minVal) {
                minVal = val;
            } else {
                profit = Math.max(profit, val - minVal);
            }
        }
        return profit;
    }
}
