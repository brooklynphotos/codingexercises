package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

/**
 * https://leetcode.com/problems/reordered-power-of-2/discuss/149843/C%2B%2BJavaPython-Straight-Forward/155074
 */
public class ReorderedPowerOfTwo {
    public boolean reorderedPowerOf2(int N) {
        /*
         * c is the counter of all the decimal digits
         * Rearranging digits in a decimal number would not change this counter
         * So loop through all the powers of 2 using << operator and see if its counter looks like c
         */
        for (long i = 0, c = counter(N); i < 32; i++)
            if (counter(1 << i) == c) return true;
        return false;
    }
    public static long counter(int N) {
        long res = 0;
        for (; N > 0; N /= 10)
            res += (long)Math.pow(10, N % 10);
        return res;
    }
}
