package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://codility.com/media/train/3-PrefixSums.pdf
 */
public class MushroomPicker {
    public int maxCollection(int[] A, int k, int m) {
        // from k, create prefix sum left and right
        final int[] left = new int[k];
        left[0] = A[k - 1];
        for (int i = k - 1; i >= 0; i--) {
            int j = k - 1 - i;
            left[j] = (j == 0 ? 0 : left[j - 1]) + A[i];
        }
        final int[] right = new int[A.length - k];
        for (int i = k; i < A.length; i++) {
            int j = i - k;
            right[j] = (j == 0 ? 0 : right[j - 1]) + A[i];
        }
        return 1;
    }
}