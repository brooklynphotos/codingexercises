package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://codility.com/demo/take-sample-test/tape_equilibrium
 */
public class TapeEquilibrium {
    public int solution(int[] A) {
        int total = sum(A);
        int leftSum = A[0]; // there are at least two elements in A
        // new diff = |leftSum - rightSum|
        //          = |leftSum - (total - leftSum)|
        //          = |2 * leftSum - total|
        int diff = calculateDiff(leftSum, total);
        // we already did p==1
        for (int p = 2; p < A.length; p++) {
            int a = A[p - 1];
            leftSum += a;
            diff = Math.min(diff, calculateDiff(leftSum, total));
        }
        return diff;
    }

    private static int calculateDiff(int subTotal, int total) {
        return Math.abs((2 * subTotal) - total);
    }

    private static int sum(int[] A) {
        int s = 0;
        for (int a : A) {
            s += a;
        }
        return s;
    }

}
