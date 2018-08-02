package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

/**
 * https://leetcode.com/problems/nth-magical-number/discuss/154613/C++JavaPython-Binary-Search
 */
public class NthMagicNumber {
    /**
     * Find the Nth magic number for A and B
     * @param N
     * @param A
     * @param B
     * @return
     */
    public int nthMagicalNumber(int N, int A, int B) {
        // l = lower bound, just 2 though it can be Math.min(A, B)
        // r = upper bound, some large number, though it can be as small as N*Math.min(A,B)
        long a = A, b = B, tmp, l = 2, r = (long)1e14, mod = (long)1e9 + 7;
        // find the gcd
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        // a is now the gcd
        // binary search between the two bounds
        // divide and pick the range the x could be
        while (l < r) {
            // middle number
            long m = (l + r) / 2;
            // inclusion-exclusion principle: the number of magic numbers <= m is this formula
            // if that is < N, then the answer is in the upper range
            if (m / A + m / B - m / (A * B / a) < N) l = m + 1;
            // else it is in the lower range
            else r = m;
        }
        return (int)(l % mod);
    }
}
