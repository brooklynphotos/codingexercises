package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/contest/weekly-contest-94/problems/length-of-longest-fibonacci-subsequence/
 */
public class LongestFibonacci {
    public int lenLongestFibSubseq(int[] A) {
        final Set<Integer> uniques = Arrays.stream(A).boxed().collect(Collectors.toSet());
        int maxLength = 0;
        for(int i=0;i<A.length; i++){
            final int a1 = A[i];
            if(a1>A[A.length-1]/2) continue;
            for(int j=i+1;j<A.length;j++){
                final int a2 = A[j];
                if((a1+a2)>A[A.length-1]) break;
                final int fibonacciLength = 2 + findFibonacci(a1, a2, uniques);
                maxLength = Math.max(maxLength, fibonacciLength);
            }
        }
        return maxLength>2 ? maxLength : 0;
    }

    private static int findFibonacci(final int a1, final int a2, final Set<Integer> cache) {
        int count = 0;
        int x1 = a1;
        int x2 = a2;
        while(cache.contains(x1+x2)){
            count++;
            final int t = x2;
            x2 = x1 + x2;
            x1 = t;
        }
        return count;
    }
}
