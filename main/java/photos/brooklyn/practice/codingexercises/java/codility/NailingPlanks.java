package photos.brooklyn.practice.codingexercises.java.codility;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://app.codility.com/programmers/lessons/14-binary_search_algorithm/nailing_planks/
 */
public class NailingPlanks {

    /**
     * @param A the starting point of a plank
     * @param B the ending point of a plank
     * @param C the position of the nail
     * @return minimum first number of C nails needed to nail in all the planks, or -1 if that's not possible
     */
    public int solution(final int[] A, int[] B, int[] C) {
        return byABinarySearchC(A, B, C);
//        return byA(A, B, C);
//        return byC(A, B, C);
    }

    private static int byA(final int[] A, int[] B, int[] C) {
        int topNail = -1;
        for (int i = 0; i < A.length; i++) {
            final int a = A[i];
            final int b = B[i];
            final int nail = findNail(a, b, C);
            if (nail == -1) return -1;
            topNail = Math.max(nail, topNail);
        }
        return topNail + 1;
    }

    private static int byABinarySearchC(final int[] A, int[] B, int[] C) {
        int topNail = -1;
        int[][] CSorted = new int[C.length][2];
        for (int i = 0; i < C.length; i++) {
            CSorted[i][0] = C[i];
            CSorted[i][1] = i;
        }
        Arrays.sort(CSorted, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < A.length; i++) {
            final int nail = findNail(A[i], B[i], CSorted);
            if (nail == -1) return -1;
            topNail = Math.max(nail, topNail);
        }
        return topNail + 1;
    }

    private static int findNail(final int a, final int b, final int[] C) {
        for (int j = 0; j < C.length; j++) {
            final int c = C[j];
            if (c >= a && c <= b) {
                return j;
            }
        }
        return -1;
    }

    private static int findNail(final int a, final int b, final int[][] C) {
        int start = 0;
        int end = C.length - 1;
        while (start <= end) {
            int probe = (end + start) / 2;
            int[] probeVal = C[probe];
            int c = probeVal[0];
            if (c >= a && c <= b) {
                return probeVal[1];
            }
            if (c < a) {
                start = probe + 1;
            } else {
                end = probe - 1;
            }
        }
        return -1;
    }

    private static int byC(final int[] A, int[] B, int[] C) {
        // the range of the ending part
        int start = 0;
        int end = C.length - 1;
        if (start == end) {
            return canDo(A, B, C, end) ? 1 : -1;
        }
        boolean foundOne = false;
        while (start < end) {
            int mid = (end + start) / 2;
            if (canDo(A, B, C, mid)) {
                foundOne = true;
                end = mid;
            } else {
                // mid did not work, so 1 after
                start = mid + 1;
            }
        }
        return foundOne ? end + 1 : -1;
    }

    /**
     * decides if all the planks are nailed for the range of C within [min, end]
     *
     * @param A
     * @param B
     * @param C
     * @param end
     * @return
     */
    static boolean canDo(final int[] A, final int[] B, final int[] C, final int end) {
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];
            if (!canNail(a, b, C, end)) {
                return false;
            }
        }
        return true;
    }

    static boolean canNail(final int start, final int end, final int[] nails, final int lastNail) {
        for (int i = 0; i <= lastNail; i++) {
            final int nail = nails[i];
            if (nail >= start && nail <= end) {
                return true;
            }
        }
        return false;
    }
}
