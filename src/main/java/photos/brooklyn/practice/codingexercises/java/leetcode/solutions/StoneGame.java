package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

/**
 * https://leetcode.com/problems/stone-game/discuss/154610/C++JavaPython-DP-or-Just-return-true
 */
public class StoneGame {
    public boolean stoneGame(int[] p) {
        int n = p.length;
        // preparing the table; dp[i][j] represents max difference between you choosing i and j and your opponent doing so
        int[][] dp = new int[n][n];
        // populate the diagonal with the p values
        for (int i = 0; i < p.length; i++) dp[i][i] = p[i];
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
            }
        }
        // so by choosing either the first or the last, will your best be better than your component's
        return dp[0][n - 1] > 0;
    }
}
