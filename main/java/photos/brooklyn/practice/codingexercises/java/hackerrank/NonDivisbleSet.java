package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
public class NonDivisbleSet {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        final int[] remainders = new int[k];
        for (int n : s) {
            int r = n % k;
            remainders[r]++;
        }
        // zero can have at most 1
        int res = Math.min(remainders[0], 1);
        for (int i = 1; i < (k + 1) / 2; i++) {
            res += Math.max(remainders[i], remainders[k - i]);
        }
        // if there is a middle one, then we take at most 1
        if (k % 2 == 0) {
            res += Math.min(remainders[k / 2], 1);
        }
        return res;
    }

}
