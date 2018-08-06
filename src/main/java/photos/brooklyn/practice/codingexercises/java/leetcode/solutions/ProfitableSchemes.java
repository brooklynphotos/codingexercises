package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

public class ProfitableSchemes {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        // dp[i][j] number of schemes you can have using i profit and j members
        // final answer would be dp[P][G]
        int[][] dp = new int[P + 1][G + 1];
        // base case: if there is no profit and no one involved, there's one scheme
        dp[0][0] = 1;
        int res = 0, mod = (int)1e9 + 7;
        for (int k = 0; k < group.length; k++) {
            // for crime k, you need g number of people and get p profit
            int g = group[k], p = profit[k];
            // going down the amount of profit until there's no profit
            for (int i = P; i >= 0; i--)
                // start with maximum of G-g because we can only work with a crime that needs no more than G
                // basically you are going from G to g
                for (int j = G - g; j >= 0; j--)
                    // this is a one-liner for:
                    // if (i + p) is smaller than P, than the row to update is just i+p
                    // else it can only be P as that's the ceiling
                    // the column is always j+g
                    // the increment is always dp[i][j]
                    dp[Math.min(i + p, P)][j + g] = (dp[Math.min(i + p, P)][j + g] + dp[i][j]) % mod;
        }
        // so now we only look at all the member requirements for profit P
        // each x represents the number of schemes possible that each would generate at least P profit and require a certain number of people
        // summing all the x's would give you the number of schemes in total for P
        for (int x : dp[P])
            res = (res + x) % mod;
        return res;
    }

}
