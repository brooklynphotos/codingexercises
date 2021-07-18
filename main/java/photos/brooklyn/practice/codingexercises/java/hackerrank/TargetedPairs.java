package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.Collections;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/pairs/problem
 * Two pointer greedy algorithm as hinted by the discussion group
 */
public class TargetedPairs {

    /**
     * two
     *
     * @param k   target, positive number less than 10e9
     * @param arr unique positive numbers, at least two
     * @return
     */
    public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        int count = 0;
        int i = 0;
        int j = 1;
        while (j < arr.size()) {
            int diff = arr.get(j) - arr.get(i);
            if (diff == k) {
                count++;
                j++;
            } else if (diff > k) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }
}
