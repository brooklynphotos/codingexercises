package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.*;

/**
 * https://leetcode.com/contest/weekly-contest-93/problems/advantage-shuffle/
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        final int[] res = new int[A.length];
        Arrays.fill(res, -1);
        Arrays.sort(A);
        final int[][] reversedB = reverseLookup(B);
        Arrays.sort(reversedB, Comparator.comparingInt(x -> x[0]));
        // find the first in A that is greater than the smallest B
        final List<Integer> tooSmalls = new LinkedList<>();
        // start with the one that is not too small
        int reversedBPos = 0;
        for(int x :A){
            // if we exhausted the items in B, we should just dump the remaining As in the result's empty slots
            if(reversedBPos==reversedB.length){
                final int nextEmptyPosition = findNextEmpty(res);
                if(nextEmptyPosition > -1) res[nextEmptyPosition] = x;
                continue;
            }
            final int[] candidate = reversedB[reversedBPos];
            if(candidate[0]<x){
                res[candidate[1]] = x;
                reversedBPos++;
            }else{
                // x is too small
                tooSmalls.add(x);
            }
        }
        // the ones that were too small will get in the occupied slots
        for(int small : tooSmalls){
            final int nextEmptyPosition = findNextEmpty(res);
            if(nextEmptyPosition==-1) throw new IllegalArgumentException("Didn't expect to find nothing");
            res[nextEmptyPosition] = small;
        }
        return res;
    }

    private static int[][] reverseLookup(int[] arr) {
        final int[][] res = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            res[i] = new int[]{arr[i],i};
        }
        return res;
    }

    private static int findNextEmpty(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1) return i;
        }
        return -1;
    }
}
