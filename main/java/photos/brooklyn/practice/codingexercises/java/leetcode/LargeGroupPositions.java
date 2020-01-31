package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/contest/weekly-contest-83/problems/positions-of-large-groups/
 */
public class LargeGroupPositions {
    private static class Pair<X,Y>{
        private X x;
        private Y y;

        private Pair(X a, Y b){
            x = a;
            y = b;
        }
    }

    public List<List<Integer>> largeGroupPositions(String str) {
        final List<Pair<Character, int[]>> positions = new ArrayList<>();
        Pair<Character, int[]> lastPosition = null;
        for(int i=0;i<str.length();i++){
            final char c = str.charAt(i);
            // new position found
            if(lastPosition==null || lastPosition.x != c){
                final int[] newPoint = new int[]{i,i};
                lastPosition = new Pair<>(c, newPoint);
                positions.add(lastPosition);
            }else{
                lastPosition.y[1] = i;
            }
        }
        return positions.stream().filter(p -> p.y[1]-p.y[0] >=2).map(p -> Arrays.asList(p.y[0], p.y[1]))
                .collect(Collectors.toList());
    }

}
