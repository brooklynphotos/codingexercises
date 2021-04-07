package photos.brooklyn.practice.codingexercises.java.codility;

/**
 * https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
 * https://github.com/ZRonchy/Codility/blob/master/Lesson12/MinMaxDivision.java
 */
public class MinMaxDivisionSolution {
    /**
     *
     * @param K number of blocks to divide into, each block is between 0 and N, incl
     * @param M not used, it is the upperbound of elements in A, it is between 0 and 10,000 incl
     * @param A each element is between 0 and M, incl, size is N
     * @return of all the K-block combinations, the combination with smallest "large sum", return that sum
     */
    public int solution(int K, int M, int[] A) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {//get the sum as max, and the largest number as min
            max += A[i];
            min = Math.max(min, A[i]);
        }
        int result = max;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (divisionSolvable(mid, K - 1, A)) {
                max = mid - 1;
                result = mid;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }
    private boolean divisionSolvable(int mid, int k, int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > mid) {
                sum = a[i];
                k--;
            }
            if (k < 0) {
                return false;
            }
        }
        return true;
    }
}
