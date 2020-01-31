package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-84/problems/image-overlap/
 * Assume index in A and B is [0, N * N -1]
 *
 * Loop on A, if value == 1, save its index to LA.
 * Loop on B, if value == 1, save its index to LB.
 * Loop on combination (i, j) of LA and LB, increase count[i - j] by 1.
 * If we slide to make A[i] orverlap B[j], we can get 1 point.
 * Loop on count and return max values.
 */
public class OverlappingSquareMatrices {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; ++i) if (A[i / N][i % N] == 1) LA.add(i);
        for (int i = 0; i < N * N; ++i) if (B[i / N][i % N] == 1) LB.add(i);
        for (int i : LA) for (int j : LB) count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        int res = 0;
        for (int i : count.values()) res = Math.max(res, i);
        return res;
    }

}
