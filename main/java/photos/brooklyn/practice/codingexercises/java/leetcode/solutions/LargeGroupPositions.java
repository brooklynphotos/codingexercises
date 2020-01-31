package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0;
        for(int i=0;i<=S.length();i++){
            if(i==S.length() || S.charAt(i) != S.charAt(start)){
                if(i-start>=3) {
                    final List<Integer> pair = new ArrayList<>();
                    pair.add(start);
                    pair.add(i - 1);
                    ans.add(pair);
                }
                start = i;
            }
        }
        return ans;
    }
}
