package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://codility.com/media/train/7-MaxSlice.pdf
 */
public class MaxSlice {
    /**
     * use dynamic programming
     *
     * @param A length of zero or more, if zero, slice sum is zero
     * @return max sum from a slice of this array
     */
    public static final int maxSlice(final int[] A) {
        int maxForEnding = 0;
        int res = 0;
        for (int a : A) {
            // up to this current value, what is the max
            maxForEnding = Math.max(0, maxForEnding + a);
            res = Math.max(maxForEnding, res);
        }
        return res;
    }
}
