package photos.brooklyn.practice.codingexercises.java.codility;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/15-caterpillar_method/min_abs_sum_of_two/
 */
public class MinAbsSumTwo {

    /**
     * Find the smallest absolute sum of any two numbers
     *
     * @param A non empty array with max size of 100,000, values range from -1 billion to +1 billion
     * @return
     */
    public int solution(int[] A) {
        // sort it first so we know where the negative boundary is
        Arrays.sort(A);
        int negIndex = indexOfLargestNegative(A);
        // there are no negative values
        if (negIndex == -1) {
            return 2 * A[0];
        }
        // there are only negative values
        if (negIndex == A.length - 1) {
            return -(2 * A[A.length - 1]);
        }
        // points to the head of the caterpillar in the positive range
        int result = Math.min(2 * A[negIndex + 1], -(2 * A[negIndex])); // the two border areas
        int catHead = negIndex + 1; // starts with the first positive number
        for (int i = negIndex; i >= 0; i--) {
            int neg = A[negIndex];
            for (int j = catHead; j < A.length; j++) {
                int pos = A[j];
                catHead = j; // sliding the caterpillar head
                int absSum = Math.abs(pos + neg);
                result = Math.min(absSum, result);
                // once we have passed the smallest positive number greater than the abs(neg), there is no point continuing
                if (pos > -neg) break;
            }
        }
        return result;
    }

    private int indexOfLargestNegative(final int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) return i - 1;
        }
        return A.length - 1;
    }
}
