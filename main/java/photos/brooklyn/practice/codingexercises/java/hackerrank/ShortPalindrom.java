package photos.brooklyn.practice.codingexercises.java.hackerrank;

/**
 * Using a table of possible palindrom counts
 * https://www.hackerrank.com/challenges/short-palindrome/forum
 */
public class ShortPalindrom {
    public static int shortPalindrome(String s) {
        final int mod = 1_000_000_007;
        final long[] c1 = new long[26];
        final long[][] c2 = new long[26][26];
        final long[][][] c3 = new long[26][26][26];
        final long[][][][] c4 = new long[26][26][26][26];
        for (char c : s.toCharArray()) {
            int co = c - 'a';
            for (int i = 0; i < 26; i++) {
                c4[co][i][i][co] += c3[co][i][i] % mod;
                c3[i][co][co] += c2[i][co] % mod;
                c2[i][co] += c1[i] % mod;
            }
            // frequency
            c1[co]++;
        }
        long total = 0;
        for (long[][][] a : c4) {
            for (long[][] b : a) {
                for (long[] c : b) {
                    for (long x : c) {
                        total += x;
                    }
                }
            }
        }
        return (int) (total % mod);
    }
}
