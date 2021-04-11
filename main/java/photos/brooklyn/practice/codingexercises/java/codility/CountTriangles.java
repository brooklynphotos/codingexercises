package photos.brooklyn.practice.codingexercises.java.codility;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/15-caterpillar_method/count_triangles/
 * solution: https://codility.com/media/train/13-CaterpillarMethod.pdf
 */
public class CountTriangles {

    /**
     * Count all the possible triangles using any three sides in A
     *
     * @param A an array of positive integers, between 0 and 1000, each element being between 1 and 1 million
     * @return 0 if no triangles can be constructed
     */
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        // sorting makes sure we can progress from left to right in the triangle test
        int count = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < A.length; j++) {
                // caterpillar part, k extends until there is no triangle or end of the array
                while (k < A.length && isTriangle(i, j, k, A)) {
                    k++;
                }
                // count is incremented by the distance between j and k because all values in between would form a triangle
                count += k - j - 1;
            }
        }
        return count;
    }

    private static boolean isTriangle(final int i, final int j, final int k, final int[] A) {
        return A[i] + A[j] > A[k];
    }
}
