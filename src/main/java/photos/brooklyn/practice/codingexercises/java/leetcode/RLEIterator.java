package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-101/problems/rle-iterator/
 */
public class RLEIterator {
    private final List<CountEntry> countEntries;
    private int currentIndex = 0;
    public RLEIterator(int[] A) {
        countEntries = new ArrayList<>(A.length / 2);
        for (int i = 0; i < A.length; i = i + 2) {
            countEntries.add(new CountEntry(A[i], A[i + 1]));
        }
    }

    public int next(int n) {
        int remainingN = n;
        while (currentIndex < countEntries.size()) {
            final CountEntry ce = countEntries.get(currentIndex);
            if (ce.count == 0) {
                currentIndex++;
                continue;
            }
            final int count = ce.count;
            final int remaining = count - n;
            if (remaining >= 0) {
                ce.count = remaining;
                return ce.number;
            }
            currentIndex++;
            return next(Math.abs(remaining));
        }
        return -1;
    }

    private static class CountEntry {
        private int count;
        private int number;

        private CountEntry(int count, int number) {
            this.count = count;
            this.number = number;
        }
    }

}
