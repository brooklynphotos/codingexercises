package photos.brooklyn.practice.codingexercises.java.codility;

public class ArrayShift {

    /**
     *
     * @param A |A| between 0 and 100, elements between -1000 and 1000
     * @param K between 0 and 100
     * @return an array whose elements are shifted by K
     */
    public int[] solution(int[] A, int K) {
        final int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int newI = (i + K) % A.length;
            B[newI] = A[i];
        }
        return B;
    }

}
