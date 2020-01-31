package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import java.util.Arrays;
import java.util.Comparator;

class WorkProfitWinner {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] dp = new int[n][];
        for(int i = 0;i < n;i++){
            dp[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(dp, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0])return a[0] - b[0];
                return -(a[1] - b[1]);
            }
        });
        int[] xs = new int[n];
        for(int i = 0;i < n;i++)xs[i] = dp[i][0];
        for(int i = 1;i < n;i++){
            dp[i][1] = Math.max(dp[i][1], dp[i-1][1]);
        }
        int ret = 0;
        for(int w : worker){
            int ind = Arrays.binarySearch(xs, w);
            if(ind < 0)ind = -ind-2;
            if(ind >= 0){
                ret += dp[ind][1];
            }
        }
        return ret;
    }
}