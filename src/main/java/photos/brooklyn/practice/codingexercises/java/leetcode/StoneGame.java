package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/contest/weekly-contest-95/problems/stone-game/
 */
public class StoneGame {
    private static int callCount;
    public boolean stoneGame(int[] piles) {
        final boolean r = isBigger(piles, 0, piles.length-1,0, sum(piles), new HashMap<>());
        System.out.println(piles.length + "=>" + callCount);
        return r;
    }

    private int sum(final int[] piles) {
        int s = 0;
        for(int x : piles){
            s += x;
        }
        return s;
    }

    private static boolean isBigger(final int[] piles, final int start, final int end, final int currentScore, final int total, final Map<State, Boolean> cache) {
        callCount++;
        if (currentScore > total / 2) {
            return true;
        }
        final State state = new State(start, end, currentScore);
        Boolean cachedVal = cache.get(state);
        if(cachedVal != null) return cachedVal.booleanValue();
        if (start + 1 == end) {
            final int bigger = Math.max(piles[start],piles[end]);
            return currentScore + bigger > total / 2;
        }
        cachedVal = isBigger(piles, start + 2, end, currentScore + piles[start], total, cache)
                || isBigger(piles, start + 1, end - 1, currentScore + piles[start], total, cache)
                || isBigger(piles, start, end - 2, currentScore + piles[end], total, cache)
                || isBigger(piles, start + 1, end - 1, currentScore + piles[end], total, cache);
        cache.put(state, cachedVal);
        return cachedVal;
    }

    private static class State{
        int start;

        public State(final int start, final int end, final int score) {
            this.start = start;
            this.end = end;
            this.score = score;
        }

        int end;
        int score;

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final State state = (State) o;
            return start == state.start &&
                    end == state.end &&
                    score == state.score;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, score);
        }
    }
}
