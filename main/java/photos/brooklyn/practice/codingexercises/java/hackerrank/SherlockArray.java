package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array/problem
 * Two pointers
 */
public class SherlockArray {
    public static String balancedSums(List<Integer> arr) {
        int[] leftSums = new int[arr.size()];
        int[] rightSums = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            leftSums[i] = arr.get(i) + (i == 0 ? 0 : leftSums[i - 1]);
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            rightSums[i] = arr.get(i) + (i == arr.size() - 1 ? 0 : rightSums[i + 1]);
        }
        int i = 0;
        int j = arr.size() - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (i < j - 1) {
            leftSum = leftSums[i];
            rightSum = rightSums[j];
            if (leftSum < rightSum) {
                i++;
            } else {
                j--;
            }
        }
        if (leftSum == rightSum) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
