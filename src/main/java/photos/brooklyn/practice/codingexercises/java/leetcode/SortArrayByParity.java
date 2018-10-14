package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/contest/weekly-contest-102/problems/sort-array-by-parity/
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        final int[] res = new int[A.length];
        int e = 0;
        int o = A.length;
        for (int x : A) {
            if (x % 2 == 0) {
                res[e++] = x;
            } else {
                res[--o] = x;
            }
        }
        return res;
    }
}
