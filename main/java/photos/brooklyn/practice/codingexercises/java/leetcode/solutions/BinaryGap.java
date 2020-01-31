package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

/**
 * https://leetcode.com/problems/binary-gap/discuss/149835/C++JavaPython-Dividing-by-2
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int res = 0;
        // d keeps track of the number of counts since the last odd number encountered
        // it's -32 because you don't want it to go over 0 as you increment d, and no int N would cycle through this
        // more than 32 times
        for (int d = -32; N > 0; N /= 2, d++)
            // when there's an odd number, see if the gap was larger than the current max and reset the gap back to 0
            if (N % 2 == 1) {
                res = Math.max(res, d);
                d = 0;
            }
        return res;
    }
}
