package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

/**
 * https://leetcode.com/problems/longest-mountain-in-array/discuss/135593/C++JavaPython-1-pass-and-O(1)-space
 */
public class LongestMountain {
    public int longestMountain(int[] A) {
        // the peaks are where both are above zero, and valleys are where both are zero
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) up = down = 0;
            if (A[i - 1] < A[i]) up++;
            if (A[i - 1] > A[i]) down++;
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
        }
        return res;
    }
}
