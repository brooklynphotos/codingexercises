package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/weekly-contest-93/problems/reordered-power-of-2/
 */
public class ReorderedPowerOfTwo {
    public boolean reorderedPowerOf2(int N) {
        final long upperLimit = (long)Math.pow(10, 9);
        for(int i=0;;i++){
            final long x= (long)Math.pow(2, i);
            if(x>upperLimit) return false;
            if(areSameDigits(N, x)) return true;
        }
    }

    private static boolean areSameDigits(long a, long b) {
        final char[] astr = Long.toString(a).toCharArray();
        Arrays.sort(astr);
        final char[] bstr = Long.toString(b).toCharArray();
        Arrays.sort(bstr);
        return Arrays.equals(astr, bstr);
    }
}
