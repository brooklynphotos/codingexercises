package photos.brooklyn.practice.codingexercises.java.codility;

import java.math.BigInteger;

public class OneCountMultiplication {

    /**
     * Both arguments are between 0 and 1e8
     * @param A
     * @param B
     * @return count number of 1s in the binary rep of the product
     */
    public int solution(int A, int B) {
        /**
         * strategy: since performance isn't an issue, just use java library for large number multiplication
         */
        final BigInteger bigA = BigInteger.valueOf(A);
        final BigInteger bigB = BigInteger.valueOf(B);
        final String binaryProduct = bigA.multiply(bigB).toString(2);
        int ones = 0;
        for (char c : binaryProduct.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        return ones;
    }
}