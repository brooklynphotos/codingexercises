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
        /* strategy: https://www.martinkysel.com/codility-maxproductofthree-solution/
         * 1. Sort the array
         * 2. Max of either the two smallest and the largest or the three largest. The former takes care of getting two negative numbers whose product might be big
         */
        // A is at least four now
        // sort into the two arrays
        Arrays.sort(A);
        return Math.max(A[0] * A[1] * A[A.length - 1], A[A.length - 1] * A[A.length - 2] * A[A.length - 3]);
    }
}
