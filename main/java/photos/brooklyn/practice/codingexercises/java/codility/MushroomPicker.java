package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://codility.com/media/train/3-PrefixSums.pdf
 */
public class MushroomPicker {
    /**
     *
     * @param A
     * @param k at some position 0 or greater
     * @param m number of steps smaller than the size of the array
     * @return
     */
    public static int maxCollection(int[] A, int k, int m) {
        final int[] ps = prefixSums(A);
        int result = 0;
        final int startValue = ps[k];
        // i pointer to the left, j is pointer to the right
        // move pointer to the left first
        for (int i = k - 1; i >= 0; i--) {
            int j = Math.min(A.length - 1, i + (m - (k - i))); // to the right
            result = Math.max(result, startValue - ps[i] + ps[j + 1] - startValue);
        }
        // move pointer to the right first
        for (int j = k + 1; j < A.length; j++) {
            int i = Math.max(0, j - (m - (j - k)));
            result = Math.max(result, startValue - ps[i] + ps[j + 1] - startValue);
        }
        return result;
    }

    private static int[] prefixSums(int[] ints) {
        final int[] ps = new int[ints.length + 1];
        ps[0] = 0;
        for (int i = 0; i < ints.length; i++) {
            ps[i + 1] = ps[i] + ints[i];
        }
        return ps;
    }
}