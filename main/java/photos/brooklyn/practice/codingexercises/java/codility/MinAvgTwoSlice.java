package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 * Solution: https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/
 */
public class MinAvgTwoSlice {
    /**
     * The minimum average can be found in either 2 or 3-size slice. It might also exist in larger slices,
     * but they all can be reduced to either 2 or 3 size slices
     * and we only care about the index
     * @param A
     * @return
     */
    public static int minIndex(int[] A) {
        double avg = 3 * 100_000; // max A[i] can be is 100_000
        int result = 0;
        // check the 2 slices
        for (int i = 0; i < A.length - 1; i++) {
            double newAvg = (A[i] + A[i + 1]) / 2D;
            if (newAvg < avg) {
                avg = newAvg;
                result = i;
            }
        }
        // check the 3 slices
        for (int i = 0; i < A.length - 2; i++) {
            double newAvg = (A[i] + A[i + 1] + A[i + 2]) / 3D;
            if (newAvg < avg) {
                avg = newAvg;
                result = i;
            }
        }
        return result;
    }
}
