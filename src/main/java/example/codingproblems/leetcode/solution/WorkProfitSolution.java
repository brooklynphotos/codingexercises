package example.codingproblems.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class WorkProfitSolution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[][] arr = new int[difficulty.length][2];
        for(int i=0; i < difficulty.length; i++){
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                return a1[0]<a2[0]? -1: a1[0] == a2[0]? 0:1;
            }
        });
        for(int i=1; i<arr.length; i++){
            arr[i][1] = Math.max(arr[i-1][1], arr[i][1]);
        }
        for(int i=0; i<arr.length; i++){
            map.put(arr[i][0], arr[i][1]);
        }
        int ans = 0;
        for(int i=0; i<worker.length; i++){
            int ability = worker[i];
            Integer index = map.floorKey(ability);
            if(index != null){
                ans+=map.get(index);
            }
        }
        return ans;
    }
}
