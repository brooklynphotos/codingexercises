package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/
 * Solution: https://app.codility.com/demo/results/demoVUMMR9-JH3/
 */
public class MaxDoubleSlice {

    /**
     * like the {@link MaxSlice}, but now we have a break in the middle and so we have two slices
     * The idea is to keep tab of the max slice going lef to right, and another right to left
     * then check which combination would yield the maximum
     *
     * @param A
     * @return
     */
    public static int maxDoubleSlice(final int[] A) {
        // build left to right
        final int[] l2rMax = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            l2rMax[i] = Math.max(0, l2rMax[i - 1] + A[i]);
        }
        // build right to left
        final int[] r2lMax = new int[A.length];
        for (int i = A.length - 2; i >= 0; i--) {
            r2lMax[i] = Math.max(0, r2lMax[i + 1] + A[i]);
        }
        // go through each index to see which combination is max
        int maxDoubleSlice = 0;
        for (int i = 0; i < A.length - 2; i++) {
            maxDoubleSlice = Math.max(maxDoubleSlice, l2rMax[i] + r2lMax[i + 2]);
        }
        return maxDoubleSlice;
    }
}
