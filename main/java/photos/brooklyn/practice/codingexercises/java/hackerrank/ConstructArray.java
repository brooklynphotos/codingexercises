package photos.brooklyn.practice.codingexercises.java.hackerrank;

/**
 * https://www.hackerrank.com/challenges/construct-the-array/problem
 */
public class ConstructArray {

    /**
     *
     * @param n
     * @param k at least as big as x, >= 2
     * @param x
     * @return
     */
    public static long countArray(int n, int k, int x) {
        final long MOD = (long) (10e9 + 7);
        // row represents size of the array we want
        // column represents the ending of the array
        // once table is populated, the answer is in dp[n][x]
        final long[][] dp = new long[n][2];
        // for i = 0, meaning array size is 1, it's all zeros except first
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            long prev0 = dp[i - 1][0];
            long prev1 = dp[i - 1][1];
            // the first item is always the sum of all the items in previous row except the above
            // all the items above except the first have the same value
            // so just multiply by k - 1
            dp[i][0] = (prev1 * (k - 1)) % MOD;
            // the second one is previous row item 0 plus the value above it times k - 2
            // because there are k-1 such value but we don't count the one above
            dp[i][1] = (prev0 + ((k - 2) * prev1)) % MOD;
        }
        if (x == 1) {
            return dp[n - 1][0] % MOD;
        }else {
            return dp[n - 1][1] % MOD;
        }
    }
}
