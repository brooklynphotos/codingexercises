package photos.brooklyn.practice.codingexercises.java.codility;

public class NumberSolitaire {

    /**
     *
     * @param A size is between 2 and 100,000 incl, each element between -10,000 and 10,000 incl
     * @return
     */
    public int solution(int[] A) {
        /* strategy
         * 1. Fill the array dp from back, dp[N-1]
         * 2. Go back up toward dp[0]
         * 3. for each dp[i], the answer is A[i] + max(dp[i+1], dp[i+2].... dp[i+6])
         * 4. the answer is in dp[0]
         */
        final int[] dp = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                dp[i] = A[i];
            } else {
                dp[i] = A[i] + maxRest(dp, i);
            }
        }
        return dp[0];
    }

    static int maxRest(final int[] dp, final int rootIndex) {
        int max = Integer.MIN_VALUE;
        for (int i = rootIndex + 1; i < Math.min(dp.length, rootIndex + 7); i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
