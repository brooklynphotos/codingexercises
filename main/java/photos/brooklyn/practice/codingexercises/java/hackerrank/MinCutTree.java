package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/cut-the-tree/problem
 */
public class MinCutTree {

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        Set<Integer>[] edgeSets = new Set[data.size()];
        for (List<Integer> edge : edges) {
            Integer a = edge.get(0);
            Integer b = edge.get(1);
            add(edgeSets, a, b);
            add(edgeSets, b, a);
        }
        int[] sums = new int[data.size()];
        findSum(0, sums, edgeSets, data, -1);
        final int largestSum = sums[0];
        int difference = Integer.MAX_VALUE;
        for (int x : sums) {
            difference = Math.min(difference, Math.abs(largestSum - 2 * x));
        }
        return difference;
    }

    private static int findSum(final int n, final int[] sums, final Set<Integer>[] edgeSets, final List<Integer> data, final int parent) {
        int s = 0;
        final Set<Integer> nodes = edgeSets[n];
        if (nodes != null) {
            for (int d : nodes) {
                if (d != parent) {
                    s += findSum(d, sums, edgeSets, data, n);
                }
            }
        }
        sums[n] = s + data.get(n);
        return sums[n];
    }

    private static void add(final Set<Integer>[] edgeSets, final Integer a, final Integer b) {
        Set<Integer> others = edgeSets[a - 1];
        if (others == null) {
            others = new HashSet<>();
            edgeSets[a - 1] = others;
        }
        others.add(b - 1);
    }

}
