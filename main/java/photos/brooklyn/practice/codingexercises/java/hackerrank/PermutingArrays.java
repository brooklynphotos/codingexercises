package photos.brooklyn.practice.codingexercises.java.hackerrank;

import java.util.Collections;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/two-arrays/problem
 */
public class PermutingArrays {

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        Collections.sort(A);
        B.sort((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i)+B.get(i) < k) return "NO";
        }
        return "YES";
    }

}
