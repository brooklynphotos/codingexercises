package photos.brooklyn.practice.codingexercises.java.codility;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
 * Solution: https://bogdankotzev.com/codility-disc-intersections-java-solution/
 */
public class OverlappingCircles {
    private static final int MAX_INTERSECTIONS = 10_000_000;
    /**
     * Find count of all pairs of intersecting circles
     *
     * @param A radius of the circle at each integral point on the X-axis
     * @return
     */
    public static int countPairs(int[] A) {
        // find the starting and ending points of all circles
        int[] start = new int[A.length];
        int[] end = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            start[i] = i - A[i];
            end[i] = A[i] > Integer.MAX_VALUE - i ? Integer.MAX_VALUE : i + A[i];
        }
        // sort the two independently
        Arrays.sort(start);
        Arrays.sort(end);
        // loop through each starting point
        // compare the value to the value at the current pointer
        // if starting value is less or equal, increment the number of open circles
        // and also increment the overall count by the number of open circles
        // else, decrement the number of current circles and do not increment the overall count
        int count = 0;
        int openCircles = 0;
        int endPointer = 0;
        for (int startPointer = 0; startPointer < start.length; ) {
            int startVal = start[startPointer];
            int endVal = end[endPointer];
            if (startVal <= endVal) {
                count += openCircles;
                if (count > MAX_INTERSECTIONS) {
                    return -1;
                }
                openCircles++;
                startPointer++;
            }else{
                openCircles--;
                endPointer++;
            }
        }
        return count;
    }

}
