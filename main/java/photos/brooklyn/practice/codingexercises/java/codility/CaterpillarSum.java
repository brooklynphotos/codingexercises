package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://codility.com/media/train/13-CaterpillarMethod.pdf
 */
public class CaterpillarSum {

    /**
     * there is a back and a front of the caterpillar. We extend the front until we either found the sum
     * or we exceeded the sum, in which case we have to move the back forward a position
     * @param A
     * @param sum
     * @return
     */
    public static boolean canMakeSum(int[] A, int sum) {
        int front = 0, total = 0;
        for (int b = 0; b < A.length; b++) {
            while (front < A.length && total + A[front] <= sum) {
                total += A[front];
                front++;
            }
            if (total == sum) {
                return true;
            }
            // we exceeded the total
            total -= A[b];
        }
        return false;
    }
}
