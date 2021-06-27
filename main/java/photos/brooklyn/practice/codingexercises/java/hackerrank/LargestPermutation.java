package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/largest-permutation/problem
 */
public class LargestPermutation {
    public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        final int[] positions = buildPositions(arr);
        int currentMax = arr.size();
        for (int i = 0; i < k; i++) {
            if(swap(currentMax, arr, positions)){
                currentMax--;
            }
            if (currentMax == 0) {
                return arr;
            }
        }
        return arr;
    }

    private static int[] buildPositions(final List<Integer> arr) {
        final int[] positions = new int[arr.size() + 1];
        for (int i = 0; i < arr.size(); i++) {
            positions[arr.get(i)] = i;
        }
        return positions;
    }

    private static boolean swap(final int target, final List<Integer> arr, final int[] positions) {
        int targetPos = positions[target];
        int desiredPos = arr.size() - target;
        if (target == desiredPos) {
            return false;
        }
        int currentValue = arr.get(desiredPos);
        arr.set(desiredPos, target);
        arr.set(targetPos, currentValue);
        positions[target] = desiredPos;
        positions[currentValue] = targetPos;
        return true;
    }


}
