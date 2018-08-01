package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/srin-aadc03/challenges/classic-01-knapsack
 */
public class Knapsack {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int testCases = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<testCases;i++){
            final String l = scanner.nextLine();
            final String[] meta = l.trim().split("\\s+");
            final int S = Integer.parseInt(meta[0]);
            final int N = Integer.parseInt(meta[1]);
            final int[] wts = new int[N];
            final int[] values = new int[N];
            for (int j = 0; j < N; j++) {
                final String[] weightValue = scanner.nextLine().trim().split("\\s+");
                wts[j] = Integer.parseInt(weightValue[0]);
                values[j] = Integer.parseInt(weightValue[1]);
            }
            System.out.println(getMaxValue(S, wts, values));
        }
    }

    public static int getMaxValue(final int W, final int[] wts, final int[] values) {
        final int n = wts.length;
        // table of i's and w's
        final int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wts[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - wts[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }
}
