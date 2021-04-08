package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://app.codility.com/programmers/lessons/14-binary_search_algorithm/nailing_planks/
 */
public class NailingPlanks {

    /**
     *
     * @param A the starting point of a plank
     * @param B the ending point of a plank
     * @param C the position of the nail
     * @return minimum first number of C nails needed to nail in all the planks, or -1 if that's not possible
     */
    public int solution(final int[] A, int[] B, int[] C) {
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
