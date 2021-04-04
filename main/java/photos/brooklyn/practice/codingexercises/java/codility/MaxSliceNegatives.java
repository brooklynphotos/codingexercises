package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
 */
public class MaxSliceNegatives {
    /**
     * this has negatives and the
     *
     * @param A length of zero or more, if zero, slice sum is zero
     * @return max sum from a slice of this array
     */
    public static final int maxSlice(final int[] A) {
        int maxForEnding = A[0];
        int res = A[0];
        for (int i = 1; i < A.length; i++) {
            final int a = A[i];
            // up to this current value, what is the max
            maxForEnding = Math.max(a, maxForEnding + a);
            res = Math.max(maxForEnding, res);
        }
        return res;
    }
}
