package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/weekly-contest-95/problems/profitable-schemes/
 */
public class ProfitableSchemes {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int count = 0;
        for (int i = 0; i < group.length; i++) {
            final int g = group[i];
            final int p = profit[i];
            final int remainingP = P - p;
            final int remainingG = G - g;
            if(remainingG<0) continue;
            count += (remainingP<=0 ? 1 : 0) + profitableSchemes(remainingG, remainingP, Arrays.copyOfRange(group, i + 1, group.length), Arrays.copyOfRange(profit, i + 1, profit.length));
        }
        return count;
    }
}
