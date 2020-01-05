package photos.brooklyn.practice.codingexercises.java.codility;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 */
public class MaxProductOfThree {

    /**
     *
     * @param A |A| is between 3 and 100,000 incl, each element being between -1,000 and 1,000 incl
     * @return max product of three numbers from A
     */
    public int solution(int[] A) {
        /* strategy
         * 1. if there are only three numbers, return the product
         * 1. Create two arrays, one for positives, one for negative and zero
         * 2. Sort positives desc, negative asc
         * 3. If there are no positives, we want the product of the final three (biggest) negative numbers
         * 4. If there is one or two positives, return product of the first positive and the first two negative
         * 4. otherwise, the max of (prod of first pos and first two neg or the prod of first three pos)
         */
        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        }
        // A is at least four now
        // sort into the two arrays
        final int[] positives = Arrays.stream(A).boxed().filter(a -> a > 0).sorted(Collections.reverseOrder()).mapToInt(i->i.intValue()).toArray();
        final int[] nonPositives = Arrays.stream(A).filter(a -> a <= 0).sorted().toArray();
        if (positives.length == 0) {
            return nonPositives[nonPositives.length - 1] * nonPositives[nonPositives.length - 2] * nonPositives[nonPositives.length - 3];
        }
        if (positives.length <= 2) {
            return positives[0] * nonPositives[0] * nonPositives[1];
        }
        // now we have at least three positives
        final int pMax = positives[0] * positives[1] * positives[2];
        if (nonPositives.length < 2) {
            return pMax;
        }
        final int pnMax = positives[0] * nonPositives[0] * nonPositives[1];
        return Math.max(pMax, pnMax);
    }

}
