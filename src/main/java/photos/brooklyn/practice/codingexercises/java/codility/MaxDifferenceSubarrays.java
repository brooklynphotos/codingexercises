package photos.brooklyn.practice.codingexercises.java.codility;

public class MaxDifferenceSubarrays {

    /**
     *
     * @param A |A| between 2 and 100,000, each is between -1e9 and 1e9
     * @return largest difference of max values obtainable in two contiguous non-empty subarrays
     */
    public int solution(int[] A) {
        /*
         * Strategy
         * 1. produce array indicating the max up to the index starting from the left
         * 2. produce array indicating the max up to the index but starting from the right
         * 3. Go through both arrays and find the differences between adjacent indices, return the max difference
         */
        final int[] leftMaxes = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                leftMaxes[i] = A[i];
            } else {
                leftMaxes[i] = Math.max(leftMaxes[i - 1], A[i]);
            }
        }
        final int[] rightMaxes = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                rightMaxes[i] = A[i];
            } else {
                rightMaxes[i] = Math.max(rightMaxes[i + 1], A[i]);
            }
        }
        int absDiff = -1;
        for (int i = 0; i < leftMaxes.length - 1; i++) {
            absDiff = Math.max(absDiff, Math.abs(leftMaxes[i] - rightMaxes[i + 1]));
        }
        return absDiff;
    }

}
