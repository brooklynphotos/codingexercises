package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.math.BigInteger;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */
public class ExtraLongFactorials {
    public static void extraLongFactorials(int n) {
        System.out.print(getExtraLongFactorials(n));
    }
    public static String getExtraLongFactorials(int n) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res.toString();
    }

}
