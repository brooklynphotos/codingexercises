package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/contest/weekly-contest-95/problems/profitable-schemes/
 */
public class ProfitableSchemes {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        if (P <= 0) {
            return 1 + combin(group.length) - 1;
        }
        if(G<=0) return 0;
        final Set<Integer> taken = new HashSet<>();
        int count = 0;
        for (int i = 0; i < group.length; i++) {
            final int g = group[i];
            final int p = profit[i];
            taken.add(i);
            count += profitableSchemes(G - g, P - p, Arrays.copyOfRange(group, i + 1, group.length), Arrays.copyOfRange(profit, i + 1, profit.length));
        }
        return count;
    }

    private static int combin(final int n) {
        return 1 << n;
    }
}
