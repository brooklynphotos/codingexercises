package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
 */
public class MinMaxDivision {
    /**
     *
     * @param K number of blocks to divide into, each block is between 0 and N, incl
     * @param M not used, it is the upperbound of elements in A, it is between 0 and 10,000 incl
     * @param A each element is between 0 and M, incl, size is N
     * @return of all the K-block combinations, the combination with smallest "large sum", return that sum
     */
    public int solution(int K, int M, int[] A) {
        final long[] sums = new long[A.length];
        sums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }
        // sums is now a sorted array
        // loop through K to divide up the array
        final long ASum = sums[A.length - 1];
        long previousSum = 0;
        int currentPointer = -1;
        long largeSum = 0;
        for (int k = 0; k < K; k++) {
            long currentSum = ASum - previousSum;
            // this is the minimum sum we can achieve
            final long minSum = currentSum / (K - k);
            // search for a sums index whose value is closest to this minSum without going over
            // search needs to be for minSum plus previousSum since all the numbers now include that previous sum
            currentPointer = search(sums, minSum + previousSum, currentPointer + 1);
            long newSum = sums[currentPointer];
            largeSum = Math.max(newSum - previousSum, largeSum);
            previousSum = newSum;
        }
        return (int)largeSum;
    }

    static int search(long[] arr, long ceiling, int start) {
        int end = arr.length - 1;
        while (start < end) {
            int divider = (start + end) / 2;
            long dividerV = arr[divider];
            if (dividerV == ceiling || (divider + 1 < arr.length && arr[divider] < ceiling && arr[divider + 1] > ceiling)) {
                return divider;
            }
            if (divider + 1 < arr.length && arr[divider + 1] == ceiling) {
                return divider + 1;
            }
            if (ceiling > dividerV) {
                start = divider;
            } else {
                end = divider;
            }
        }
        return end;
    }
}
