package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 * Based on the more efficient algorithm here: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */
public class BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        int i;
        for (i = w.length() - 1; i > 0 && w.charAt(i) <= w.charAt(i - 1); i--);
        if (i <= 0) {
            return "no answer";
        }
        int pivot = i - 1;
        final char pivotChar = w.charAt(pivot);
        // find the last character greater than the pivot
        int j;
        for (j = w.length() - 1; j > 0 && w.charAt(j) <= pivotChar; j--);
        final char x = w.charAt(j);
        final char[] chars = w.toCharArray();
        chars[j] = pivotChar;
        chars[pivot] = x;
        // reverse the suffix
        int m = w.length() - 1;
        int n = i;
        while (n < m) {
            char tmp = chars[n];
            chars[n] = chars[m];
            chars[m] = tmp;
            n++;
            m--;
        }
        return new String(chars);
    }

}
