package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-93/problems/advantage-shuffle/
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        final int[] res = new int[A.length];
        final List<Integer> unfit = new ArrayList<>();
        Arrays.fill(res, -1);
        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            final int x = A[i];
            final int desiredPosition = findMinPartner(x, B, res);
            if(desiredPosition==-1 || res[desiredPosition]>-1){
                unfit.add(x);
            }else{
                res[desiredPosition] = x;
            }
        }
        for(int unfitInt : unfit){
            final int nextEmptyPosition = findNextEmpty(res);
            res[nextEmptyPosition] = unfitInt;
        }
        return res;
    }

    private static int findNextEmpty(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1) return i;
        }
        throw new IllegalArgumentException("No more empty parts");
    }

    private static int findMinPartner(int x, int[] src, int[] res) {
        int diff = Integer.MAX_VALUE;
        int minPartnerIndex = -1;
        for(int i=0;i<src.length;i++){
            final int a = src[i];
            final int thisDiff = x - a;
            if(thisDiff>0 && thisDiff<diff && res[i]==-1){
                diff = thisDiff;
                minPartnerIndex = i;
            }
        }
        return minPartnerIndex;
    }
}
