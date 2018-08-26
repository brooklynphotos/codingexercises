package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/weekly-contest-95/problems/stone-game/
 */
public class StoneGame {
    public boolean stoneGame(int[] piles) {
        return biggestScore(piles, 0, piles.length - 1, 0, new HashMap<>()) > sum(piles) / 2;
    }

    private int sum(final int[] piles) {
        int s = 0;
        for(int x : piles){
            s += x;
        }
        return s;
    }

    private static int biggestScore(final int[] piles, final int start, final int end, final int currentScore, final Map<String, Integer> cache) {
        final String state = start+"-"+end;
        Integer cachedVal = cache.get(state);
        if(cachedVal != null) return cachedVal.intValue();
        if (start + 1 == end) {
            final int bigger = Math.max(piles[start],piles[end]);
            cachedVal = currentScore + bigger;
        }else {
            cachedVal = maxChoice(biggestScore(piles, start + 2, end, currentScore + piles[start], cache),
                    biggestScore(piles, start + 1, end - 1, currentScore + piles[start], cache),
                    biggestScore(piles, start, end - 2, currentScore + piles[end], cache),
                    biggestScore(piles, start + 1, end - 1, currentScore + piles[end], cache)
            );
        }
        cache.put(state, cachedVal);
        return cachedVal;
    }
    public static int maxChoice(final int a, final int... numbers) {
        int max = a;
        for (int n : numbers) {
            max = Math.max(max, n);
        }
        return max;
    }
}
