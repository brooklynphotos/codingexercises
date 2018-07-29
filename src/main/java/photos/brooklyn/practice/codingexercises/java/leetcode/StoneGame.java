package photos.brooklyn.practice.codingexercises.java.leetcode;

import photos.brooklyn.practice.codingexercises.java.leetcode.utils.ListUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/contest/weekly-contest-95/problems/stone-game/
 */
public class StoneGame {
    private static int callCount;
    public boolean stoneGame(int[] piles) {
//        final boolean r = isBigger(piles, 0, piles.length-1,0, sum(piles), new HashMap<>());
        final int max = biggestScore(piles, 0, piles.length-1,0, new HashMap<>());
        System.out.println(piles.length + "=>" + callCount);
//        return r;
        return max > sum(piles) / 2;
    }

    private int sum(final int[] piles) {
        int s = 0;
        for(int x : piles){
            s += x;
        }
        return s;
    }

    private static int biggestScore(final int[] piles, final int start, final int end, final int currentScore, final Map<State, Integer> cache) {
        callCount++;
        final State state = new State(start, end);
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

    private static class State{

        int start;
        int end;
        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final State state = (State) o;
            return start == state.start &&
                    end == state.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        public State(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

    }
    private static boolean isBigger(final int[] piles, final int start, final int end, final int currentScore, final int total, final Map<StateLong, Boolean> cache) {
        callCount++;
        final StateLong state = new StateLong(start, end, currentScore);
        Boolean cachedVal = cache.get(state);
        if(cachedVal != null) return cachedVal.booleanValue();
        if (start + 1 == end) {
            final int bigger = Math.max(piles[start],piles[end]);
            cachedVal = currentScore + bigger > total / 2;
        }else {
            cachedVal = isBigger(piles, start + 2, end, currentScore + piles[start], total, cache)
                    || isBigger(piles, start + 1, end - 1, currentScore + piles[start], total, cache)
                    || isBigger(piles, start, end - 2, currentScore + piles[end], total, cache)
                    || isBigger(piles, start + 1, end - 1, currentScore + piles[end], total, cache);
        }
        cache.put(state, cachedVal);
        return cachedVal;
    }
    private static class StateLong{
        int start;

        public StateLong(final int start, final int end, final int score) {
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
            final StateLong state = (StateLong) o;
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
