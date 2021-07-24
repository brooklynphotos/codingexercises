package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.math.BigInteger;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified/problem
 */
public class FibonacciModified {
    public static String fibonacciModified(int t1, int t2, int n) {
        BigInteger x1 = new BigInteger(Integer.toString(t1));
        BigInteger x2 = new BigInteger(Integer.toString(t2));
        for (int i = 2; i < n; i++) {
            BigInteger tmp = x2;
            x2 = x1.add(x2.pow(2));
            x1 = tmp;
        }
        return x2.toString();
    }

}
