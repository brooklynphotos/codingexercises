package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.*;

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
        // remove parents
        Queue<Integer> children = new LinkedList<>();
        children.add(0);
        while (!children.isEmpty()) {
            int parent = children.poll();
            Set<Integer> kids = edgeSets[parent];
            for (Integer k : kids) {
                edgeSets[k].remove(parent);
                children.add(k);
            }
        }
        int[] sums = new int[data.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        fillStack(stack, data, edgeSets, sums);
        final int largestSum = sums[0];
        int difference = Integer.MAX_VALUE;
        for (int x : sums) {
            difference = Math.min(difference, Math.abs(largestSum - 2 * x));
        }
        return difference;
    }

    private static void fillStack(final Stack<Integer> stack, final List<Integer> data, final Set<Integer>[] edgeSets, final int[] sums) {
        while (!stack.empty()) {
            int top = stack.peek();
            Set<Integer> children = edgeSets[top];
            int childrenSum = 0;
            for (Integer n : children) {
                if (sums[n] == 0) {
                    stack.push(n);
                } else {
                    childrenSum += sums[n];
                }
            }
            if (top == stack.peek()) {
                sums[top] = data.get(top) + childrenSum;
                stack.pop();
            }
        }
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
