package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
 * Solution: https://github.com/jlhuang/codility-lessons/blob/master/lesson%208%20:%20Prime%20and%20composite%20numbers/Flags/solution-flags.pdf
 * The important note here is on the Big O: although there is a loop inside a loop,
 * the outer loop only goes to sqrt(N), and the inner loop only goes up to i,
 * So the sum is actually 1 + 2 + 3 + ... sqrt(N), which is N
 */
public class PeakFlags {
    public int solution(int[] A) {
        int result = 0;
        final int[] nexts = nextPeak(A);
        // i: number of flags to test, only need to go up to the square root of the number of values
        for (int i = 1; i * i < A.length; i++) {
            int num = 0; // for this i, number of flags can be set
            int pos = 0; // current position on A
            // pos can't be more than |A|, and the number of flags we can set can't be more than i itself
            while (pos < A.length && num < i) {
                pos = nexts[pos]; // jump to the next peak
                // if we are past the last peak, no point continuing
                if (pos == -1) {
                    break;
                }
                // at this peak we can increment the position and the count of flags
                pos++; // move on to the next value
                num++; // number of flags can be incremented
            }
            // the result if the max of all the flags found going through the i's
            result = Math.max(result, num);
        }
        return result;
    }

    /**
     * creates an array where at any given i, you know the location of the next peak, or i is actually the peak
     * @param A
     * @return
     */
    private static int[] nextPeak(int[] A) {
        final int[] nexts = new int[A.length];
        final boolean[] peaks = createPeaks(A);
        nexts[A.length - 1] = -1; // there is never a peak for the last value
        // walk backwards starting with the penultimate value
        for (int i = A.length - 2; i >= 0; i--) {
            if (peaks[i]) {
                nexts[i] = i;
            } else {
                nexts[i] = nexts[i + 1];
            }
        }
        return nexts;
    }

    /**
     * an array indicating if it's a peak at i
     * @param A
     * @return
     */
    private static boolean[] createPeaks(int[] A) {
        final boolean[] peaks = new boolean[A.length];
        for (int i = 1; i < A.length - 1; i++) {
            peaks[i] = (A[i] > A[i - 1] && A[i] > A[i + 1]);
        }
        return peaks;
    }
}
