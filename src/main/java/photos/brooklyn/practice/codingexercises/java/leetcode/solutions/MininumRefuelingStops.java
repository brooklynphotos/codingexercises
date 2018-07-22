package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

/**
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/149839/O(N)-Space-DP
 */
public class MininumRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] s) {
        // dp[t] is the farthest we can go with t times refueling, the max for t is the total number of stations
        long[] dp = new long[s.length + 1];
        // startfuel is the farthest we can go with zero refueling
        dp[0] = startFuel;
        for (int i = 0; i < s.length; ++i)
            // for any given station, find the list of dp[t], break if the distance covered by t is less than the
            // distance of the station at i. Note that we start with t=i and go down until t=0, at each step we update
            // the dp[t+1]
            for (int t = i; t >= 0 && dp[t] >= s[i][0]; --t)
                // farthest we can go for t+1 refueling is the bigger of an existing distance
                // or the farthest we can go for t stations plus fuel at this station i
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + s[i][1]);
        // with all the records of t, find the dp[t] that would reach the target, if none then it's -1
        for (int t = 0; t <= s.length; ++t)
            if (dp[t] >= target) return t;
        return -1;
    }

}
